package parser;

import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
 *
 * Må inneholde
    * Venstre parentes
    * Minst et param decl
    * Kan inneholde flere param decl såfremt det er et semikolon mellom dem
 */
class ParamDeclList extends PascalSyntax {

    private ArrayList<ParamDecl> pdList = new ArrayList<ParamDecl>();

    ParamDeclList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<param-decl-list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static ParamDeclList parse(Scanner s) {
        enterParser("param-decl-list");
        ParamDeclList pdl = new ParamDeclList(s.curLineNum());

        s.skip(TokenKind.leftParToken);

        pdl.pdList.add(ParamDecl.parse(s));


        //Hvis semikolon skal vi se etter flere param decl
        while(s.curToken.kind == TokenKind.semicolonToken){
            s.skip(TokenKind.semicolonToken);
            pdl.pdList.add(ParamDecl.parse(s));
        }

        s.skip(TokenKind.rightParToken);


        leaveParser("param-decl-list");
        return pdl;
    }

}
