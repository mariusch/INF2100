package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class SimpleExpr extends PascalSyntax {

    SimpleExpr(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static SimpleExpr parse(Scanner s) {
        enterParser("while-statm");

        SimpleExpr stm = new SimpleExpr(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
