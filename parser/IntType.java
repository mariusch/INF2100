package parser;

import scanner.Scanner;

/**
 * Created by essi on 09.10.2016.
 */
public class IntType extends Type {

    IntType(int n) {
        super(n);
    }

    public static IntType parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {}
}
