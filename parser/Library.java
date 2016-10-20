package parser;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
public class Library extends Block {

    public Library(int lNum) {
        super(lNum);
    }

    @Override
    void check(Block curScope, Library lib) {

    }

    @Override
    public String identify() {
        return "<library> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }
}
