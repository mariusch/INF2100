package parser;

import scanner.Scanner;
import java.util.ArrayList;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Term extends PascalSyntax {

    private ArrayList<Factor> fList = new ArrayList<Factor>();
    private ArrayList<FactorOperator> fOList = new ArrayList<FactorOperator>();

    Term(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {
        for (int i = 0; i < fList.size(); i++){
            fList.get(i).check(curScope, lib);

            if (fOList.get(i) != null){
                fOList.get(i).check(curScope, lib);
            }
        }
    }

    @Override
    public String identify() {
        return "<term> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        fList.get(0).prettyPrint();

        for (int i = 0; i < fOList.size(); i++){
            fOList.get(i).prettyPrint();
            fList.get(i+1).prettyPrint();
        }
    }

    static Term parse(Scanner s) {
        enterParser("term");
        Term term = new Term(s.curLineNum());

        term.fList.add(Factor.parse(s));

        while (s.curToken.kind.isFactorOpr()){
            term.fOList.add(FactorOperator.parse(s));
            term.fList.add(Factor.parse(s));
        }

        leaveParser("term");
        return term;
    }
}
