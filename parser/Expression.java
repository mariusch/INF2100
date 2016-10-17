package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Created by marius on 22.09.2016.
 */
class Expression extends PascalSyntax{

    private SimpleExpr se, se2;
    private RelOperator ro;

    Expression(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<expression> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        se.prettyPrint();
        if (ro != null) {
            ro.prettyPrint();
            se2.prettyPrint();
        }
        //Main.log.prettyPrintLn();
    }

    static Expression parse(Scanner s) {
        enterParser("expression");

        Expression expr = new Expression(s.curLineNum());


        expr.se = SimpleExpr.parse(s);

        if (RelOperator.isRelOpr(s)){
            expr.ro = RelOperator.parse(s);
            expr.se2 = SimpleExpr.parse(s);
        }

        leaveParser("expression");
        return expr;
    }

}
