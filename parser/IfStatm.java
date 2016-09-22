package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class IfStatm extends Statement {

    IfStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static IfStatm parse(Scanner s) {
        enterParser("while-statm");

        IfStatm stm = new IfStatm(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
