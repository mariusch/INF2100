package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class ProcDecl extends PascalDecl {

    ProcDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static ProcDecl parse(Scanner s) {
        ProcDecl stm = new ProcDecl(s.curLineNum());

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
