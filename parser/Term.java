package parser;

import scanner.Scanner;
import java.util.ArrayList;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Term extends PascalSyntax {

    private ArrayList<Factor> fList = new ArrayList<Factor>();
    private ArrayList<FactorOperator> fOList = new ArrayList<FactorOperator>();

    types.Type type;

    Term(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        //Hvis vi bare har en factor, sett type til dennes type? Eller basert på dens egenskaper

        //Hvis vi har en eller flere factor oprs kan det være noe annet

        fList.get(0).check(curScope, lib);
        //type = fList.get(0).type;
        type = fList.get(0).type;

        for (int i = 0; i < fOList.size(); i++){
            //Sjekk om annen type ...
            fOList.get(i).check(curScope, lib);
            fList.get(i+1).check(curScope, lib);

            //baserer type på factor opr
            if (fOList.get(i).type.equals("and")){
                type = lib.booleanType;
            }
            else{
                type = lib.integerType;
            }
        }
    }

    @Override
    public String identify() {
        return "<term> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        fList.get(0).prettyPrint();

        for (int i = 0; i < fOList.size(); i++){
            fOList.get(i).prettyPrint();
            fList.get(i+1).prettyPrint();
        }
    }

    static Term parse(Scanner s) {
        enterParser("term");
        Term term = new Term(s.curLineNum());

        term.fList.add(Factor.parse(s));

        while (s.curToken.kind.isFactorOpr()){
            term.fOList.add(FactorOperator.parse(s));
            term.fList.add(Factor.parse(s));
        }

        leaveParser("term");
        return term;
    }
}
