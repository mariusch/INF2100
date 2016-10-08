package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
 */
/* <program> ::= ’program’ <name> ’;’ <block> '.'
* Se side 23 i kompendiet
*
* - En blokk kan begynne med en ConstDeclPart
* - Kan ha en VarDeclPart
* - Kan ha en eller flere FuncDecl eller ProcDecl om hverandre
* - Må ha begin
* - Må ha StatmList
* - Må ha end
* */

class Block extends PascalSyntax {

    ConstDeclPart cdp;
    VarDeclPart vdp;
    ArrayList<ProcDecl> pdList = new ArrayList<>();
    StatmList stml;



    Program context; //Skal dette være mer generelt feks PascalSyntax istedenfor Program?

    Block(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<block> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        if (cdp != null) {
            Main.log.prettyPrint("const "); cdp.prettyPrint();
        }
        if (vdp != null){
            Main.log.prettyPrint("var "); vdp.prettyPrint();
        }

        for (ProcDecl pd : pdList){
            if (pd instanceof FuncDecl){
                Main.log.prettyPrint("function ");
            }
            //Hvis ikke er det en ProcDecl
            else {
                Main.log.prettyPrint("procedure ");
            }
            pd.prettyPrint();
        }
        Main.log.prettyPrint("begin"); Main.log.prettyIndent();
        stml.prettyPrint();
        Main.log.prettyOutdent();
        Main.log.prettyPrint("end");
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
            }
            //Hvis ikke er det et procedure token
            else {
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
