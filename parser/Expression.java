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

    private types.Type type;

    Expression(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        se.check(curScope, lib);
        type = se.type;
        if (se2 != null) {
            se2.check(curScope, lib);
            String oprName = ro.opVal;
            type.checkType(se2.type, oprName+" operands", this,
                    "Operands to "+oprName+" are of different type!");
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
