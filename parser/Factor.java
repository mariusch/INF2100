package parser;

import scanner.Scanner;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
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
        types.Type type;

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
            default:
                s.testError("value");
                break;
        }

        leaveParser("factor");
        return f;
    }

}
