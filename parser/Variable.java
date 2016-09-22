package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class Variable extends Factor {
    Variable(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Variable parse(Scanner s) {
        Variable stm = new Variable(s.curLineNum());

        return stm;
    }

}
