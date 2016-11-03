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
class SimpleExpr extends PascalSyntax {

    private PrefixOperator po;
    private ArrayList<Term> tList = new ArrayList<Term>();
    private ArrayList<TermOperator> toList = new ArrayList<TermOperator>();

    protected types.Type type;

    SimpleExpr(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        type = lib.integerType;

        if (po != null) {
            po.check(curScope, lib);
            type = lib.integerType;
        }

        //Sjekker om det bare er én term
        System.out.println("Term opr er: " + toList.size());
        System.out.println("Term er: " + tList.size());
        if (toList.size() == 0) {
            System.out.println("KOM HIT");
            tList.get(0).check(curScope, lib);
            System.out.println("DETTE ER TYPE SOM BLIR SATT: " + tList.get(0).type);
            type = tList.get(0).type;
        } else {
            //tar første
            tList.get(0).check(curScope, lib);

            //Sjekker resten i loop
            for (int i = 0; i < toList.size(); i++) {
                //Sjekk type her fordi den kan være noe annet ...
                toList.get(i).check(curScope, lib);
                if (toList.get(i).opr.equals("or")) {
                    type = lib.booleanType;
                }

                tList.get(i + 1).check(curScope, lib);
                if (type == null) {
                    type = lib.integerType;
                }
            }

        }


    }

    @Override
    public String identify() {

        System.out.println(tList.size());
        for (Term t : tList ) {
            t.identify();
        }

        return "<simple expr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        if (po != null)
            po.prettyPrint();

        tList.get(0).prettyPrint();

        for (int i = 0; i < toList.size(); i++){
            toList.get(i).prettyPrint();
            tList.get(i+1).prettyPrint();

        }
    }

    static SimpleExpr parse(Scanner s) {
        enterParser("simple expr");
        SimpleExpr se = new SimpleExpr(s.curLineNum());

        if (PrefixOperator.isPrefixOpr(s))
            se.po = PrefixOperator.parse(s);

        se.tList.add(Term.parse(s));

        while (TermOperator.isTermOpr(s)){
            se.toList.add(TermOperator.parse(s));
            se.tList.add(Term.parse(s));
        }

        leaveParser("simple expr");
        return se;
    }
}
