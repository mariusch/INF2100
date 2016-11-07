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
class ParamDecl extends PascalDecl {

    private String name;
    private TypeName tn;

    types.Type type;

    ParamDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);
        tn.check(curScope, lib);

        System.out.println("TypeName er: " + tn.type);
        type = tn.type;
        System.out.println("Param Decl er: " + tn.type);
    }

    @Override
    public String identify() {
        return "<param decl> " + name + " on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrint(": ");
        tn.prettyPrint();
    }

    static ParamDecl parse(Scanner s) {
        enterParser("param decl");
        ParamDecl pd = new ParamDecl(s.curToken.id, s.curLineNum());

        s.test(nameToken);
        pd.name = s.curToken.id;
        s.skip(nameToken);
        s.skip(colonToken);
        pd.tn = TypeName.parse(s);

        leaveParser("param decl");
        return pd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a param.");
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {
        where.error(this.name + " is a param, not a function.");

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        where.error(this.name + " is a param, not a procedure.");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        //?

    }
}
