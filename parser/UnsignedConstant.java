package parser;

import main.Main;
import scanner.Scanner;

import static scanner.TokenKind.subtractToken;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
abstract class UnsignedConstant extends Factor {

    //protected types.Type type;
    protected int constVal;

    UnsignedConstant(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        /*
        Abstract class
            NumberLiteral: IntegerType
            CharLiteral: CharType
            NamedConst: type to its declaration
         */
    }

    abstract void prettyPrint();

    @Override
    public String identify() {
        return "<unsigned constant> on line " + lineNum;
    }

    static UnsignedConstant parse(Scanner s) {
        enterParser("unsigned constant");
        UnsignedConstant uc = null;

        switch (s.curToken.kind) {
            case nameToken:
                uc = NamedConst.parse(s);
                break;
            case intValToken:
                uc = NumberLiteral.parse(s);
                break;
            case charValToken:
                uc = CharLiteral.parse(s);
                break;
            default:
                Main.error("no token match in unsigned const");
                break;
        }

        leaveParser("unsigned constant");
        return uc;
    }
}
