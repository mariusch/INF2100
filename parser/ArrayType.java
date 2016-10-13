package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Created by essi on 09.10.2016.
 */
public class ArrayType extends Type {
    Constant con;
    Constant con2;
    Type type;

    ArrayType(int n) {
        super(n);
    }

    public static ArrayType parse(Scanner s) {

        enterParser("array-type");

        ArrayType at = new ArrayType(s.curLineNum());

        s.skip(TokenKind.arrayToken);
        s.skip(TokenKind.leftBracketToken);
        at.con = Constant.parse(s);
        s.skip(TokenKind.rangeToken);
        at.con2 = Constant.parse(s);
        s.skip(TokenKind.rightBracketToken);
        s.skip(TokenKind.ofToken);
        at.type = Type.parse(s);

        leaveParser("array-type");

        return at;
    }

    @Override
    public String identify() {return "<array-type> on line " + lineNum;}

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("array");
        Main.log.prettyPrint("[");
        con.prettyPrint();
        Main.log.prettyPrint("..");
        con2.prettyPrint();
        Main.log.prettyPrint("]");
        Main.log.prettyPrint("of");
        type.prettyPrint();
    }
}
