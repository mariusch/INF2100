package parser;

import scanner.Scanner;
import scanner.TokenKind;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class RelOperator extends Operator {
    RelOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<rel-opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static RelOperator parse(Scanner s) {
        enterParser("rel-opr");
        RelOperator ro = new RelOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case equalToken:
                s.skip(equalToken);
                break;
            case notEqualToken:
                s.skip(notEqualToken);
                break;
            case lessToken:
                s.skip(lessToken);
                break;
            case lessEqualToken:
                s.skip(lessEqualToken);
                break;
            case greaterToken:
                s.skip(greaterToken);
                break;
            case greaterEqualToken:
                s.skip(greaterEqualToken);
                break;
        }

        leaveParser("rel-opr");
        return ro;
    }
}