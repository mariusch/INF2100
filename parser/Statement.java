package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

abstract class Statement extends PascalSyntax {


    Statement(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Statement parse(Scanner s) {
        enterParser("while-statm");

        //Statement stm = new Statement(s.curLineNum());

        leaveParser("while-statm");
        return null;
    }

}