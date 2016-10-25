package parser;

import main.Main;
import scanner.Scanner;
import scanner.TokenKind;
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

    private HashMap<String, PascalDecl> decls = new HashMap<String, PascalDecl>();
    private Block outerScope;

    Block(int lNum) {
        super(lNum);
    }

    void addDecl(String id, PascalDecl d){
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

        if (outerScope != null){
            return outerScope.findDecl(id, where);
        }

        where.error("Name " + id + " is unknown!");
        return null;
    }

    @Override
    void check(Block curScope, Library lib) {
        if (cdp != null)
            cdp.check(this, lib);

        if (vdp != null)
            vdp.check(curScope, lib);

        if (pdList != null) {
            for (ProcDecl pd : pdList) {
                pd.check(curScope, lib);
            }
        }

        if (stml != null)
            stml.check(curScope, lib);

        context.check(curScope, lib);

        outerScope = curScope;
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

        if (s.curToken.kind == TokenKind.constToken)
            bl.cdp = ConstDeclPart.parse(s);


        if (s.curToken.kind == TokenKind.varToken)
            bl.vdp = VarDeclPart.parse(s);


        while (s.curToken.kind == TokenKind.functionToken || s.curToken.kind == TokenKind.procedureToken) {
            if (s.curToken.kind == TokenKind.functionToken){
                bl.pdList.add(FuncDecl.parse(s));

            } else {
                bl.pdList.add(ProcDecl.parse(s));
            }
        }

        s.skip(TokenKind.beginToken);
        bl.stml = StatmList.parse(s);
        s.skip(TokenKind.endToken);

        leaveParser("block");
        return bl;
    }
}
