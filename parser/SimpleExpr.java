package parser;

import main.CodeFile;
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

        if(po!=null){
            po.check(curScope, lib);
        }

        Term left, right;

        left = tList.get(0);
        left.check(curScope, lib);
        type = left.type;

        for (int i = 0; i <tList.size(); i++) {

            if (i < toList.size()) {
                TermOperator to = toList.get(i);
                right = tList.get(i+1);
                right.check(curScope, lib);
                to.left = left;
                to.right = right;
                to.check(curScope, lib);

                type = to.type;
            }
        }
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();

        if (po != null)
            po.genCode(f);

        tList.get(0).genCode(f);

        for (int i = 0; i < toList.size(); i++){
            toList.get(i).genCode(f);
            tList.get(i+1).genCode(f);

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
