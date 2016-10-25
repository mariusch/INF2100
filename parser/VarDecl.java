package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class VarDecl extends PascalDecl {

    private Type type;
    private String name;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        type.check(curScope, lib);
        curScope.addDecl(name, this);
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
        Main.log.prettyPrintLn("; ");
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
        //This method should be empty
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
