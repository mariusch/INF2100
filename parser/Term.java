package parser;

import scanner.Scanner;

import java.util.ArrayList;

/**
 * Created by marius on 22.09.2016.
 */
class Term extends PascalSyntax {

    private ArrayList<Factor> fList = new ArrayList<Factor>();
    private ArrayList<FactorOperator> fOList = new ArrayList<FactorOperator>();

    Term(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<term> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        fList.get(0).prettyPrint();

        for (int i = 0; i < fOList.size();){
            fOList.get(i).prettyPrint();
            fList.get(i+1).prettyPrint();
        }
    }

    static Term parse(Scanner s) {
        enterParser("term");

        Term term = new Term(s.curLineNum());


        term.fList.add(Factor.parse(s));



        for (int i = 0; i < term.fOList.size(); i++){
            term.fOList.add(FactorOperator.parse(s));
            term.fList.add(Factor.parse(s));
        }


        leaveParser("term");
        return term;
    }
}
