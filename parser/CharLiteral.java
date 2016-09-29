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
        return "<char literal> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static CharLiteral parse(Scanner s) {
        enterParser("char literal");

        CharLiteral stm = new CharLiteral(s.curLineNum());

        leaveParser("char literal");
        return stm;
    }
}