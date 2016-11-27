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
class PrefixOperator extends Operator {

    protected String opr;
    protected PascalSyntax ref;

    PrefixOperator(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        if (ref instanceof Term) {
            Term tmp = (Term) ref;
            tmp.type.checkType(lib.integerType, "Prefix " + opr + " operand", this,
                    "Prefix + or - may only be applied to Integers.");
        } else if (ref instanceof UnsignedConstant) {
            UnsignedConstant tmp = (UnsignedConstant) ref;
            tmp.type.checkType(lib.integerType, "Prefix " + opr + " operand", this,
                    "Prefix + or - may only be applied to Integers.");
        } else {
            Main.panic("Error in Prefix Opr");
        }
    }

    @Override
    void genCode(CodeFile f) {
        if (opr.equals("-"))
            f.genInstr("", "negl", "%eax", "  "+opr +" (prefix)");
    }

    @Override
    public String identify() {
        return "<prefix opr" + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(" " + opr + " ");
    }

    static PrefixOperator parse(Scanner s) {
        enterParser("prefix opr");

        PrefixOperator po = new PrefixOperator(s.curLineNum());

        switch (s.curToken.kind) {
            case addToken:
                s.skip(addToken);
                po.opr = "+";
                break;
            case subtractToken:
               s.skip(subtractToken);
                po.opr = "-";
               break;
            default:
                Main.error("no token match in prefix opr");
                break;
        }

        leaveParser("prefix opr");
        return po;
    }

    static boolean isPrefixOpr(Scanner s){
        switch (s.curToken.kind) {
            case addToken:
                return true;
            case subtractToken:
                return true;
            default:
                return false;
        }
    }
}
