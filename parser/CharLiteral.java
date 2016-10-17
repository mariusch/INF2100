package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.charValToken;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
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
            Main.log.prettyPrint("" + val);
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