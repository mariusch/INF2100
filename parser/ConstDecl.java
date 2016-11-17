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
class ConstDecl extends PascalDecl {

    private Constant con;

    protected int constVal;

    ConstDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);
        con.check(curScope, lib);
        type = con.type;

        constVal = con.constVal;
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();

        con.genCode(f);
    }

    @Override
    public String identify() {
        if (lineNum < 0){
            return "<const decl> " + name + " in the library";
        }
        return "<const decl> " + name + " on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrint(" = ");
        con.prettyPrint();
        Main.log.prettyPrintLn(";");

    }

    static ConstDecl parse(Scanner s) {

        enterParser("const decl");
        ConstDecl cd = new ConstDecl(s.curToken.id, s.curLineNum());

        cd.name = s.curToken.id;
        s.readNextToken();
        s.skip(equalToken);
        cd.con = Constant.parse(s);
        s.skip(semicolonToken);

        leaveParser("const decl");
        return cd;
    }

    void setType(types.Type t) {
        this.type = t;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a constant.");
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {
        where.error(this.name + " is a constant, not a function.");
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        where.error(this.name + " is a constant, not a procedure.");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        //Ok?
    }
}
