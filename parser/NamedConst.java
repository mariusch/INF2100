package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class NamedConst extends UnsignedConstant {

    types.Type type;

    private String name;

    PascalDecl declRef;

    NamedConst(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        PascalDecl d = curScope.findDecl(name, this);
        type = d.type;
    }

    @Override
    public String identify() {
        return "<named-const> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
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
