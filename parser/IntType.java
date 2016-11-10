package parser;

import main.CodeFile;
import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class IntType extends Type {

    protected types.Type type;

    IntType(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {
        type = lib.integerType;
    }

    @Override
    void genCode(CodeFile f) {

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
