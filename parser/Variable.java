package parser;

import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class Variable extends Factor {
    Expression expr;

    Variable(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static Variable parse(Scanner s) {
        enterParser("variable");

        Variable var = new Variable(s.curLineNum());
        //Gjør noe med name - vil det fungere å bare hoppe til next Token?
        s.readNextToken();


        //Sjekk om nextToken er [
        if (s.nextToken.kind == leftBracketToken) {
            s.skip(leftBracketToken);
            var.expr = Expression.parse(s);
            s.skip(rightBracketToken);
        }


        //Hvis ikke er vi ferdig med variabelen


        leaveParser("variable");
        return var;
    }

}
