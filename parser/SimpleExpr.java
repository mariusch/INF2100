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

        //Vi må finne ut hva typen til uttrykket er. Det kan være en million ting ...
        //Hvis vi har en term og ikke noe mer kan vi bare si at uttrykket blir typen til termen det inneholder
        //Hvis det inneholder en eller flere term oprs må vi se an hva de er: Er det bare + eller - blir det
        //integer, hvis det inneholder minst en or blir det kanskje boolean? Kompendiet sier ikke hvem som har
        //presedens (s. 47). I dette tilfellet virker det som integer vs boolean gir mest mening, men hva med
        //andre tilfeller der vi møter på dette problemet?

        if (po != null) {
            po.check(curScope, lib);
            type = lib.integerType;
        }

        tList.get(0).check(curScope, lib);
        //Begynner med å anta at vi bare har 1 term. Da kan vi sette type med en gang.

        type = tList.get(0).type;
        //System.out.println("Type: " + type);


        for (int i = 0; i < toList.size(); i++){
            //Sjekk type her fordi den kan være noe annet ...
            toList.get(i).check(curScope, lib);
            if (toList.get(i).opr.equals("or")){
                type = lib.booleanType;
            }

            tList.get(i+1).check(curScope, lib);
            if (type == null) {
                type = lib.integerType;
            }
        }
    }

    @Override
    public String identify() {
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
