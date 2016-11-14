package parser;

import main.CodeFile;
import types.*;
import types.ArrayType;
import types.BoolType;
import types.CharType;
import types.IntType;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
public class Library extends Block {

    protected types.IntType integerType = new IntType();
    protected types.CharType charType = new CharType();
    protected types.BoolType booleanType = new BoolType();

    //Const eol, false, true
    //Proc write

    public Library(int lNum) {
        super(lNum);

        /* false, true, eol, write */
        this.addDecl("write", new ProcDecl("write", -1));
        this.addDecl("eol", new ConstDecl("eol", -1));

        TypeDecl falseConDecl = new TypeDecl("false", -1);
        falseConDecl.setType(this.booleanType);
        this.addDecl("false", falseConDecl);
        TypeDecl trueConDecl = new TypeDecl("true", -1);
        trueConDecl.setType(this.booleanType);
        this.addDecl("true", trueConDecl);

        /* boolean, char, integer decls*/
        TypeDecl boolDecl = new TypeDecl("boolean", -1);
        boolDecl.setType(this.booleanType);
        this.addDecl("boolean", boolDecl);

        TypeDecl charDecl = new TypeDecl("char", -1);
        charDecl.setType(this.charType);
        this.addDecl("char", charDecl);

        TypeDecl intDecl = new TypeDecl("integer", -1);
        intDecl.setType(this.integerType);
        this.addDecl("integer", intDecl);
    }

    @Override
    void check(Block curScope, Library lib) {

    }

    @Override
    public String identify() {
        return "<library> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    public String toString(){
        return "Library";
    }
}
