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

    static SimpleExpr parse(Scanner s) {
        SimpleExpr stm = new SimpleExpr(s.curLineNum());

        return stm;
    }
}
