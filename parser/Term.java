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

        /*
        //Instanceof under er KUN brukt for debug nå
        if (fList.get(0) instanceof UnsignedConstant) {
            System.out.println("Factor type: UnsignedConst");

            if (fList.get(0) instanceof NumberLiteral){
                System.out.println("som igjen er... NumberLiteral");
            } else if (fList.get(0) instanceof CharLiteral){
                System.out.println("som igjen er... CharLiteral");
            } else if (fList.get(0) instanceof NamedConst){
                System.out.println("som igjen er... Named Const");
            }

        } else if (fList.get(0) instanceof Variable) {
            System.out.println("Factor type: Variable");
        } else if (fList.get(0) instanceof FuncCall) {
            System.out.println("Factor type: Func call");
        } else if (fList.get(0) instanceof InnerExpr) {
            System.out.println("Factor type: Inner Exp");
        } else if (fList.get(0) instanceof Negation) {
            System.out.println("Factor type: Negation");
        }
        */


        //Setter Type
        Factor f = fList.get(0);
        f.check(curScope, lib);
        type = f.type;
        type = lib.integerType; //Debug kode
        //System.out.println("Term type er: " + type + " kall på: " + f);

        //Flere factorer? Kjører Check og endrer Type
        for (int i = 0; i < fOList.size(); i++) {
            //Sjekk om annen type ...
            fOList.get(i).check(curScope, lib);
            fList.get(i+1).check(curScope, lib);

            //baserer type på factor opr
            if (fOList.get(i).type.equals("and")) {
                type = lib.booleanType;
            } else {
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
