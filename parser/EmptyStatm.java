package parser;

import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class EmptyStatm extends Statement {

    EmptyStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<empty statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {}

    static EmptyStatm parse(Scanner s) {
        enterParser("empty statm");

        EmptyStatm es = new EmptyStatm(s.curLineNum());

        leaveParser("empty statm");
        return es;
    }
}
