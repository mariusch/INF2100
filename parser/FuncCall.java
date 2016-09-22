package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class FuncCall extends Factor {

    FuncCall(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static FuncCall parse(Scanner s) {
        FuncCall stm = new FuncCall(s.curLineNum());

        return stm;
    }
}
