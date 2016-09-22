package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class ProcCallStatm extends Statement {

    ProcCallStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static ProcCallStatm parse(Scanner s) {
        enterParser("while-statm");
        ProcCallStatm stm = new ProcCallStatm(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
