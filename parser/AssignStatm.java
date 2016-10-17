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
class AssignStatm extends Statement {

    private Variable variable;
    private Expression expr;

    AssignStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<assign statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        variable.prettyPrint();
        Main.log.prettyPrint(" := ");
        expr.prettyPrint();
        //Main.log.prettyPrintLn();
    }

    static AssignStatm parse(Scanner s) {
        enterParser("assign statm");
        AssignStatm as = new AssignStatm(s.curLineNum());

        as.variable = Variable.parse(s);
        s.skip(assignToken);
        as.expr = Expression.parse(s);

        leaveParser("assign statm");
        return as;
    }
}
