package parser;

import scanner.Scanner;

import static scanner.TokenKind.*;


/**
 * Created by marius on 22.09.2016.
 */
/* <paramDecl> ::= <name> ’:’ <type name> */
class ParamDecl extends PascalDecl {

    String name;
    TypeName tn;

    ParamDecl(String id, int lNum) {
        super(id, lNum);
    }

    @Override
    public String identify() {
        return "<paramDecl> on line " + lineNum;
    }

    @Override
    void prettyPrint() {

    }

    static ParamDecl parse(Scanner s) {
        enterParser("param-decl");
        ParamDecl pd = new ParamDecl(s.curToken.id, s.curLineNum());

        s.test(nameToken);
        pd.name = s.curToken.id;
        s.skip(nameToken);

        s.skip(colonToken);


        /* @TODO: Vet ikke hvordan jeg behandler TypeName enda.

        *   Fant svaret!
        *   "Siden det finnes ikke-terminaler i jernbanediagrammene som heter Type, TypeName og ArrayType,
        *   vil du trenger klasser for hver av disse, og de skal ligge i parser-pakken.
        *   I pakken types ligger noen klasser som først skal brukes i del 3 av prosjektet,
        *   så de kan ignoreres foreløpig. (Legg merke til at det da vil finnes både en parser.Type og en types.Type
        *   men det er helt OK så lenge de omtales med fullt navn («parser.Type»).
        *   Klassen Library skal inneholde predefinerte konstanter, typer og prosedyrer (EoL, Boolean, Char, Integer
        *   og Write); vi kommer til dette i del 3 av prosjektet."
         */

        pd.tn = TypeName.parse(s);


        leaveParser("param-decl");
        return pd;
    }

    @Override
    void checkWhetherAssignable(PascalSyntax where) {

    }

    @Override
    void checkWhetherFunction(PascalSyntax where) {

    }

    @Override
    void checkWhetherProcedure(PascalSyntax where) {

    }

    @Override
    void checkWhetherValue(PascalSyntax where) {

    }
}
