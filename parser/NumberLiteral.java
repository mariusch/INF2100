package parser;

import scanner.Scanner;
import scanner.TokenKind;

/**
 * Created by marius on 22.09.2016.
 */
class NumberLiteral extends UnsignedConstant {
    NumberLiteral(int lNum) {
        super(lNum);
    }

    private int num;

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static NumberLiteral parse(Scanner s) {
        enterParser("while-statm");
        NumberLiteral numLit = new NumberLiteral(s.curLineNum());

        numLit.num = s.curToken.intVal;
        s.skip(TokenKind.intValToken);

        leaveParser("while-statm");
        return numLit;
    }
}
