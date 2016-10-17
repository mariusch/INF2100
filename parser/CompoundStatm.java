package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class CompoundStatm extends Statement {

    private StatmList statmList;

    CompoundStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<compound statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrintLn("begin");
        Main.log.prettyIndent();
        statmList.prettyPrint();
        Main.log.prettyOutdent();
        Main.log.prettyPrint("end");
    }

    static CompoundStatm parse(Scanner s) {
        enterParser("compound statm");
        CompoundStatm cstmm = new CompoundStatm(s.curLineNum());

        s.skip(TokenKind.beginToken);
        cstmm.statmList = StatmList.parse(s);
        s.skip(TokenKind.endToken);

        leaveParser("compound statm");
        return cstmm;
    }
}