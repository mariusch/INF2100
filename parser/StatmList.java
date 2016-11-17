package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import java.util.ArrayList;
import static scanner.TokenKind.*;


/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class StatmList extends PascalSyntax {

    private ArrayList<Statement> sl = new ArrayList<Statement>();

    StatmList(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        for (Statement s : sl){
            s.check(curScope, lib);
        }
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();

        sl.get(0).genCode(f);

        for (int i = 1; i < sl.size(); i++){
            sl.get(i).genCode(f);
        }
    }

    @Override
    public String identify() {
        return "<statm list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        sl.get(0).prettyPrint();

        for (int i = 1; i < sl.size(); i++){
            Main.log.prettyPrintLn("; ");
            sl.get(i).prettyPrint();
        }
        Main.log.prettyPrintLn();
    }

    static StatmList parse(Scanner s) {
        enterParser("statm list");
        StatmList stml = new StatmList(s.curLineNum());

        stml.sl.add(Statement.parse(s));

        while(s.curToken.kind == semicolonToken){
            s.skip(semicolonToken);
            stml.sl.add(Statement.parse(s));
        }

        leaveParser("statm list");
        return stml;
    }
}
