package parser;

import main.*;
import scanner.Scanner;
import scanner.*;

import java.util.ArrayList;

import static scanner.TokenKind.varToken;

/**
 * Created by marius on 22.09.2016.
 */
class VarDeclPart extends PascalSyntax {

    private ArrayList<VarDecl> vdList = new ArrayList<>();

    VarDeclPart(int lNum) {
        super(lNum);
    }


    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        Main.log.prettyPrint("variable ");
        for (VarDecl vd : vdList){
            vd.prettyPrint();
        }
    }

    static VarDeclPart parse(Scanner s) {
        enterParser("var-decl-part");

        VarDeclPart vdp = new VarDeclPart(s.curLineNum());

        s.skip(varToken);

        vdp.vdList.add(VarDecl.parse(s));

        while (s.curToken.kind == TokenKind.nameToken){
            vdp.vdList.add(VarDecl.parse(s));
        }



        leaveParser("var-decl-part");
        return vdp;
    }
}
