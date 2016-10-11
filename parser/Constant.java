package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

class Constant extends PascalSyntax {

    private PrefixOperator po;
    private UnsignedConstant uc;

    Constant(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        if (po != null)
            po.prettyPrint();

        uc.prettyPrint();
    }


    static Constant parse(Scanner s) {
        enterParser("constant");
        Constant con = new Constant(s.curLineNum());

        if (s.curToken.kind == addToken || s.curToken.kind == subtractToken){
                con.po = PrefixOperator.parse(s);
        }

        con.uc = UnsignedConstant.parse(s);

        leaveParser("constant");
        return con;
    }

}