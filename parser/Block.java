package parser;

import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
 */
/* <program> ::= ’program’ <name> ’;’ <block> '.'
* Se side 23 i kompendiet
*
* - En blokk kan begynne med en ConsDeclPart
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

    }

    static Block parse(Scanner s) {
        enterParser("block");

        Block bl = new Block(s.curLineNum());

        if (s.nextToken.kind == TokenKind.constToken){
            s.skip(TokenKind.constToken);
            bl.cdp = ConstDeclPart.parse(s);
        }

        if (s.nextToken.kind == TokenKind.varToken){
            s.skip(TokenKind.varToken);
            bl.vdp = VarDeclPart.parse(s);
        }

        while (s.nextToken.kind == TokenKind.functionToken || s.nextToken.kind == TokenKind.procedureToken){
            if (s.nextToken.kind == TokenKind.functionToken){
                s.skip(TokenKind.functionToken);
                bl.pdList.add(FuncDecl.parse(s));
            }
            //Hvis ikke er det et procedure token
            else {
                s.skip(TokenKind.procedureToken);
                bl.pdList.add(ProcDecl.parse(s));
            }
        }



        leaveParser("block");
        return bl;
    }
}
