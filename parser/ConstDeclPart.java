package parser;

import main.*;
import scanner.*;
import java.util.ArrayList;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ConstDeclPart extends PascalSyntax {

    private ArrayList <ConstDecl> cdList = new ArrayList<ConstDecl>();

    ConstDeclPart(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<const decl part> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("const ");
        Main.log.prettyPrintLn();

        for (ConstDecl cd : cdList){
            cd.prettyPrint();
            Main.log.prettyPrintLn();
        }
    }


    static ConstDeclPart parse(Scanner s) {
        enterParser("const decl part");
        ConstDeclPart cdp = new ConstDeclPart(s.curLineNum());

        s.skip(TokenKind.constToken);
        cdp.cdList.add(ConstDecl.parse(s));

        while (s.curToken.kind == nameToken){
            cdp.cdList.add(ConstDecl.parse(s));
        }

        leaveParser("const decl part");
        return cdp;
    }

}