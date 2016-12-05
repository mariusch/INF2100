package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class FactorOperator extends Operator {

    protected String token;

    protected Factor left, right;


    FactorOperator(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        if (token.equals("and")) {
            type = lib.booleanType;
        } else {
            type = lib.integerType;
        }

        right.type.checkType(left.type, "left " + token + " operand" , this,
                token + " is different type.");

        left.type.checkType(right.type, "right " + token + " operand" , this,
                token + " is different type.");
    }

    @Override
    void genCode(CodeFile f) {

        if (token.equals("*")) {

            //Denne er skrevet etter utskrift fra referansekompilatoren
            left.genCode(f);
            f.genInstr("",          "pushl",         "%eax",               "");
            right.genCode(f);
            f.genInstr("",          "movl",         "%eax,%ecx",               "");
            f.genInstr("",          "popl",         "%eax",               "");
            f.genInstr("",          "imull",         "%ecx,%eax",               "  *");

        } else if (token.equals("div")) {
            left.genCode(f);
            f.genInstr("",          "pushl",         "%eax",               "");
            right.genCode(f);
            f.genInstr("",          "movl",         "%eax,%ecx",               "");
            f.genInstr("",          "popl",         "%eax",               "");
            f.genInstr("",          "cdq",         "",               "");
            f.genInstr("",          "idivl",         "%ecx",               "  /");
        } else if (token.equals("mod")) {

            //Denne er skrevet etter utskrift fra referansekompilatoren
            left.genCode(f);
            f.genInstr("",          "pushl",         "%eax",               "");
            right.genCode(f);
            f.genInstr("",          "movl",         "%eax,%ecx",               "");
            f.genInstr("",          "popl",         "%eax",               "");
            f.genInstr("",          "cdq",         "",               "");
            f.genInstr("",          "idivl",         "%ecx",               "");
            f.genInstr("",          "movl",         "%edx,%eax",               "  mod");

        } else if (token.equals("and")) {

            //Denne er skrevet etter utskrift fra referansekompilatoren
            left.genCode(f);
            f.genInstr("",          "pushl",         "%eax",               "");
            right.genCode(f);
            f.genInstr("",          "movl",         "%eax,%ecx",               "");
            f.genInstr("",          "popl",         "%eax",               "");
            f.genInstr("",          "andl",         "%ecx,%eax",               "  and");

        } else {
            Main.panic("Factor opr - genCode()");
        }
    }

    @Override
    public String identify() {
        return "<factor opr> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + token + " ");
    }

    static FactorOperator parse(Scanner s) {
        enterParser("factor opr");
        FactorOperator fo = new FactorOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case multiplyToken:
                fo.token = multiplyToken.toString();
                s.skip(multiplyToken);
                break;
            case divToken:
                fo.token = divToken.toString();
                s.skip(divToken);
                break;
            case modToken:
                fo.token = modToken.toString();
                s.skip(modToken);
                break;
            case andToken:
                fo.token = andToken.toString();
                s.skip(andToken);
                break;
            default:
                Main.error("no token match in factor opr");
                break;
        }

        leaveParser("factor opr");
        return fo;
    }
}
