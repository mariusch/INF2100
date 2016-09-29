package parser;

import main.*;
import scanner.Scanner;
import scanner.*;

import static scanner.TokenKind.varToken;

/**
 * Created by marius on 22.09.2016.
 */
class VarDeclPart extends PascalSyntax {

    private VarDecl varDecl;

    VarDeclPart(int lNum) {
        super(lNum);
    }


    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static VarDeclPart parse(Scanner s) {
        enterParser("var-decl-part");

        VarDeclPart vdp = new VarDeclPart(s.curLineNum());

        vdp.varDecl = VarDecl.parse(s);
        s.skip(varToken);
        VarDecl.parse(s);



        leaveParser("var-decl-part");
        return vdp;
    }
}
