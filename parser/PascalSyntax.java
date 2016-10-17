package parser;

import main.*;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
abstract class PascalSyntax {
    public int lineNum;

    PascalSyntax(int n) {
	lineNum = n;
    }

    boolean isInLibrary() {
	return lineNum < 0;
    }

    // Del 3: abstract void check(Block curScope, Library lib);
    // Del 4: abstract void genCode(CodeFile f);
    abstract public String identify();

    public void error(String message) {
	Main.error("Error at line " + lineNum + ": " + message);
    }

    static void enterParser(String nonTerm) {
	Main.log.enterParser(nonTerm);
    }

    static void leaveParser(String nonTerm) {
	Main.log.leaveParser(nonTerm);
    }

    abstract void prettyPrint();
}