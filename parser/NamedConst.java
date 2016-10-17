package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class NamedConst extends UnsignedConstant {

    private String name;

    NamedConst(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<named-const> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        //Main.log.prettyPrintLn();
    }

    static NamedConst parse(Scanner s) {
        enterParser("named-const");
        NamedConst nc = new NamedConst(s.curLineNum());

        s.test(nameToken);
        nc.name = s.curToken.id;
        s.readNextToken();

        leaveParser("named-const");
        return nc;
    }
}
