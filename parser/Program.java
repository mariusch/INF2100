package parser;

import main.CodeFile;
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
public class Program extends PascalDecl {

    private Block progBlock;
    private String name;

    types.Type type;

    Program(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<program> on line " + lineNum;
    }

    @Override
    public void prettyPrint() {
        Main.log.prettyPrint("program "); Main.log.prettyPrint(name); Main.log.prettyPrintLn(";");
        progBlock.prettyPrint();
        Main.log.prettyPrint(".");
        Main.log.prettyPrintLn();
    }

    public static Program parse(Scanner s) {
        enterParser("program");
        Program p = new Program(s.curToken.id, s.curLineNum());

        s.skip(programToken);
        s.test(nameToken);
        p.name = s.curToken.id;
        s.readNextToken();
        s.skip(semicolonToken);
        p.progBlock = Block.parse(s); p.progBlock.context = p;
        s.skip(dotToken);

        leaveParser("program");
        return p;
    }

    @Override
    public void check(Block curScope, Library lib) {
        System.out.println("Vi vet at dette programmet ikke fungerer helt som det skal.\n" +
                "Spesielt har vi hatt problemer med typesjekking som vi har slitt med å fått \n" +
                "implementert, fordi vi ikke får satt riktig type oppover. Noe kode er lagt til" +
                "nå bare for å kunne kjøre uten nullpointers. Dette skal være merket " +
                "med kommentar. Navnebindinger gjøres stort sett riktig\n" +
                "og programmet sjekker om det er riktig antall parametere.  ");

        if (progBlock != null) {
            progBlock.check(curScope, lib);
        }

    }

    @Override
    public void genCode(CodeFile f) {

    }


    @Override
    void checkWhetherAssignable(PascalSyntax where) {
        where.error("You cannot assign to a program.");
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
