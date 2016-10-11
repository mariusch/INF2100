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
        return "<factor> on line " + lineNum;
    }

    abstract void prettyPrint();

    static Factor parse(Scanner s) {
        enterParser("factor");
        Factor f = null;





        //Which type of Factor to use may be unknown, so for now we follow these rules:
        //If the first token is a char: char literal
        //If the first token is a number: number literal
        //If the first token is a left parentheses: Inner expr
        //If the first token is a not token: Negation
        //If the first token is name and it is followed by a left bracket: Variable
        //If the first token is a name and it is followed by a parentheses: Function call
        //If none of the above match: Treat as Variable for now.

        switch (s.curToken.kind) {
            case leftParToken:
                f = InnerExpr.parse(s);
                break;
            case notToken:
                f = Negation.parse(s);
                break;
            case charValToken:
            case intValToken:
                f = UnsignedConstant.parse(s);
                break;
            case nameToken:
                switch (s.nextToken.kind) {
                    case leftBracketToken:
                        f = Variable.parse(s);
                        break;
                    case leftParToken:
                        f = FuncCall.parse(s);
                        break;
                    default:
                        f = Variable.parse(s);
                        break;
                }
                break;
        }

        leaveParser("factor");
        return f;
    }

}
