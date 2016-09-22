package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class TermOperator extends Operator {

    TermOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static TermOperator parse(Scanner s) {
        TermOperator stm = new TermOperator(s.curLineNum());

        return stm;
    }
}
