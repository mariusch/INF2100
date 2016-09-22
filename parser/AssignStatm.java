package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class AssignStatm extends Statement {

    AssignStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static AssignStatm parse(Scanner s) {
        enterParser("while-statm");
        AssignStatm stm = new AssignStatm(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
