package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

/* <while-statm> ::= ’while’ <expression> ’do’ <statement> */
class WhileStatm extends Statement {

    private Expression expr;
    private Statement body;

    WhileStatm(int lNum) {
        super(lNum);
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
        //Main.log.prettyPrintLn();
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