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

    @Override
    void prettyPrint() {

    }


    static Constant parse(Scanner s) {
        enterParser("while-statm");

        Constant stm = new Constant(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }

}