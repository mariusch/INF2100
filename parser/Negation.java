package parser;

import main.CodeFile;
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
    types.Type type;

    Negation(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        fact.check(curScope, lib);
        type = lib.booleanType;
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    @Override
    public String identify() {
        return "<negation> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("not ");
        fact.prettyPrint();

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
