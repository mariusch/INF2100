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

    @Override
    void prettyPrint() {

    }


    static ConstDeclPart parse(Scanner s) {
        enterParser("const decl part");
        ConstDeclPart cdp = new ConstDeclPart(s.curLineNum());

        leaveParser("const decl part");
        return cdp;
    }

}