package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class VarDecl extends PascalDecl {

    private Type type;
    private String name;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<var decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrint(": ");
        type.prettyPrint();
        Main.log.prettyPrintLn(";");

    }

    static VarDecl parse(Scanner s) {
        enterParser("var decl");

        VarDecl vd = new VarDecl(s.curToken.id, s.curLineNum());

        s.test(nameToken);
        vd.name = s.curToken.id;
        s.skip(nameToken);
        s.skip(colonToken);

        vd.type = Type.parse(s);

        s.skip(semicolonToken);

        leaveParser("var decl");
        return vd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {

    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
