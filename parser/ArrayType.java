package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ArrayType extends Type {
    protected Constant con;
    protected Constant con2;

    protected parser.Type t;

    ArrayType(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {
        con.check(curScope, lib);
        con2.check(curScope, lib);

        t.check(curScope, lib);
        type = t.type;

        //Check array limit types
        con.type.checkType(con2.type, "array limits", this, "Different types in assignment!");
    }

    @Override
    void genCode(CodeFile f) {
        con.genCode(f);
        con2.genCode(f);
        t.genCode(f);
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
        at.t = Type.parse(s);

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
        t.prettyPrint();
    }
}
