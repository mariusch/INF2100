package parser;

import main.Main;
import scanner.Scanner;
import java.util.ArrayList;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class NumberLiteral extends UnsignedConstant {

    private ArrayList<Integer> num = new ArrayList<Integer>();

    NumberLiteral(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<number literal> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        for (Integer i : num) {
            Main.log.prettyPrint(i + "");
        }
        //Main.log.prettyPrintLn();
    }

    static NumberLiteral parse(Scanner s) {
        enterParser("number literal");
        NumberLiteral numLit = new NumberLiteral(s.curLineNum());

        numLit.num.add(s.curToken.intVal);
        s.skip(intValToken);

        while (s.curToken.kind == intValToken) {
            numLit.num.add(s.curToken.intVal);
            s.skip(intValToken);
        }

        leaveParser("number literal");
        return numLit;
    }
}
