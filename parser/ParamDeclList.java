package parser;

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

    private ArrayList<ParamDecl> pdList = new ArrayList<ParamDecl>();

    ParamDeclList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<param decl list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("(");

        for (ParamDecl pd : pdList) {
            pd.prettyPrint();
            Main.log.prettyPrint(";");
        }
        
        Main.log.prettyPrint(")");
        Main.log.prettyPrintLn();
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
