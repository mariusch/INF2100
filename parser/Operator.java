package parser;

/**
 * Parser class used for creating a syntax tree with tokens from the scanner module.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-10-17
 */
abstract class Operator extends PascalSyntax {

    Operator(int lNum) {
        super(lNum);
    }

    abstract void prettyPrint();

    @Override
    public String identify() {
        return "<operator> on line " + lineNum;
    }

}
