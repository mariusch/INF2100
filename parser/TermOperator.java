package parser;

import main.Main;
import scanner.Scanner;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class TermOperator extends Operator {

    private String opr;

    TermOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<term opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + opr + " ");
        //Main.log.prettyPrintLn();
    }

    static TermOperator parse(Scanner s) {
        enterParser("term opr");

        TermOperator to = new TermOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case addToken:
                to.opr = "+";
                s.skip(addToken);
                break;
            case subtractToken:
                to.opr = "-";
                s.skip(subtractToken);
                break;
            case orToken:
                to.opr = "or";
                s.skip(orToken);
                break;
            default:
                Main.panic("Her er det noe feil!");
                break;
        }

        leaveParser("term opr");
        return to;
    }

    static boolean isTermOpr(Scanner s){

        switch (s.curToken.kind) {
            case addToken:
                return true;
            case subtractToken:
                return true;
            case orToken:
                return true;
            default:
                return false;
        }
    }
}
