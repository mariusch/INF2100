package parser;

import scanner.*;
import static scanner.TokenKind.*;


abstract class Statement extends PascalSyntax {

    Statement(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    abstract void prettyPrint();


    static Statement parse(Scanner s) {
        enterParser("statement");
        Statement st;


        switch (s.curToken.kind) {
            case beginToken:
                st = CompoundStatm.parse(s);
                break;
            case ifToken:
                st = IfStatm.parse(s);
                break;
            case nameToken:

                switch (s.nextToken.kind) {
                    case assignToken:
                    case leftBracketToken:
                        st = AssignStatm.parse(s);
                        break;
                    default:
                        st = ProcCallStatm.parse(s);
                        break;
                }
                break;
            case whileToken:
                st = WhileStatm.parse(s);
                break;
            default:
                st = EmptyStatm.parse(s);
                break;
        }
        leaveParser("statement");
        return st;
    }
}