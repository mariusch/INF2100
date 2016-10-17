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
class FactorOperator extends Operator {

    private String type;

    FactorOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<factor opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(type);
        Main.log.prettyPrintLn();
    }

    static FactorOperator parse(Scanner s) {
        enterParser("factor opr");
        FactorOperator fo = new FactorOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case multiplyToken:
                fo.type = multiplyToken.name();
                s.skip(multiplyToken);
                break;
            case divToken:
                fo.type = divToken.name();
                s.skip(divToken);
                break;
            case modToken:
                fo.type = modToken.name();
                s.skip(modToken);
                break;
            case andToken:
                fo.type = andToken.name();
                s.skip(andToken);
                break;
            default:
                Main.panic("Her er det noe feil!");
                break;
        }

        leaveParser("factor opr");
        return fo;
    }
}
