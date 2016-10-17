package parser;

import main.*;
import scanner.*;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Constant extends PascalSyntax {

    private PrefixOperator po;
    private UnsignedConstant uc;

    Constant(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<constant> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        if (po != null)
            po.prettyPrint();

        uc.prettyPrint();
        //Main.log.prettyPrintLn();
    }


    static Constant parse(Scanner s) {
        enterParser("constant");
        Constant con = new Constant(s.curLineNum());

        if (s.curToken.kind == addToken || s.curToken.kind == subtractToken)
            con.po = PrefixOperator.parse(s);

        con.uc = UnsignedConstant.parse(s);

        leaveParser("constant");
        return con;
    }

}