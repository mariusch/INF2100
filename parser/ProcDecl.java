package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ProcDecl extends PascalDecl {

    private String name;
    private ParamDeclList pdl;
    private Block block;

    ProcDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<proc decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("procedure ");
        Main.log.prettyPrint(name);

        if (pdl != null)
            pdl.prettyPrint();

        Main.log.prettyPrintLn(";");
        block.prettyPrint();
        Main.log.prettyPrint(";");
        Main.log.prettyPrintLn();
    }

    static ProcDecl parse(Scanner s) {
        enterParser("proc decl");
        ProcDecl pd = new ProcDecl(s.curToken.id, s.curLineNum());

        s.skip(TokenKind.procedureToken);
        s.test(TokenKind.nameToken);
        pd.name = s.curToken.id;
        s.skip(TokenKind.nameToken);

        if (s.curToken.kind == TokenKind.leftParToken)
            pd.pdl = ParamDeclList.parse(s);

        s.skip(TokenKind.semicolonToken);
        pd.block = Block.parse(s);
        s.skip(TokenKind.semicolonToken);

        leaveParser("proc decl");
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
