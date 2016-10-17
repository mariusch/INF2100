package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Negation extends Factor {

    private Factor fact;

    Negation(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<negation> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("not ");
        fact.prettyPrint();
        Main.log.prettyPrintLn();

    }

    static Negation parse(Scanner s) {
        enterParser("negation");
        Negation n = new Negation(s.curLineNum());

        s.skip(notToken);
        n.fact = Factor.parse(s);

        leaveParser("negation");
        return n;
    }
}
