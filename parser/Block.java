package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
/* <program> ::= ’program’ <name> ’;’ <block> '.'
* Se side 23 i kompendiet
*
* - En blokk kan begynne med en ConsDeclPart
* - Kan ha en VarDeclPart
* - Kan ha en eller flere FuncDecl eller ProcDecl om hverandre
* - Må ha begin
* - Må ha StatmList
* - Må ha end
* */

class Block extends PascalSyntax {

    Program context; //Skal dette være mer generelt feks PascalSyntax istedenfor Program?

    Block(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static Block parse(Scanner s) {
        enterParser("while-statm");

        Block stm = new Block(s.curLineNum());

        leaveParser("while-statm");
        return stm;
    }
}
