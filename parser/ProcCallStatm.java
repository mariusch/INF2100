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
class ProcCallStatm extends Statement {

    private String name;
    private ArrayList<Expression> exprList = new ArrayList<Expression>();
    private boolean procCallShort = true;

    ProcDecl procRef;

    ProcCallStatm(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib){

        for (Expression e : exprList){
            e.check(curScope, lib);
        }

        PascalDecl d = curScope.findDecl(name, this);
        d.checkWhetherProcedure(this);
        //..
        procRef = (ProcDecl)d;
        //..

        if ((procRef.pdl != null) && procRef.pdl.pdList.size() > exprList.size()){
            Main.error("Error at line " + lineNum + ": Too few parameters in call on " + name + "!");
        }
        else if ((procRef.pdl != null) && procRef.pdl.pdList.size() < exprList.size()){
            Main.error("Error at line " + lineNum + ": Too many parameters in call on " + name + "!");
        }

    }

    @Override
    public String identify() {
        return "<proc call> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);

        if (!procCallShort) {
            Main.log.prettyPrint("(");
            exprList.get(0).prettyPrint();

            for (int i = 1; i < exprList.size(); i++){
                Main.log.prettyPrint(", ");
                exprList.get(i).prettyPrint();
            }

            Main.log.prettyPrint(")");
        }
    }

    static ProcCallStatm parse(Scanner s) {
        enterParser("proc call");
        ProcCallStatm pcs = new ProcCallStatm(s.curLineNum());

        s.test(TokenKind.nameToken);
        pcs.name = s.curToken.id;
        s.skip(TokenKind.nameToken);

        if (s.curToken.kind == TokenKind.leftParToken) {
            pcs.procCallShort = false;
            s.skip(TokenKind.leftParToken);

            pcs.exprList.add(Expression.parse(s));

            while (s.curToken.kind == TokenKind.commaToken){
                s.skip(TokenKind.commaToken);
                pcs.exprList.add(Expression.parse(s));
            }

            s.skip(TokenKind.rightParToken);
        }

        leaveParser("proc call");
        return pcs;
    }
}
