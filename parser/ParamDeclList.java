package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;
import java.util.ArrayList;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ParamDeclList extends PascalSyntax {

    protected ArrayList<ParamDecl> pdList = new ArrayList<ParamDecl>();

    ParamDeclList(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        for (ParamDecl p : pdList) {
            p.check(curScope, lib);
        }
    }

    @Override
    void genCode(CodeFile f) {
        pdList.get(0).genCode(f);

        for (int i = 1; i < pdList.size(); i++){
            pdList.get(i).genCode(f);
        }
    }

    @Override
    public String identify() {
        return "<param decl list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("(");

        pdList.get(0).prettyPrint();

        for (int i = 1; i < pdList.size(); i++){
            Main.log.prettyPrint("; ");
            pdList.get(i).prettyPrint();
        }
        
        Main.log.prettyPrint(")");
    }

    static ParamDeclList parse(Scanner s) {
        enterParser("param decl list");
        ParamDeclList pdl = new ParamDeclList(s.curLineNum());

        s.skip(TokenKind.leftParToken);
        pdl.pdList.add(ParamDecl.parse(s));

        while(s.curToken.kind == TokenKind.semicolonToken){
            s.skip(TokenKind.semicolonToken);
            pdl.pdList.add(ParamDecl.parse(s));
        }

        s.skip(TokenKind.rightParToken);

        leaveParser("param decl list");
        return pdl;
    }

}
