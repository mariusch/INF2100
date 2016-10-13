package parser;

import scanner.Scanner;

/**
 * Created by essi on 29.09.2016.
 */



public abstract class Type extends PascalSyntax {
    Type(int n) {
        super(n);
    }


    public static Type parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    abstract void prettyPrint();
}