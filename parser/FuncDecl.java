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
class FuncDecl extends ProcDecl {

    public String name;
    ParamDeclList pdl;
    private parser.TypeName tn;
    private Block blck;

    FuncDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<func decl> " + name + " on line " + lineNum;
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);

        blck.outerScope = curScope;

        if (pdl != null)
            pdl.check(blck, lib);

        tn.check(blck, lib);
        type = tn.type;
        blck.check(curScope, lib);
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("function ");
        Main.log.prettyPrint(name);

        if (pdl != null)
            pdl.prettyPrint();

        Main.log.prettyPrint(": ");
        tn.prettyPrint();
        Main.log.prettyPrint("; ");
        blck.prettyPrint();
        Main.log.prettyPrint("; ");
        Main.log.prettyPrintLn();
    }

    static FuncDecl parse(Scanner s) {
        enterParser("func decl");
        FuncDecl fd = new FuncDecl(s.curToken.id, s.curLineNum());

        s.skip(functionToken);
        s.test(nameToken);
        fd.name = s.curToken.id;
        s.skip(nameToken);

        if (s.curToken.kind == leftParToken)
            fd.pdl = ParamDeclList.parse(s);

        s.skip(colonToken);
        fd.tn = TypeName.parse(s);
        s.skip(semicolonToken);
        fd.blck = Block.parse(s);
        s.skip(semicolonToken);

        leaveParser("func decl");
        return fd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        //This method should be empty
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {
        //Tom?
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        where.error (this.name + " is a function, not a procedure!");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        //Tom
    }
}
