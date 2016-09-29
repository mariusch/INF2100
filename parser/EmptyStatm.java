package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
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
    void prettyPrint() {

    }

    static EmptyStatm parse(Scanner s) {
        enterParser("empty-statm");

        EmptyStatm es = new EmptyStatm(s.curLineNum());

        leaveParser("empty-statm");
        return es;
    }
}
