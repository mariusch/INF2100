package parser;

import scanner.Scanner;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class TermOperator extends Operator {

    TermOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<term-opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static TermOperator parse(Scanner s) {
        enterParser("term-opr");

        TermOperator to = new TermOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case addToken:
                s.skip(addToken);
                break;
            case subtractToken:
                s.skip(subtractToken);
                break;
            case orToken:
                s.skip(orToken);
                break;
        }

        leaveParser("term-opr");
        return to;
    }
}
