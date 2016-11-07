package parser;

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

    private String name;

    types.Type intType = new types.IntType();

    TypeName(int n) {
        super(n);
    }

    @Override
    void check(Block curScope, Library lib) {

        System.out.println("TYPENAME: " + name);

        if (name.equals("integer")) {
            TypeDecl newIntType = new TypeDecl("integer", 0);
            newIntType.setType(this.intType);
            curScope.addDecl(newIntType.name, newIntType);
        } else if (name.equals("boolean")) {

        } else {
            error("Error in parse.TypeName: Could not match " + name + " to any type.");
        }
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
