package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import java.util.ArrayList;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class FuncCall extends Factor {

    private String name;
    private ArrayList<Expression> eList = new ArrayList<Expression>();
    private FuncDecl funcRef;

    FuncCall(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        PascalDecl d = curScope.findDecl(name, this);
        d.checkWhetherFunction(this);
        funcRef = (FuncDecl)d;

        for (int i = 0; i < eList.size(); i++) {

            if (funcRef.lineNum != -1) {
                Expression tmp = eList.get(i);
                tmp.check(curScope, lib);
                try {
                    if (eList.size() < funcRef.pdl.pdList.size())
                        error("Too few parameters in call on " + funcRef.name);

                    types.Type temp = funcRef.pdl.pdList.get(i).type;
                    tmp.type.checkType(temp, "param #" + (i + 1), this,
                            "wrong type of parameters");
                } catch (IndexOutOfBoundsException e) {
                    error("Too many parameters in call on " + funcRef.name);
                }
            } else {
                eList.get(i).check(curScope, lib);
            }
        }
        type = funcRef.type;
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    @Override
    public String identify() {
        return "<func call> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

        Main.log.prettyPrint(name);

        if (!eList.isEmpty()){
            Main.log.prettyPrint("(");
            eList.get(0).prettyPrint();


            for (int i = 1; i < eList.size(); i++){
                Main.log.prettyPrint(", ");
                eList.get(i).prettyPrint();
            }
            Main.log.prettyPrint(")");
        }
    }

    static FuncCall parse(Scanner s) {
        enterParser("func call");

        FuncCall fc = new FuncCall(s.curLineNum());

        s.test(nameToken);
        fc.name = s.curToken.id;
        s.skip(nameToken);

        if (s.curToken.kind == leftParToken){
            s.skip(leftParToken);

            fc.eList.add(Expression.parse(s));

            while (s.curToken.kind == commaToken){
                s.skip(commaToken);
                fc.eList.add(Expression.parse(s));
            }
            s.skip(rightParToken);
        }

        leaveParser("func call");
        return fc;
    }
}
