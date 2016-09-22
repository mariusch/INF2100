package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class VarDeclPart extends PascalSyntax {

    VarDeclPart(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static VarDeclPart parse(Scanner s) {
        VarDeclPart stm = new VarDeclPart(s.curLineNum());

        return stm;
    }
}
