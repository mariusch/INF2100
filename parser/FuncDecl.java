package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class FuncDecl extends ProcDecl {

    FuncDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static FuncDecl parse(Scanner s) {
        enterParser("while-statm");

        FuncDecl stm = new FuncDecl(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
