package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class Program extends PascalDecl {

    Program(String id, int lNum) {
        super(id, lNum);
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

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Program parse(Scanner s) {
        enterParser("while-statm");

        //Program stm = new Program(s.curLineNum());

        leaveParser("while-statm");
        return null;
    }
}
