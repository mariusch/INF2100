package parser;

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
    protected types.ArrayType arrayType; //Skal arrayType opprettes på nytt hver gang noe annet sjekker etter array?
    protected types.BoolType booleanType = new BoolType();

    //Const eol, false, true
    //Proc write



    public Library(int lNum) {
        super(lNum);
        this.addDecl("write", new ProcDecl("write", 0));
        this.addDecl("eol", new ConstDecl("eol", 0));
        this.addDecl("false", new ConstDecl("false", 0));
        this.addDecl("true", new ConstDecl("true", 0));
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
}
