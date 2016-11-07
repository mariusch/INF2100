package parser;

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

    types.Type type;

    FuncCall(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        PascalDecl d = curScope.findDecl(name, this);
        d.checkWhetherFunction(this);
        funcRef = (FuncDecl)d;

        if ((funcRef.pdl != null) && funcRef.pdl.pdList.size() > eList.size()){
            Main.error("Error at line " + lineNum + ": Too few parameters in call on " + name + "!");
        }
        else if ((funcRef.pdl != null) && funcRef.pdl.pdList.size() < eList.size()){
            Main.error("Error at line " + lineNum + ": Too many parameters in call on " + name + "!");
        }

        type = funcRef.type;

        for (Expression e: eList) {
            e.check(curScope, lib);
        }
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
