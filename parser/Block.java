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
    protected VarDeclPart vdp;
    private ArrayList<ProcDecl> pdList = new ArrayList<ProcDecl>();
    private StatmList stml;
    protected PascalDecl context;

    protected HashMap<String, PascalDecl> decls = new HashMap<String, PascalDecl>();
    protected Block outerScope;

    Block(int lNum) {
        super(lNum);
    }

    void addDecl(String id, PascalDecl d) {
        if (decls.containsKey(id)){
            d.error(id + " declared twice in the same block!");
        }
        decls.put(id, d);
    }

    PascalDecl findDecl(String id, PascalSyntax where) {
        PascalDecl d = decls.get(id);

        if (d != null) {
            Main.log.noteBinding(id, where, d);
            return d;
        }

        if (outerScope != null ) {
            return outerScope.findDecl(id, where);
        }

        where.error("Name " + id + " is unknown!");
        return null;
    }

    @Override
    void check(Block curScope, Library lib) {

        outerScope = curScope;

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

    }

    @Override
    public void genCode(CodeFile f) {

        if (cdp != null)
            cdp.genCode(f);

        if (vdp != null)
            vdp.genCode(f);

        if (!pdList.isEmpty()) {
            for (ProcDecl pd : pdList) {
                pd.genCode(f);
            }

            /*for (int i = pdList.size()-1; i > 0; i--){
                pdList.get(i).genCode(f);
            }*/
        }

        String decln = "";
        if (context instanceof Program) {
            decln = "prog$";
        }
        else if (context instanceof FuncDecl) {
            decln = "func$";
        }
        else if (context instanceof ProcDecl) {
            decln = "proc$";
        } else {Main.panic(this.identify());}

        f.genInstr(decln+context.progProcFuncName, "enter", "$"+context.declOffset+",$1", "Start of " + context.name);

        if (stml != null)
            stml.genCode(f);
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

    int findDeclLvl() {
        int level = 0;
        Block tmp = this;

        while (tmp.outerScope != null) {
            level += 1;
            tmp = tmp.outerScope;
        }

        return level;
    }
}
