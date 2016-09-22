package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class TypeDecl extends PascalDecl {

    TypeDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static TypeDecl parse(Scanner s) {
        TypeDecl stm = new TypeDecl(s.curLineNum());

        return stm;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {

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
