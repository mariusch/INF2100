package parser;

import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Expression extends PascalSyntax{

    private SimpleExpr se, se2;
    private RelOperator ro;

    protected types.Type type;

    Expression(int lNum) {
        super(lNum);
    }

    /**
     * Her må vi skille mellom operand og operator. "+" er operator(opr), mens "3" er operand(op)
     * @param curScope
     * @param lib
     */
    @Override
    void check(Block curScope, Library lib) {
        se.check(curScope, lib);
        type = se.type;

        if (se2 != null) {

            type = lib.booleanType;

            se2.check(curScope, lib);
            String oprName = ro.opVal;

            System.out.println(se2.identify());
            type.checkType(se2.type, oprName + " operands", this,
                    "Operands to " + oprName + " are of different type!");
            type = lib.booleanType;
        }
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
