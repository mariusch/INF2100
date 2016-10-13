package parser;

import main.Main;
import scanner.Scanner;

import java.util.ArrayList;

import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class StatmList extends PascalSyntax {

    private ArrayList<Statement> sl = new ArrayList<Statement>();

    StatmList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<statm list> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        sl.get(0).prettyPrint();

        for (int i = 1; i < sl.size(); i++){
            Main.log.prettyPrint(";");
            sl.get(i).prettyPrint();
        }
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
