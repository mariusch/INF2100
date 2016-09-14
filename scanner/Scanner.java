package scanner;

import main.Main;

import java.io.*;

public class Scanner {
    public Token curToken = null, nextToken = null;

    private LineNumberReader sourceFile = null;
    private String sourceFileName, sourceLine = "";
    private int sourcePos = 0;

    public Scanner(String fileName) {
        sourceFileName = fileName;
        try {
            sourceFile = new LineNumberReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            Main.error("Cannot read " + fileName + "!");
        }

        readNextToken(); readNextToken();
    }


    public String identify() {
        return "Scanner reading " + sourceFileName;
    }


    public int curLineNum() {
        return curToken.lineNum;
    }


    private void error(String message) {
        Main.error("Scanner error on " +
                (curLineNum()<0 ? "last line" : "line "+curLineNum()) +
                ": " + message);
    }


    public void readNextToken() {
        /*
        TODO
        - Multiline comments - Oppretter Token av kommentar
        - Cleanup
        - Javadoc
        - Se at logg stemmer med referanse kompilator
        - Sjekke foiler/kompendiet
        */

        curToken = nextToken;  nextToken = null;

        sourceLine = trimStart(sourceLine);

        System.out.println("Linje: " + sourceLine);

        //Check for empty lines, run readNextLine() if empty
        checkEmptyLine();

        Token tmp = null;
        String tok = "";
        char c = sourceLine.charAt(0);

        //Sjekker om vi starter med A-Z
        if (isLetterAZ(c)) {

            while (isLetterAZ(c) || isDigit(c)) {

                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(tok, getFileLineNum());
        }
        //Sjekker om Digit
        else if (isDigit(c)) {

            while (isDigit(c)) {
                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(Integer.parseInt(tok), getFileLineNum());
        }
        //Sjekk om kommentar
        else if (c == '/' && sourceLine.substring(1,2).equals("*")) {

            try {
                System.out.println("Fant kommentar start på linjepos: " + sourcePos);
                while (!sourceLine.substring(0,2).equals("*/")) {

                    tok = tok + c;

                    //Multiline comments
                    if (sourceLine.length() == 2) {
                        readNextLine();
                        System.out.println("Multiline comment. Next part: " + sourceLine);
                    }

                    sourceLine = sourceLine.substring(1);
                    c= sourceLine.charAt(0);

                }
                //Klipper bort "*/" som ikke blir med i loopen
                sourceLine = sourceLine.substring(2);
                tok += "*/";
                System.out.println("Dette er en kommentar: " + tok);

                //TODO Dette er feil. Det skal ikke bli laget nametoken av kommentar. Midlertidig fix
                tmp = new Token(tok, getFileLineNum());

            } catch (Exception e) {
                //error("ERROR: Comment did not end.");
                System.out.println("Kommentar sluttet ikke.");
            }
        }
        //Alle tegn (ikke tall, bokstaverAZ eller kommentar)
        else {

            /* Disse er de sammensatte tegnene: (resten kan behandles enklere)
            1: :=
            2: >=
            3: <=
            4: <>
            */

            //For nullpointer
            if (sourceLine.length() >= 2) {
                tok = sourceLine.substring(0,2);
            }

            //Sjekker spesialtilfelle
            if (tok.equals(":=")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

            } else if (tok.equals(">=")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

            } else if (tok.equals("<=")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

            } else if (tok.equals("<>")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

            }else if (sourceLine.equals("*e-o-f*")) {
                //EOF token
                tmp = new Token("eof", getFileLineNum());
                sourceLine = "";

            }
            else {
                //Vanlig tegn token
                char t = sourceLine.charAt(0);
                sourceLine = sourceLine.substring(1);
                tmp = new Token(t, getFileLineNum());
            }

        }


        System.out.println("Opprettet Token: " + tmp.identify());
        System.out.println("Det som er igjen av linja: " + sourceLine);

        //Sett neste og logg den
        nextToken = tmp;
        Main.log.noteToken(nextToken);

    }


    private void readNextLine() {
        if (sourceFile != null) {
            try {
                sourceLine = sourceFile.readLine();
                if (sourceLine == null) {
                    sourceFile.close();  sourceFile = null;
                    sourceLine = "*e-o-f*";
                    //Fjern denne kommentaren - bare for debug
                    System.out.println("Slutt på filen!");
                } else {
                    sourceLine += " ";
                }
                sourcePos = 0;
            } catch (IOException e) {
                Main.error("Scanner error: unspecified I/O error!");
            }
        }
        if (sourceFile != null)
            Main.log.noteSourceLine(getFileLineNum(), sourceLine);
    }

    private void checkEmptyLine() {
        while (sourceLine.trim().isEmpty()) {

            readNextLine();
            //sourceLine = sourceLine.trim();
            //System.out.println("Linje var tom. Readnextline() kjørt, linje er nå: " + sourceLine);

        }
    }


    private int getFileLineNum() {
        return (sourceFile!=null ? sourceFile.getLineNumber() : 0);
    }


    // Character test utilities:

    private boolean isLetterAZ(char c) {
        return 'A'<=c && c<='Z' || 'a'<=c && c<='z';
    }

    private boolean isDigit(char c) {
        return '0'<=c && c<='9';
    }


    // Parser tests:

    public void test(TokenKind t) {
        if (curToken.kind != t)
            testError(t.toString());
    }

    public void testError(String message) {
        Main.error(curLineNum(),
                "Expected a " + message +
                        " but found a " + curToken.kind + "!");
    }

    public void skip(TokenKind t) {
        test(t);
        readNextToken();
    }

    private String trimStart(String s){
        while (s.length() > 0 && s.charAt(0) == ' '){
            s = s.substring(1);
        }
        return s;
    }
}
