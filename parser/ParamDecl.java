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

    ParamDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<param decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrint(":");
        tn.prettyPrint();
        Main.log.prettyPrintLn();
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
