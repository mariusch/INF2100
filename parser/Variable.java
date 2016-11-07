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
class Variable extends Factor {

    private Expression expr;
    private String name;

    PascalDecl vRef;
    types.Type type;

    Variable(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        //Hva kan denne være? For å sjekke at type er satt
        PascalDecl d = curScope.findDecl(name, this);
        System.out.println("Variable sin deklarasjon er: " + d.getClass());
        vRef = d;
        vRef.checkWhetherValue(this);
        //TODO usikkert om den kan være null
        type = vRef.type;
        System.out.println("Vriable type er: " + type);

        if (expr != null)
            expr.check(curScope, lib);
    }

    @Override
    public String identify() {
        return "<variable> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        if (expr != null){
            Main.log.prettyPrint("[");
            expr.prettyPrint();
            Main.log.prettyPrint("]");
        }
    }

    static Variable parse(Scanner s) {
        enterParser("variable");
        Variable var = new Variable(s.curLineNum());

        s.test(nameToken);
        var.name = s.curToken.id;
        s.skip(nameToken);

        if (s.curToken.kind == leftBracketToken) {
            s.skip(leftBracketToken);
            var.expr = Expression.parse(s);
            s.skip(rightBracketToken);
        }

        leaveParser("variable");
        return var;
    }

}
