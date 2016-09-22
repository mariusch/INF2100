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

    static Term parse(Scanner s) {
        Term stm = new Term(s.curLineNum());

        return stm;
    }
}
