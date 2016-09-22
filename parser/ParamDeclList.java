package parser;

import scanner.Scanner;

/**
 * Created by marius on 22.09.2016.
 */
class ParamDeclList extends PascalSyntax {

    ParamDeclList(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    static ParamDeclList parse(Scanner s) {
        ParamDeclList stm = new ParamDeclList(s.curLineNum());

        return stm;
    }

}
