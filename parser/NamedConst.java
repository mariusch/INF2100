package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class NamedConst extends UnsignedConstant {

    NamedConst(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static NamedConst parse(Scanner s) {
        enterParser("while-statm");
        NamedConst stm = new NamedConst(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
