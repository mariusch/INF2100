package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class PrefixOperator extends Operator {
    PrefixOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static PrefixOperator parse(Scanner s) {
        enterParser("while-statm");

        PrefixOperator stm = new PrefixOperator(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
