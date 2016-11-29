package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class ProcDecl extends PascalDecl {

    protected ParamDeclList pdl;
    private Block block;
    protected String label;

    ProcDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);

        block.outerScope = curScope;

        if (pdl != null)
            pdl.check(block, lib);

        block.check(curScope, lib);

        //declLevel og declOffset
        if (pdl != null) {
            declOffset =- 32 + ( 4 * pdl.pdList.size() );
        } else {
            declOffset =- 32;
        }
        declLevel = curScope.findDeclLvl();
    }

    @Override
    void genCode(CodeFile f) {
        label = f.getLabel("proc$" + name);

        //f.genInstr(label,              "enter",             "$"+declOffset+",$" + declLevel,                      "Start of "+name);

        /*if (pdl != null) {
            pdl.genCode(f);
        }*/
        block.genCode(f);

        f.genInstr("",      "leave",         "",      "End of "+name);
        f.genInstr("",      "ret",         "",      "");
    }

    @Override
    public String identify() {
        if (lineNum < 0){
            return "<proc decl> " + name + " in the library";
        }
        return "<proc decl> " + name + " on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("procedure ");
        Main.log.prettyPrint(name);

        if (pdl != null) {
            Main.log.prettyPrint(" ");
            pdl.prettyPrint();
        }

        Main.log.prettyPrintLn("; ");
        block.prettyPrint();
        Main.log.prettyPrint("; ");
        Main.log.prettyPrintLn();
        Main.log.prettyPrintLn();
    }

    static ProcDecl parse(Scanner s) {
        enterParser("proc decl");
        ProcDecl pd = new ProcDecl(s.curToken.id, s.curLineNum());

        s.skip(TokenKind.procedureToken);
        s.test(TokenKind.nameToken);
        pd.name = s.curToken.id;
        s.skip(TokenKind.nameToken);

        if (s.curToken.kind == TokenKind.leftParToken)
            pd.pdl = ParamDeclList.parse(s);

        s.skip(TokenKind.semicolonToken);
        pd.block = Block.parse(s); pd.block.context = pd;
        s.skip(TokenKind.semicolonToken);

        leaveParser("proc decl");
        return pd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a proc.");
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {
        where.error(this.name + " is a procedure, not a function.");
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        //Tom
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        where.error(this.name + " is a procedure, not a value.");
    }
}
