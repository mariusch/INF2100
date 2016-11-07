package parser;

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

    private Type vType;
    private String name;

    types.Type type;

    VarDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        curScope.addDecl(name, this);
        vType.check(curScope, lib);

        if (vType instanceof ArrayType){
            type = lib.arrayType;
        }
        else if (vType instanceof TypeName){
            TypeName tn = (TypeName) vType;
            if (tn.name.equals("integer")){
                type = lib.integerType;
            }
            else if (tn.name.equals("boolean")){
                type = lib.booleanType;
            }
            else if (tn.name.equals("char")){
                type = lib.charType;
            }
        }
        //Hvordan setter vi typen til VarDecl?
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

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
