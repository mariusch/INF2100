package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class PrefixOperator extends Operator {
    PrefixOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<prefix operator " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static PrefixOperator parse(Scanner s) {
        enterParser("prefix operator");

        PrefixOperator po = new PrefixOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case addToken:
                s.skip(addToken);
                break;
            case subtractToken:
               s.skip(subtractToken);
               break;
        }

        leaveParser("prefix operator");
        return po;
    }
}
