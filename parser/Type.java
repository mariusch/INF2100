package parser;

import scanner.Scanner;
import static scanner.TokenKind.nameToken;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
abstract class Type extends PascalSyntax {

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