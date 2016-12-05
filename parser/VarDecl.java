package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class VarDecl extends PascalDecl {

    protected parser.Type vType;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);

        vType.check(curScope, lib);
        type = vType.type;

        if (vType instanceof ArrayType) {
            ArrayType tmp = (ArrayType) vType;
            vType.type = new types.ArrayType(tmp.t.type, tmp.con.type, tmp.con.constVal, tmp.con2.constVal);
        }
        else if (vType instanceof TypeName) {
            TypeName tn = (TypeName) vType;
            if (tn.name.equals("integer")){
                type = lib.integerType;
            }
            else if (tn.name.equals("boolean")) {
                type = lib.booleanType;
            }
            else if (tn.name.equals("char")) {
                type = lib.charType;
            }
        }

        //declLevel og declOffset
        declOffset =- type.size(); //Dette er feil
        declLevel = curScope.findDeclLvl();
    }

    @Override
    void genCode(CodeFile f) {

        //Kode finnes også i ParamDecl
        f.genInstr("", "movl", declLevel*-4+"(%ebp),%edx", ""); // -4 skal være -4b, blokknivå
        f.genInstr("", "movl", declOffset+"(%edx),%eax", "  "+name);
    }

    @Override
    public String identify() {
        return "<var decl> " + name + " on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrint(": ");
        vType.prettyPrint();
        Main.log.prettyPrintLn("; ");
    }

    static VarDecl parse(Scanner s) {
        enterParser("var decl");
        VarDecl vd = new VarDecl(s.curToken.id, s.curLineNum());

        s.test(nameToken);
        vd.name = s.curToken.id;
        s.skip(nameToken);
        s.skip(colonToken);
        vd.vType = Type.parse(s);
        s.skip(semicolonToken);

        leaveParser("var decl");
        return vd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        //This method should be empty
    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {
        where.error(this.name + " is a variable, not a function.");
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        where.error(this.name + " is a variable, not a procedure.");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        //This method should be empty

    }
}
