package parser;

import main.Main;
import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
abstract class UnsignedConstant extends Factor {

    UnsignedConstant(int lNum) {
        super(lNum);
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
                Main.panic("Her er det noe feil!");
                break;
        }

        leaveParser("unsigned constant");
        return uc;
    }
}
