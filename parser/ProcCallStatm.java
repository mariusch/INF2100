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

        if (name.equals("write")){

            for (int i = 0; i < exprList.size(); i++) {
                exprList.get(i).genCode(f);
                f.genInstr("", "pushl", "%eax", "Push next param.");

                if (exprList.get(i).type instanceof types.IntType){
                    f.genInstr("", "call", "write_int", "");
                }
                else if (exprList.get(i).type instanceof types.CharType){
                    f.genInstr("", "call", "write_char", "");

                }
                else if (exprList.get(i).type instanceof types.BoolType){
                    f.genInstr("", "call", "write_bool", "");
                }
                else {
                    Main.panic(name);
                }

                f.genInstr("", "addl", "$4,%esp", "Pop param.");
            }

        } else {

            if (!procCallShort) {
                int sz = 4 * exprList.size();

                for (int i = exprList.size() - 1; i >= 0; i--) { //Reverse
                    exprList.get(i).genCode(f);
                    f.genInstr("", "pushl", "%eax", "Push param #" + (i+1) +".");
                }

                f.genInstr("", "call", "proc$" + procRef.progProcFuncName, "");
                f.genInstr("", "addl", "$" + sz + ",%esp", "Pop params.");

            } else {
                f.genInstr("", "call", "proc$" + procRef.progProcFuncName, "");
            }
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
