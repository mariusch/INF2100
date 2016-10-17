package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class Variable extends Factor {

    private Expression expr;
    private String name;

    Variable(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<variable> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrintLn();
        if (expr != null){
            Main.log.prettyPrint("[");
            expr.prettyPrint();
            Main.log.prettyPrint("]");
            Main.log.prettyPrintLn();
        }
    }

    static Variable parse(Scanner s) {
        enterParser("variable");
        Variable var = new Variable(s.curLineNum());


        s.test(nameToken);
        var.name = s.curToken.id;
        s.skip(nameToken);



        //Sjekk om nextToken er [, hvis ikke er vi ferdig med variabelen
        if (s.curToken.kind == leftBracketToken) {

            s.skip(leftBracketToken);
            var.expr = Expression.parse(s);
            s.skip(rightBracketToken);
        }

        leaveParser("variable");
        return var;
    }

}
