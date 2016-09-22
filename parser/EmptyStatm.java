package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class EmptyStatm extends Statement {

    EmptyStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static EmptyStatm parse(Scanner s) {
        EmptyStatm stm = new EmptyStatm(s.curLineNum());

        return stm;
    }
}
