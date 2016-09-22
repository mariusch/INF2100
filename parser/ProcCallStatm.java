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
        ProcCallStatm stm = new ProcCallStatm(s.curLineNum());

        return stm;
    }
}
