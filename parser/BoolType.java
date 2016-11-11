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
class BoolType extends Type {

    BoolType(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {
        type = lib.booleanType;
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    public static BoolType parse(Scanner s) {
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


