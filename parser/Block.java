package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class Block extends PascalSyntax {
    private ConstDeclPart cdp;
    private VarDeclPart vdp;
    private ArrayList<ProcDecl> pdList = new ArrayList<ProcDecl>();
    private StatmList stml;
    protected Program context;

    HashMap<String, PascalDecl> decls = new HashMap<String, PascalDecl>();
    protected Block outerScope;

    Block(int lNum) {
        super(lNum);
    }

    void addDecl(String id, PascalDecl d) {
        if (decls.containsKey(id)){
            d.error(id + " declared twice in the same block!");
        }
        //System.out.println("La til: " + id + " " + d.identify() + " i scope " + this);
        decls.put(id, d);
    }

    PascalDecl findDecl(String id, PascalSyntax where) {
        PascalDecl d = decls.get(id);

        //Debugg
       /* System.out.println("\nPRINTER ALT I SCOPE: " + this.getClass());
        for (String pd : decls.keySet()) {
            System.out.println(pd);
        }
        System.out.println("\n"); */

        if (d != null) {
            //System.out.println("Leter etter " + id + " i curScope: ");
            //System.out.println("HER: " + this.identify());
            Main.log.noteBinding(id, where, d);
            return d;
        }

        if (outerScope != null ) {
            //System.out.println("Leter etter " + id + " i outer scope: ");
            //System.out.println(outerScope.getClass());
            return outerScope.findDecl(id, where);
        }

        where.error("Name " + id + " is unknown!");
        return null;
    }

    @Override
    void check(Block curScope, Library lib) {

        outerScope = curScope;
        //System.out.println(outerScope);

        if (cdp != null)
            cdp.check(this, lib);

        if (vdp != null)
            vdp.check(this, lib);

        if (pdList != null) {
            for (ProcDecl pd : pdList) {
                pd.check(this, lib);
            }
        }

        if (stml != null)
            stml.check(this, lib);


        //Kan dette være feilen?
        //Context er program. Program sin check kjører progblock sin check.
        //Siden progblock er en check kjører den context.check() osv ...
        //context.check(this, lib);
    }

    @Override
    public void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    @Override
    public String identify() {
        return "<block> on line " + lineNum;
    }

    @Override
    void prettyPrint() {


        if (cdp != null)
            cdp.prettyPrint();

        if (vdp != null)
            vdp.prettyPrint();

        if (!pdList.isEmpty()) {
            for (ProcDecl pd : pdList) {
                pd.prettyPrint();
            }
        }

        Main.log.prettyPrintLn();
        Main.log.prettyPrintLn("begin");

        Main.log.prettyIndent();
        stml.prettyPrint();
        Main.log.prettyOutdent();

        Main.log.prettyPrint("end");

    }

    static Block parse(Scanner s) {
        enterParser("block");
        Block bl = new Block(s.curLineNum());

        if (s.curToken.kind == constToken)
            bl.cdp = ConstDeclPart.parse(s);


        if (s.curToken.kind == varToken)
            bl.vdp = VarDeclPart.parse(s);


        while (s.curToken.kind == functionToken || s.curToken.kind == procedureToken) {
            if (s.curToken.kind == functionToken) {
                bl.pdList.add(FuncDecl.parse(s));

            } else {
                bl.pdList.add(ProcDecl.parse(s));
            }
        }

        s.skip(beginToken);
        bl.stml = StatmList.parse(s);
        s.skip(endToken);

        leaveParser("block");
        return bl;
    }
}
