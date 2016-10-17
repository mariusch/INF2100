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
class InnerExpr extends Factor {

    private Expression expr;

    InnerExpr(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<inner expr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("(");
        expr.prettyPrint();
        Main.log.prettyPrint(")");
    }

    static InnerExpr parse(Scanner s) {
        enterParser("inner expr");
        InnerExpr stm = new InnerExpr(s.curLineNum());

        s.skip(leftParToken);
        stm.expr = Expression.parse(s);
        s.skip(rightParToken);

        leaveParser("inner expr");
        return stm;
    }
}
