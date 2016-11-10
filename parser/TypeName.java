package parser;

import main.CodeFile;
import main.Main;
import scanner.Scanner;
import scanner.TokenKind;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
class TypeName extends Type {

    protected String name;

    types.Type type;

    TypeName(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {
        TypeDecl td = (TypeDecl) curScope.findDecl(name, this);
        type = td.type;
        //System.out.println("Type Name er:" + type);
    }

    @Override
    void genCode(CodeFile f) {
        String testLabel = f.getLocalLabel(),
                endLabel = f.getLocalLabel();
    }

    public static TypeName parse(Scanner s) {
        enterParser("type name");
        TypeName tn = new TypeName(s.curLineNum());

        s.test(TokenKind.nameToken);
        tn.name = s.curToken.id;
        s.skip(TokenKind.nameToken);

        leaveParser("type name");
        return tn;
    }

    @Override
    public String identify() {
        return "<type name> on line " + lineNum;
    }

    @Override
    void prettyPrint() {
        Main.log.prettyPrint(name);
    }
}
