package parser;

import scanner.Scanner;

/**
 * Created by essi on 09.10.2016.
 */
public class ArrayType extends Type {
    ArrayType(int n) {
        super(n);
    }

    public static ArrayType parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {

    }
}
