package parser;

import scanner.Scanner;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
abstract class Factor extends PascalSyntax {

    Factor(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }


    static Factor parse(Scanner s) {
        enterParser("factor");
        Factor f;

        /*
        switch (s.curToken.kind) {
            case varToken:
                s.skip(varToken);
                break;
            case functionToken:
                s.skip(divToken);
                break;
            case in:
                s.skip(modToken);
                break;
            case ne:
                s.skip(andToken);
                break;
        }
        */

        leaveParser("factor");
        return null;
    }

}
