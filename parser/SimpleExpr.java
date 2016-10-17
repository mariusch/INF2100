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

    SimpleExpr(int lNum) {
        super(lNum);
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
        //Main.log.prettyPrintLn();
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
