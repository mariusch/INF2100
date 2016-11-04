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


        //FList.get(0) sin check skal vel sette type?
        fList.get(0).check(curScope, lib);

        if (fList.get(0) instanceof UnsignedConstant) {
            System.out.println("Factor typen som fucker er: UnsignedConst");

            if (fList.get(0) instanceof NumberLiteral){
                System.out.println("som igjen er... NumberLiteral");
                type = lib.integerType;
            } else if (fList.get(0) instanceof CharLiteral){
                System.out.println("som igjen er... CharLiteral");
                type = lib.charType;
            } else if (fList.get(0) instanceof NamedConst){
                System.out.println("Named Const");
            }

            //.. kan også være name?

        } else if (fList.get(0) instanceof Variable) {
            System.out.println("Factor typen som fucker er: Variable");
        } else if (fList.get(0) instanceof Variable) {
            System.out.println("Factor typen som fucker er: Variable");
        } else if (fList.get(0) instanceof FuncCall) {
            System.out.println("Factor typen som fucker er: Func call");
        } else if (fList.get(0) instanceof InnerExpr) {
            System.out.println("Factor typen som fucker er: Inner Exp");
        } else if (fList.get(0) instanceof Negation) {
            System.out.println("Factor typen som fucker er: Negation");
        }
        //type = fList.get(0).type;
        // type = fList.get(0).type; denne ble kommentert ut nå, ga null
        //bruk måten over med masse instanceof

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
