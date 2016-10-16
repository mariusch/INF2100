package parser;

import main.Main;
import scanner.Scanner;

import java.util.ArrayList;

import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class IfStatm extends Statement {

    private Expression exp;
    private ArrayList<Statement> stm = new ArrayList<Statement>();

    IfStatm(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<if-statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("if ");
        exp.prettyPrint();
        Main.log.prettyPrint("then\n");
        stm.get(0).prettyPrint();

        if (stm.get(1) != null) {
            Main.log.prettyPrint("else\n");
            stm.get(1).prettyPrint();
        }
    }

    static IfStatm parse(Scanner s) {
        enterParser("if-statm");
        IfStatm is = new IfStatm(s.curLineNum());

        s.skip(ifToken);
        is.exp = Expression.parse(s);
        s.skip(thenToken);
        is.stm.add(Statement.parse(s));

        if ( s.curToken.kind == elseToken) {
            s.skip(elseToken);
            is.stm.add(Statement.parse(s));
        }

        leaveParser("if-statm");
        return is;
    }
}
