package parser;

import scanner.Scanner;
import scanner.TokenKind;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class NumberLiteral extends UnsignedConstant {

    private int num;

    NumberLiteral(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<numeric literal> on line " + lineNum;
    }

    @Override
    void prettyPrint() {


    }

    static NumberLiteral parse(Scanner s) {
        enterParser("numeric literal");
        NumberLiteral numLit = new NumberLiteral(s.curLineNum());

        numLit.num = s.curToken.intVal;
        s.skip(TokenKind.intValToken);

        if (s.curToken.kind == intValToken) {

        }

        leaveParser("numeric literal");
        return numLit;
    }
}
