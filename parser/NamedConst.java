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

    static NamedConst parse(Scanner s) {
        NamedConst stm = new NamedConst(s.curLineNum());

        return stm;
    }
}
