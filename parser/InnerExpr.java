package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class InnerExpr extends Factor {

    InnerExpr(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static InnerExpr parse(Scanner s) {
        InnerExpr stm = new InnerExpr(s.curLineNum());

        return stm;
    }
}
