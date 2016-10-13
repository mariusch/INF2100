package parser;

import main.*;
import scanner.*;

import java.util.ArrayList;

import static scanner.TokenKind.*;

class ConstDeclPart extends PascalSyntax {

    private ArrayList <ConstDecl> cdList = new ArrayList<ConstDecl>();
    //Const Decl Part inneholder
    //Et const token
    //En eller flere Const Decl

    ConstDeclPart(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("const ");
        for (ConstDecl cd : cdList){
            cd.prettyPrint();
        }
    }


    static ConstDeclPart parse(Scanner s) {
        enterParser("const-decl-part");

        ConstDeclPart cdp = new ConstDeclPart(s.curLineNum());

        s.skip(TokenKind.constToken);

        cdp.cdList.add(ConstDecl.parse(s));

        while (s.curToken.kind == nameToken){
            cdp.cdList.add(ConstDecl.parse(s));
        }

        leaveParser("const-decl-part");
        return cdp;
    }

}