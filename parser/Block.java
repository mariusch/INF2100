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
class Block extends PascalSyntax {

    private ConstDeclPart cdp;
    private VarDeclPart vdp;
    private ArrayList<ProcDecl> pdList = new ArrayList<ProcDecl>();
    private StatmList stml;
    protected Program context;

    Block(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<block> on line " + lineNum;
    }

    @Override
    void prettyPrint() {


        if (cdp != null)
            cdp.prettyPrint();

        if (vdp != null)
            vdp.prettyPrint();

        if (!pdList.isEmpty()) {
            for (ProcDecl pd : pdList) {
                /*if (pd instanceof FuncDecl) {
                    Main.log.prettyPrint("function ");
                } else {
                    Main.log.prettyPrint("procedure ");
                }*/

                pd.prettyPrint();
            }
        }
        Main.log.prettyPrintLn("begin");

        Main.log.prettyIndent();
        stml.prettyPrint();
        Main.log.prettyOutdent();

        Main.log.prettyPrint("end");
        //Main.log.prettyPrintLn();

    }

    static Block parse(Scanner s) {
        enterParser("block");

        Block bl = new Block(s.curLineNum());

        if (s.curToken.kind == TokenKind.constToken){
            bl.cdp = ConstDeclPart.parse(s);
        }

        if (s.curToken.kind == TokenKind.varToken){
            bl.vdp = VarDeclPart.parse(s);
        }

        while (s.curToken.kind == TokenKind.functionToken || s.curToken.kind == TokenKind.procedureToken){
            if (s.curToken.kind == TokenKind.functionToken){
                bl.pdList.add(FuncDecl.parse(s));

            } else {
                bl.pdList.add(ProcDecl.parse(s));
            }
        }

        s.skip(TokenKind.beginToken);
        bl.stml = StatmList.parse(s);
        s.skip(TokenKind.endToken);

        leaveParser("block");
        return bl;
    }
}
