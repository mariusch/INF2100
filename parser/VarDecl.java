package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class VarDecl extends PascalDecl {

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static VarDecl parse(Scanner s) {
        enterParser("while-statm");

        //VarDecl stm = new VarDecl(s.curLineNum());

        leaveParser("while-statm");
        return null;
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
