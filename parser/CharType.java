package parser;

import scanner.Scanner;

/**
 * Created by essi on 09.10.2016.
 */
public class CharType extends Type {
    CharType(int n) {
        super(n);
    }

    public static CharType parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {}
}
