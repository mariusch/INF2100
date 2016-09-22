package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class CharLiteral extends UnsignedConstant {

    CharLiteral(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static CharLiteral parse(Scanner s) {
        CharLiteral stm = new CharLiteral(s.curLineNum());

        return stm;
    }
}