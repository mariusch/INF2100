package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class RelOperator extends Operator {
    RelOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static RelOperator parse(Scanner s) {
        enterParser("while-statm");

        RelOperator stm = new RelOperator(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
