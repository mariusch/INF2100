package parser;

import scanner.Scanner;

/**
 * Created by essi on 09.10.2016.
 */
public class TypeName extends Type {
    TypeName(int n) {
        super(n);
    }

    public static TypeName parse(Scanner s) {
        return null;
    }

    @Override
    public String identify() {
        return null;
    }

    @Override
    void prettyPrint() {}
}
