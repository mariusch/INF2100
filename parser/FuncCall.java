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

    @Override
    void prettyPrint() {

    }

    static FuncCall parse(Scanner s) {
        enterParser("while-statm");

        FuncCall stm = new FuncCall(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
