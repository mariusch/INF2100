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

    private parser.Type vType;
    private String name;

    types.Type type;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);

        //System.out.println("var decl TYPE:" + vType.getClass());
        vType.check(curScope, lib);
        type = vType.type;

        //Det over burde holde?
        if (vType instanceof ArrayType){
            type = lib.booleanType; //Feil
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

        //System.out.println("Var decl er: " + type + " fra " + vType.getClass());
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
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
        //Kast feil
        where.error(this.name + " is a variable, not a function.");
    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {
        //Kast feil
        where.error(this.name + " is a variable, not a procedure.");
    }

    @Override
    void checkWhetherValue(PascalSyntax where) {
        //Tom

    }
}
