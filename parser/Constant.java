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

    private int constVal;
    protected types.Type type;

    Constant(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        uc.check(curScope, lib);

        if (po != null) {
            type = lib.integerType;
            System.out.println("Const decl type satt: " + type);
        } else {
            type = uc.type;

            //Disse to if-testene er bare debug for nullpointer
            if (uc instanceof NumberLiteral)
                type = lib.integerType;

            if (uc instanceof NamedConst)
                type = lib.integerType;

            //System.out.println("Const type er: " + type + " fra " + uc.getClass());
        }


        constVal = uc.constVal;
        if (po != null) {
            String oprName = po.opr;
            uc.type.checkType(lib.integerType, "Prefix " + oprName, this,
                    "Prefix + or - may only be applied to Integers.");
            if (po.opr.equals("-"))
                constVal = -constVal;
        }
    }

    @Override
    void genCode(CodeFile f) {

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