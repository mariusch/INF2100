package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class Negation extends Factor {

    Factor fact;

    Negation(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static Negation parse(Scanner s) {
        enterParser("while-statm");
        Negation n = new Negation(s.curLineNum());

        s.skip(notToken);
        n.fact = Factor.parse(s);

        leaveParser("while-statm");
        return n;
    }
}
