package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class Negation extends Factor {

    Negation(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Negation parse(Scanner s) {
        Negation stm = new Negation(s.curLineNum());

        return stm;
    }
}
