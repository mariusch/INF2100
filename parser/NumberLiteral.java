package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class NumberLiteral extends UnsignedConstant {
    NumberLiteral(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static NumberLiteral parse(Scanner s) {
        enterParser("while-statm");
        NumberLiteral stm = new NumberLiteral(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
