package parser;

import main.CodeFile;
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

    protected int constVal;

    CharLiteral(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        type = lib.charType;
        constVal = (int) val;
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
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