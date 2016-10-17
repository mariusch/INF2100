package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
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
        Main.log.prettyPrintLn();
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
