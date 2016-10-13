package parser;

import main.Main;
import scanner.Scanner;
import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
class FuncDecl extends ProcDecl {

    private String name;
    private ParamDeclList pdl;
    private parser.TypeName tn;
    private Block blck;

    FuncDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<func-decl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint("function");
        Main.log.prettyPrint(name);

        if (pdl != null)
            pdl.prettyPrint();

        Main.log.prettyPrint(":");
        tn.prettyPrint();
        Main.log.prettyPrint(";");
        blck.prettyPrint();
        Main.log.prettyPrint(";");
    }

    static FuncDecl parse(Scanner s) {
        enterParser("func-decl");
        FuncDecl fd = new FuncDecl(s.curToken.id, s.curLineNum());

        s.skip(functionToken);
        s.test(nameToken);
        fd.name = s.curToken.id;
        s.skip(nameToken);

        if (s.curToken.kind == leftParToken)
            fd.pdl = ParamDeclList.parse(s);

        s.skip(colonToken);
        fd.tn = TypeName.parse(s);
        s.skip(semicolonToken);
        fd.blck = Block.parse(s);
        s.skip(semicolonToken);

        leaveParser("func-decl");
        return fd;
    }
}
