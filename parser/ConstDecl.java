package parser;

import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class ConstDecl extends PascalDecl {

    Constant con;
    String name;

    ConstDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<const-decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static ConstDecl parse(Scanner s) {
        enterParser("const-decl");
        ConstDecl cd = new ConstDecl(s.curToken.id, s.curLineNum());

        cd.name = s.curToken.id;
        s.readNextToken();
        s.skip(commaToken);
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
