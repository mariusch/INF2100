package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class StatmList extends PascalSyntax {

    StatmList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static StatmList parse(Scanner s) {
        enterParser("while-statm");

        StatmList stm = new StatmList(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
