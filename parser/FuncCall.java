package parser;

import main.Main;
import scanner.Scanner;

import java.util.ArrayList;

import static scanner.TokenKind.*;

/**
 * Created by marius on 22.09.2016.
 */
class FuncCall extends Factor {

    private String name;
    private ArrayList<Expression> eList = new ArrayList<Expression>();

    FuncCall(int lNum) {
        super(lNum);
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
                Main.log.prettyPrint(",");
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
