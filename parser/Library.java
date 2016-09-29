package parser;

/**
 * Created by marius on 22.09.2016.
 */
class Library extends PascalSyntax {

    Library(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }
}
