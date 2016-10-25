package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class WhileStatm extends Statement {

    private Expression expr;
    private Statement body;

    WhileStatm(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        //Denne metoden er ferdig fra foiler!
        expr.check(curScope, lib);
        expr.type.checkType(lib.booleanType, "while-test", this,
                "While-test is not Boolean.");
        body.check(curScope, lib);
    }

    @Override
    public String identify() {
        return "<while-statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("while ");
        expr.prettyPrint();
        Main.log.prettyPrintLn(" do ");
        Main.log.prettyIndent();
        body.prettyPrint();
        Main.log.prettyOutdent();
    }


    static WhileStatm parse(Scanner s) {
        enterParser("while-statm");
        WhileStatm ws = new WhileStatm(s.curLineNum());

        s.skip(whileToken);
        ws.expr = Expression.parse(s);
        s.skip(doToken);
        ws.body = Statement.parse(s);

        leaveParser("while-statm");
        return ws;
    }

}