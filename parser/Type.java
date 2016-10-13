package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

import static scanner.TokenKind.nameToken;

/**
 * Created by essi on 29.09.2016.
 */



public abstract class Type extends PascalSyntax {

    private Type body;

    Type(int n) {
        super(n);
    }

    public static Type parse(Scanner s) {
        enterParser("type");
        Type t = null;

        if (s.curToken.kind == nameToken){
            t.body = TypeName.parse(s);
        } else {
            t.body = ArrayType.parse(s);
        }

        leaveParser("type");
        return t;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {
        body.prettyPrint();
    }
}