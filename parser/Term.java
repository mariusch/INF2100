package parser;

import main.CodeFile;
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

    protected types.Type type;

    Term(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        Factor left, right;
        left = fList.get(0);

        left.check(curScope, lib);
        type = left.type;

        for (int i = 0; i <fList.size(); i++) {

            if (i < fOList.size()) {
                FactorOperator fo = fOList.get(i);
                right = fList.get(i+1);
                right.check(curScope, lib);
                fo.left = left;
                fo.right = right;
                fo.check(curScope, lib);

                type = fo.type;
            }
        }
    }

    @Override
    void genCode(CodeFile f) {

        if (fOList.size() != 0) {
            //So we don't call left multiple times
            fOList.get(0).left.genCode(f);

            for (int i = 0; i < fOList.size(); i++){
                fOList.get(i).genCode(f);
            }
        } else {
            fList.get(0).genCode(f);
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
