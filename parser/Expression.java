package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class Expression extends PascalSyntax{


    Expression(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Expression parse(Scanner s) {
        Expression stm = new Expression(s.curLineNum());

        return stm;
    }

}
