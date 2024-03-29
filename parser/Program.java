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
public class Program extends PascalDecl {

    protected Block progBlock;

    Program(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<program> on line " + lineNum;
    }

    @Override
    public void prettyPrint() {
        Main.log.prettyPrint("program "); Main.log.prettyPrint(name); Main.log.prettyPrintLn(";");
        progBlock.prettyPrint();
        Main.log.prettyPrint(".");
        Main.log.prettyPrintLn();
    }

    public static Program parse(Scanner s) {
        enterParser("program");
        Program p = new Program(s.curToken.id, s.curLineNum());

        s.skip(programToken);
        s.test(nameToken);
        p.name = s.curToken.id;
        s.readNextToken();
        s.skip(semicolonToken);
        p.progBlock = Block.parse(s); p.progBlock.context = p;
        s.skip(dotToken);

        leaveParser("program");
        return p;
    }

    @Override
    public void check(Block curScope, Library lib) {
        if (progBlock != null)
            progBlock.check(curScope, lib);
    }

    @Override
    public void genCode(CodeFile f) {
        progProcFuncName = f.getLabel(name);

        //OSX and Linux uses underscore
        String mainName;
        if (main.Main.useUnderscore()) {
            mainName = "_main";
        } else {
            mainName = "main";
        }

        //Generate main program that calls the out program
        f.genInstr("",              ".globl",             mainName,                             "");
        f.genInstr(mainName,          "call",               "prog$"+progProcFuncName,           "Start program");
        f.genInstr("",              "movl",               "$0,%eax",                          "Set status 0 and");
        f.genInstr("",              "ret",                "",                                 "terminate the program");

        //Calculate offset
        if (progBlock.vdp != null) {
            declOffset = 32 + (4 * progBlock.vdp.vdList.size());
        }
        else {
            declOffset = 32;
        }

        progBlock.genCode(f);
        f.genInstr("",              "leave",              "",                  "End of "+name);
        f.genInstr("",              "ret",                "",                  "");
    }


    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a program.");
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
