package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

class Constant extends PascalSyntax {


    Constant(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }


    static Constant parse(Scanner s) {
        Constant stm = new Constant(s.curLineNum());

        return stm;
    }

}