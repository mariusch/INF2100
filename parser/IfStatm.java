package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import java.util.ArrayList;
import static scanner.TokenKind.*;


/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class IfStatm extends Statement {

    private Expression exp;
    private ArrayList<Statement> stm = new ArrayList<Statement>();

    IfStatm(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        exp.check(curScope, lib);

        exp.type.checkType(lib.booleanType, "if-test", this,
                "If-test is not Boolean.");

        for (Statement s : stm) {
            s.check(curScope, lib);
        }
    }

    @Override
    void genCode(CodeFile f) {
        String lab1 = f.getLocalLabel(),
                lab2 = f.getLocalLabel();

        f.genInstr("",      "",     "",      "Start if-statement");
        exp.genCode(f);
        f.genInstr("",      "cmpl",     "$0,%eax",      "");
        f.genInstr("",      "je",       lab1,           "");
        stm.get(0).genCode(f);

        //Else instruction
        if (stm.size() > 1) {
            f.genInstr("",  "jmp",      lab2,           "");
        }

        f.genInstr(lab1,    "",     "",     "");

        //Else instruction
        if (stm.size() > 1){
            stm.get(1).genCode(f);
            f.genInstr(lab2,    "",     "",       "");
        }
        f.genInstr("",      "",     "",      "End if-statement");
    }

    @Override
    public String identify() {
        return "<if-statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("if ");
        exp.prettyPrint();
        Main.log.prettyPrintLn(" then");

        Main.log.prettyIndent();
        stm.get(0).prettyPrint();
        Main.log.prettyOutdent();

        if (stm.size() >= 2) {
            Main.log.prettyPrintLn("");
            Main.log.prettyPrintLn(" else ");
            Main.log.prettyIndent();
            stm.get(1).prettyPrint();
            Main.log.prettyOutdent();
        }
    }

    static IfStatm parse(Scanner s) {
        enterParser("if-statm");
        IfStatm is = new IfStatm(s.curLineNum());

        s.skip(ifToken);
        is.exp = Expression.parse(s);
        s.skip(thenToken);
        is.stm.add(Statement.parse(s));

        if ( s.curToken.kind == elseToken) {
            s.skip(elseToken);
            is.stm.add(Statement.parse(s));
        }

        leaveParser("if-statm");
        return is;
    }
}
