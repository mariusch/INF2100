package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class Term extends PascalSyntax {

    Term(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static Term parse(Scanner s) {
        enterParser("while-statm");

        Term stm = new Term(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
