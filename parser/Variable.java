package parser;

import main.CodeFile;
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

    protected PascalDecl vRef;

    Variable(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        PascalDecl d = curScope.findDecl(name, this);
        vRef = d;
        vRef.checkWhetherValue(this);
        type = vRef.type;
        //type = lib.integerType; //Debug kode
        System.out.println("Factor er: " + d.getClass() + " navn: " + name + " med type " + vRef.type + " " + d.identify());


        if (expr != null)
            expr.check(curScope, lib);
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
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
