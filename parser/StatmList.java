package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class StatmList extends PascalSyntax {

    StatmList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<statm list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static StatmList parse(Scanner s) {
        enterParser("statm list");

        StatmList stml = new StatmList(s.curLineNum());

        leaveParser("statm list");
        return stml;
    }
}
