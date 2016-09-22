package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class CompoundStatm extends Statement {

    CompoundStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static CompoundStatm parse(Scanner s) {
        CompoundStatm stm = new CompoundStatm(s.curLineNum());

        return stm;
    }
}
