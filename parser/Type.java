package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

import static scanner.TokenKind.nameToken;

/**
 * Created by essi on 29.09.2016.
 */



public abstract class Type extends PascalSyntax {

    Type(int n) {
        super(n);
    }

    public static Type parse(Scanner s) {
        enterParser("type");
        Type t;

        if (s.curToken.kind == nameToken){
            t = TypeName.parse(s);
        } else {
            t = ArrayType.parse(s);
        }

        leaveParser("type");
        return t;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    abstract void prettyPrint();
}