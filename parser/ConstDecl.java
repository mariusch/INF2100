package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 *
 * ConstDecl inneholder
 *      name
 *      equalsToken
 *      Constant
 *      semiColonToken
 */
class ConstDecl extends PascalDecl {

    private Constant con;
    private String name;

    ConstDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<const-decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        Main.log.prettyPrint(name);
        Main.log.prettyPrint("=");
        con.prettyPrint();
        Main.log.prettyPrint(";");

    }

    static ConstDecl parse(Scanner s) {

        enterParser("const-decl");
        ConstDecl cd = new ConstDecl(s.curToken.id, s.curLineNum());

        cd.name = s.curToken.id;
        s.readNextToken();
        s.skip(equalToken);
        cd.con = Constant.parse(s);

        s.skip(semicolonToken);

        leaveParser("const-decl");
        return cd;
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
