package parser;

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
