package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class RelOperator extends Operator {

    private String opVal;

    RelOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<rel opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + opVal + " ");
    }

    static RelOperator parse(Scanner s) {
        enterParser("rel opr");
        RelOperator ro = new RelOperator(s.curLineNum());
        ro.opVal = s.curToken.kind + "";

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
            default:
                Main.panic("Her er det noe feil!");
                break;
        }

        leaveParser("rel opr");
        return ro;
    }

    static boolean isRelOpr(Scanner s) {
        switch (s.curToken.kind) {
            case equalToken:
                return true;
            case notEqualToken:
                return true;
            case lessToken:
                return true;
            case lessEqualToken:
                return true;
            case greaterToken:
                return true;
            case greaterEqualToken:
                return true;
            default:
                return false;
        }
    }
}
