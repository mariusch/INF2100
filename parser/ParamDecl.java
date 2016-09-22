package parser;

import scanner.Scanner;
import types.TypeName;

import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
/* <paramDecl> ::= <name> ’:’ <type name> */
class ParamDecl extends PascalDecl {

    String name;
    TypeName tn;

    ParamDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<paramDecl> on line " + lineNum;
    }

    static ParamDecl parse(Scanner s) {
        enterParser("param-decl");
        ParamDecl pd = new ParamDecl(s.curToken.id, s.curLineNum());

        s.test(nameToken);
        pd.name = "";
        s.skip(colonToken);

        leaveParser("param-decl");
        return pd;
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
