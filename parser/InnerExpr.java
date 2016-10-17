package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
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
        //Main.log.prettyPrintLn();
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
