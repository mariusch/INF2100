package parser;

import main.CodeFile;
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
class TermOperator extends Operator {

    protected String opr;

    protected Term left, right;

    TermOperator(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        if (opr.equals("or")) {
            type = lib.booleanType;
        } else {
            type = lib.integerType;
        }

        right.type.checkType(left.type, "left " + opr + " operand" , this,
                opr + " is different type.");

        left.type.checkType(right.type, "right " + opr + " operand" , this,
                opr + " is different type.");
    }

    @Override
    void genCode(CodeFile f) {
    }

    @Override
    public String identify() {
        return "<term opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + opr + " ");
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
                Main.error("no token match in term opr");
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
