package parser;

/**
 * Created by marius on 22.09.2016.
 */
abstract class Operator extends PascalSyntax {
    Operator(int lNum) {
        super(lNum);
    }

    @Override
    public String identify() {
        return "<NAVN-HER> on line " + lineNum;
    }

}
