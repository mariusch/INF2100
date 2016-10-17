package parser;

import main.*;
import scanner.Scanner;
import scanner.*;

import java.util.ArrayList;

import static scanner.TokenKind.varToken;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class VarDeclPart extends PascalSyntax {

    private ArrayList<VarDecl> vdList = new ArrayList<VarDecl>();

    VarDeclPart(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<var decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        Main.log.prettyPrintLn("var");
        Main.log.prettyIndent();
        for (VarDecl vd : vdList){

            vd.prettyPrint();
            //Main.log.prettyPrintLn();
        }
        Main.log.prettyOutdent();
    }

    static VarDeclPart parse(Scanner s) {
        enterParser("var decl part");
        VarDeclPart vdp = new VarDeclPart(s.curLineNum());

        s.skip(varToken);
        vdp.vdList.add(VarDecl.parse(s));

        while (s.curToken.kind == TokenKind.nameToken){
            vdp.vdList.add(VarDecl.parse(s));
        }

        leaveParser("var decl part");
        return vdp;
    }
}
