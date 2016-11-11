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

    types.Type type;

    Term(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        //Setter Type
        Factor f = fList.get(0);
        f.check(curScope, lib);
        type = f.type;
        //type = lib.integerType; //Debug kode

        //Flere factorer? Kjører Check og endrer Type
        for (int i = 0; i < fOList.size(); i++) {
            //Sjekk om annen type ...
            FactorOperator fo = fOList.get(i);
            fList.get(i+1).check(curScope, lib);
            fo.left = f;
            fo.right = fList.get(i+1);
            fo.check(curScope, lib);

            //baserer type på factor opr
            if (fOList.get(i).type.equals("and")) {
                type = lib.booleanType;
            } else {
                type = lib.integerType;
            }
        }
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
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
