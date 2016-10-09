package parser;

import scanner.Scanner;

/**
 * Created by essi on 09.10.2016.
 */
public class BoolType extends Type {

    BoolType(int n) {
        super(n);
    }

    public static BoolType parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {}
}


