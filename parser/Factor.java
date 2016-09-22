package parser;

/**
 * Created by marius on 22.09.2016.
 */
abstract class Factor extends PascalSyntax {

    Factor(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }
}
