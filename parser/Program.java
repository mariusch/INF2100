package parser;

import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */

/* <program> ::= ’program’ <name> ’;’ <block> '.' */
public class Program extends PascalDecl {

    Block progBlock;

    Program(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<program> on line " + lineNum;
    }

    @Override
    public void prettyPrint() {

    }

    public static Program parse(Scanner s) {
        enterParser("program");
        Program p = new Program(s.curToken.id, s.curLineNum());

        s.skip(programToken);
        s.test(nameToken);
        s.readNextToken();
        s.skip(semicolonToken);
        p.progBlock = Block.parse(s); p.progBlock.context = p;
        s.skip(dotToken);

        leaveParser("program");
        return p;
    }


    @Override
    void checkWhetherAssignable(PascalSyntax where) {

    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
