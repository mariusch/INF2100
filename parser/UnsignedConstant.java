package parser;

import main.Main;
import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
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
