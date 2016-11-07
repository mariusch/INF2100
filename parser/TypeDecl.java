package parser;

import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class TypeDecl extends PascalDecl {

    protected types.Type type;

    TypeDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

    }

    @Override
    public String identify() {
        if (lineNum < 0){
            return "<type decl> " + name + " in the library";
        }
        return "<type decl> " + name + " on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    void setType(types.Type type) {
        this.type = type;
    }

    static TypeDecl parse(Scanner s) {
        enterParser("type decl");

        leaveParser("type decl");
        return null;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a type.");
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
