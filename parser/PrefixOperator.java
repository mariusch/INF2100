package parser;

import main.Main;
import scanner.Scanner;

import java.security.PrivateKey;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class PrefixOperator extends Operator {

    private String type;

    PrefixOperator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<prefix operator " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(type);

    }

    static PrefixOperator parse(Scanner s) {
        enterParser("prefix operator");

        PrefixOperator po = new PrefixOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case addToken:
                s.skip(addToken);
                po.type = "+";
                break;
            case subtractToken:
               s.skip(subtractToken);
                po.type = "-";
               break;
        }

        leaveParser("prefix operator");
        return po;
    }

    static boolean isPrefixOpr(Scanner s){
        switch (s.curToken.kind) {
            case addToken:
                return true;
            case subtractToken:
                return true;
            default:
                return false;
        }
    }
}
