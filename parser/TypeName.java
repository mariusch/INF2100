package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Created by essi on 09.10.2016.
 */
public class TypeName extends Type {

    private String name;

    TypeName(int n) {
        super(n);
    }

    public static TypeName parse(Scanner s) {

        enterParser("type name");

        TypeName tn = new TypeName(s.curLineNum());

        s.test(TokenKind.nameToken);
        tn.name = s.curToken.id;
        s.skip(TokenKind.nameToken);


        leaveParser("type name");

        return tn;
    }

    @Override
    public String identify() {
        return "<type name> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
        Main.log.prettyPrintLn();
    }
}
