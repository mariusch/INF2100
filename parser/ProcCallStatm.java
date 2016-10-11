package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
 */
class ProcCallStatm extends Statement {

    private String name;
    private ArrayList<Expression> exprList = new ArrayList<Expression>();

    ProcCallStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        Main.log.prettyPrint(name);
        for (Expression e : exprList){
            e.prettyPrint();
        }
    }

    static ProcCallStatm parse(Scanner s) {
        enterParser("proc-call-statm");
        ProcCallStatm pcs = new ProcCallStatm(s.curLineNum());


        s.test(TokenKind.nameToken);
        pcs.name = s.curToken.id;
        s.skip(TokenKind.nameToken);




        //Har vi en liste med expressions?
        if (s.curToken.kind == TokenKind.leftParToken){
            s.skip(TokenKind.leftParToken);

            pcs.exprList.add(Expression.parse(s));

            while (s.curToken.kind == TokenKind.commaToken){
                s.skip(TokenKind.commaToken);

                pcs.exprList.add(Expression.parse(s));

            }


            s.skip(TokenKind.rightParToken);
        }

        leaveParser("proc-call-statm");
        return pcs;
    }
}
