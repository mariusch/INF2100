package parser;

import main.Main;
import scanner.Scanner;

import static scanner.TokenKind.charValToken;

/**
 * Created by marius on 22.09.2016.
 */
class CharLiteral extends UnsignedConstant {

    private char val;

    CharLiteral(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<char literal> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("'");

        if (val == '\''){
            Main.log.prettyPrint("''");
        } else {
            Main.log.prettyPrint(""+val);
        }

        Main.log.prettyPrint("'");
    }

    static CharLiteral parse(Scanner s) {
        enterParser("char literal");

        CharLiteral cl = new CharLiteral(s.curLineNum());

        cl.val = s.curToken.charVal;
        s.skip(charValToken);

        leaveParser("char literal");
        return cl;
    }
}