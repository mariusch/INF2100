package parser;

import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
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
        return "<simple-expr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        if (po != null)
            po.prettyPrint();

        tList.get(0).prettyPrint();

        //Litt stygg printmetode for å skrive ut alle påfølgende Term Oprs og deretter Terms.
        //Vi har alt printet første Term og vet at vi alltid vil ha 1 Term mer enn antall Term Oprs.
        for (int i = 0; i < toList.size(); i++){
            toList.get(i).prettyPrint();
            tList.get(i+1).prettyPrint();
        }

    }

    static SimpleExpr parse(Scanner s) {
        enterParser("simple-expr");

        SimpleExpr se = new SimpleExpr(s.curLineNum());





        if (PrefixOperator.isPrefixOpr(s)){
            se.po = PrefixOperator.parse(s);
        }

        se.tList.add(Term.parse(s));




        //Mens current token er en term opr
        while (TermOperator.isTermOpr(s)){
            se.toList.add(TermOperator.parse(s));
            se.tList.add(Term.parse(s));
        }

        leaveParser("simple-expr");
        return se;
    }
}
