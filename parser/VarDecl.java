package parser;

import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class VarDecl extends PascalDecl {

    Type type;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static VarDecl parse(Scanner s) {
        enterParser("var-decl");

        VarDecl vd = new VarDecl(s.curToken.id, s.curLineNum());

        // gjør noe med name token
        s.skip(nameToken);
        //Skip .
        s.skip(dotToken);
        // Parse type
        vd.type = Type.parse(s);
        // skip ;



        leaveParser("var-decl");
        return null;
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
