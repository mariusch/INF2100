package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

class ConstDeclPart extends PascalSyntax {


    ConstDeclPart(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }


    static ConstDeclPart parse(Scanner s) {
        ConstDeclPart cdp = new ConstDeclPart(s.curLineNum());

        return cdp;
    }

}