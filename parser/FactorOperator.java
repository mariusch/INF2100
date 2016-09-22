package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class FactorOperator extends Operator {
    FactorOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static FactorOperator parse(Scanner s) {
        FactorOperator stm = new FactorOperator(s.curLineNum());

        return stm;
    }
}
