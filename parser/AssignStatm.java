package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class AssignStatm extends Statement {

    private Variable variable;
    private Expression expr;

    AssignStatm(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

        variable.check(curScope, lib);
        variable.vRef.checkWhetherAssignable(this);
        expr.check(curScope, lib);
        expr.type.checkType(variable.type, ":=", this,
                ":= is not Boolean.");
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();

        //variable.genCode(f); Står ikke i kompendiet at vi skal kalle dennes gencode ...


        expr.genCode(f);

        int tmpb = 0; //Endre til blokknivå når vi har det på plass
        int tmpo = 0; //Endre til offset når vi har det på plass

        //Sjekk typen til variabelen
        //Merk: b er blokknivå, o er offset
        //
        //Hvis vanlig variabel:
        //movl −4b(%ebp),%edx
        //movl %eax,o(%edx)
        if (variable.vRef instanceof VarDecl){
            f.genInstr("",          "movl",         -4*tmpb + "(%ebp),%edx",         "");
            f.genInstr("",          "movl",         "%eax," + tmpo + "(%edx)",       variable.name+" :=");
        }

        //
        //Hvis array:
        //Dropp denne foreløpig
        //
        //Hvis funksjon:
        //Hvordan kan den være funksjon? Har vi tatt høyde for dette?
        //movl − 4 (b + 1 )(%ebp),%edx
        //movl %eax,-32(%edx)
        else if (variable.vRef instanceof FuncDecl){
            f.genInstr("",          "movl",         -4*(tmpb+1)+"(%ebp),%edx",      "");
            f.genInstr("",          "movl",         "%eax,-32(%edx)",               "");
        }
    }

    @Override
    public String identify() {
        return "<assign statm> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        variable.prettyPrint();
        Main.log.prettyPrint(" := ");
        expr.prettyPrint();
    }

    static AssignStatm parse(Scanner s) {
        enterParser("assign statm");
        AssignStatm as = new AssignStatm(s.curLineNum());

        as.variable = Variable.parse(s);
        s.skip(assignToken);
        as.expr = Expression.parse(s);

        leaveParser("assign statm");
        return as;
    }
}
