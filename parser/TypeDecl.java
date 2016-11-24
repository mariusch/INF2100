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
class TypeDecl extends PascalDecl {

    TypeDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        //declLevel og declOffset
        declOffset =- type.size();
        declLevel = curScope.findDeclLvl();
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
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

    void setType(types.Type t) {
        this.type = t;
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
        where.error(this.name + " is a type, not a function.");
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        where.error(this.name + " is a type, not a procedure.");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        where.error(this.name + " is a type, not a value.");
    }
}
