package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ArrayType extends Type {
    private Constant con;
    private Constant con2;
    private Type type;

    ArrayType(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {

    }

    public static ArrayType parse(Scanner s) {

        enterParser("array type");

        ArrayType at = new ArrayType(s.curLineNum());

        s.skip(TokenKind.arrayToken);
        s.skip(TokenKind.leftBracketToken);
        at.con = Constant.parse(s);
        s.skip(TokenKind.rangeToken);
        at.con2 = Constant.parse(s);
        s.skip(TokenKind.rightBracketToken);
        s.skip(TokenKind.ofToken);
        at.type = Type.parse(s);

        leaveParser("array type");

        return at;
    }

    @Override
    public String identify() {return "<array type> on line " + lineNum;}

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("array [");
        con.prettyPrint();
        Main.log.prettyPrint("..");
        con2.prettyPrint();
        Main.log.prettyPrint("] of ");
        type.prettyPrint();
    }
}
