package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class FactorOperator extends Operator {
    FactorOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<factor opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static FactorOperator parse(Scanner s) {
        enterParser("factor opr");
        FactorOperator fo = new FactorOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case multiplyToken:
                s.skip(multiplyToken);
                break;
            case divToken:
                s.skip(divToken);
                break;
            case modToken:
                s.skip(modToken);
                break;
            case andToken:
                s.skip(andToken);
                break;
        }

        leaveParser("factor opr");
        return fo;
    }
}
