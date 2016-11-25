package parser;

import main.CodeFile;
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

    protected ProcDecl procRef;

    ProcCallStatm(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib){
        PascalDecl d = curScope.findDecl(name, this);
        procRef = (ProcDecl)d;
        procRef.checkWhetherProcedure(this);

        for (int i = 0; i < exprList.size(); i++){

            if (exprList.get(i).type instanceof types.ArrayType){
                error("Arrays not allowed as parameters.");
            }

            if (procRef.lineNum != -1) {
                Expression tmp = exprList.get(i);
                tmp.check(curScope, lib);
                try {
                    if (exprList.size() < procRef.pdl.pdList.size())
                        error("Too few parameters in call on " + procRef.name);
                    types.Type temp = procRef.pdl.pdList.get(i).type;
                    tmp.type.checkType(temp,"param #" + (i+1), this,
                            "wrong type of parameters");
                } catch(IndexOutOfBoundsException e) {
                    error("Too many parameters in call on " + procRef.name);
                }
            } else {
                exprList.get(i).check(curScope,lib);
            }
        }
    }

    @Override
    void genCode(CodeFile f) {
        procRef.label = f.getLabel("proc$" + name);
        f.genInstr(procRef.label,              "enter",             "$"+32+",$1",                      "Start of "+name);

        if (!procCallShort) {
            /*exprList.get(0).genCode(f);

            for (int i = 1; i < exprList.size(); i++){
                exprList.get(i).genCode(f);*/


            if (!exprList.isEmpty()){

                for (int i = exprList.size()-1; i > 0; i--){
                    exprList.get(i).genCode(f); //Legger value fra expr til %eax
                    //pushl %eax
                    f.genInstr("",      "pushl",        "%eax",         "Push next param.");
                }
            }

            //call func$f_n - f_n er navnet til funksjonsdeklarasjonen

            f.genInstr("",      "call",         procRef.label,      "");

            int sz = 4*exprList.size();
            f.genInstr("",      "addl",         "$" + sz + ",%esp", "Pop param.");

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
