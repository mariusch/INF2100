package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class RelOperator extends Operator {

    protected String opVal;

    protected SimpleExpr left, right;

    RelOperator(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

    }

    @Override
    void genCode(CodeFile f) {

        if (opVal.equals("=")) {

            left.genCode(f);
            f.genInstr("",          "popl",         "%ecx",               "");
            right.genCode(f);
            f.genInstr("",          "cmpl",         "%eax,%ecx",               "");
            f.genInstr("",          "movl",         "$0,%eax",               "");
            f.genInstr("",          "sete",         "%al",               "");
        } else if (opVal.equals("<>")) {
            f.genInstr("",          "",         "",               " <> : Ikke implementert. Rel Opr");
        } else if (opVal.equals("<")) {
            //Denne er skrevet etter utskrift fra referansekompilatoren
            //left.genCode(f);
            f.genInstr("",          "push",         "%eax",               "");
            right.genCode(f);
            f.genInstr("",          "popl",         "%ecx",               "");
            f.genInstr("",          "cmpl",         "%eax,%ecx",               "");
            f.genInstr("",          "movl",         "$0,%eax",               "");
            f.genInstr("",          "setl",         "%al",               "Test <");

            //f.genInstr("",          "",         "",               " < : Ikke implementert. Rel Opr");
        } else if (opVal.equals("<=")) {
            f.genInstr("",          "",         "",               " <= : Ikke implementert. Rel Opr");
        } else if (opVal.equals(">")) {
            f.genInstr("",          "",         "",               " > : Ikke implementert. Rel Opr");
        } else if (opVal.equals(">=")) {
            f.genInstr("",          "",         "",               " >= : Ikke implementert. Rel Opr");
        } else {
            Main.panic("Rel opr - genCode()");
        }

    }

    @Override
    public String identify() {
        return "<rel opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + opVal + " ");
    }

    static RelOperator parse(Scanner s) {
        enterParser("rel opr");
        RelOperator ro = new RelOperator(s.curLineNum());
        ro.opVal = s.curToken.kind + "";

        switch (s.curToken.kind) {
            case equalToken:
                s.skip(equalToken);
                break;
            case notEqualToken:
                s.skip(notEqualToken);
                break;
            case lessToken:
                s.skip(lessToken);
                break;
            case lessEqualToken:
                s.skip(lessEqualToken);
                break;
            case greaterToken:
                s.skip(greaterToken);
                break;
            case greaterEqualToken:
                s.skip(greaterEqualToken);
                break;
            default:
                Main.error("no token match in rel opr");
                break;
        }

        leaveParser("rel opr");
        return ro;
    }

    static boolean isRelOpr(Scanner s) {
        switch (s.curToken.kind) {
            case equalToken:
                return true;
            case notEqualToken:
                return true;
            case lessToken:
                return true;
            case lessEqualToken:
                return true;
            case greaterToken:
                return true;
            case greaterEqualToken:
                return true;
            default:
                return false;
        }
    }
}
