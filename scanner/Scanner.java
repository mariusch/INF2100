package scanner;

import main.Main;

import java.io.*;

public class Scanner {
    public Token curToken = null, nextToken = null;

    private LineNumberReader sourceFile = null;
    private String sourceFileName, sourceLine = "";
    private int sourcePos = 0;
    private boolean endOfFile = false;

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
        - Oppretter Token av kommentar
        - Tror den lager char tokens av mellomrom, ref linje 58 i primes. trimStart tar bare starten og ikke slutten?
        - Lage feilmeldinger (sourcePos bruker aldri?)
            - Kommentarer slutter ikke
            - Mer feilmeldinger 33 min ut i del 2 av podcast
        - Javadoc
        - Se at logg stemmer med referanse kompilator
        - Sjekke foiler/kompendiet
        */

        curToken = nextToken;  nextToken = null;

        System.out.println("Linje: " + sourceLine);
        sourceLine = trimStart(sourceLine);

        //Check for empty lines, run readNextLine() if empty
        checkEmptyLine();

        Token tmp = null;
        String tok = "";
        char c = sourceLine.charAt(0);

        //Checks if A-Z
        if (isLetterAZ(c)) {

            while (isLetterAZ(c) || isDigit(c)) {

                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            System.out.println(tok);
            tmp = new Token(tok, getFileLineNum());
        }
        //Checks if Digit
        else if (isDigit(c)) {

            while (isDigit(c)) {
                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(Integer.parseInt(tok), getFileLineNum());
        }
        //Checks if comment
        else if (c == '/' && sourceLine.substring(1,2).equals("*") || c == '{') {
            boolean s = false;
            if (c == '{')
                s = true;
            tmp = removeComment(tok,c,tmp, s);
        }
        //Checks if EOF
        else if (endOfFile) {
            tmp = new Token("eof", getFileLineNum());
            sourceLine = "";
        }
        //Checks if chars
        else {

            //Nullpointer check for char > 2
            if (sourceLine.length() >= 2) {
                tok = sourceLine.substring(0,2);
            }

            //Checks special cases
            if (tok.equals(":=") || tok.equals(">=") || tok.equals("<=") || tok.equals("<>")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

            } else {
                //Normal char
                char t = sourceLine.charAt(0);
                sourceLine = sourceLine.substring(1);
                tmp = new Token(t, getFileLineNum());
            }

        }

        System.out.println("Opprettet Token: " + tmp.identify());
        System.out.println("Det som er igjen av linja: " + sourceLine);

        //Set next and log
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
                    endOfFile = true;
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


    //Helper methods

    private void checkEmptyLine() {
        while (sourceLine.trim().isEmpty()) {
            readNextLine();
        }
    }

    private String trimStart(String s){
        while (s.length() > 0 && s.charAt(0) == ' '){
            s = s.substring(1);
        }
        return s;
    }

    private Token removeComment(String tok, char c, Token tmp, boolean s) {

        if (s) {
            try {
                while (!sourceLine.substring(0,1).equals("}")) {

                    tok = tok + c;

                    //Multiline comments
                    if (sourceLine.length() == 1) {
                        readNextLine();
                        System.out.println("Multiline comment. Next part: " + sourceLine);
                    }

                    sourceLine = sourceLine.substring(1);
                    c= sourceLine.charAt(0);

                }
                //Removes "}" at the end
                sourceLine = sourceLine.substring(1);
                tok += "}";

                //TODO Dette er feil. Det skal ikke bli laget nametoken av kommentar. Midlertidig fix
                tmp = new Token(tok, getFileLineNum());
                System.out.println("Dette er en kommentar: " + tok);

            } catch (Exception e) {
                //error("ERROR: Comment did not end.");
                System.out.println("Kommentar sluttet ikke.");
            }
        } else {
            try {
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
                //Removes "*/" at the end
                sourceLine = sourceLine.substring(2);
                tok += "*/";

                //TODO Dette er feil. Det skal ikke bli laget nametoken av kommentar. Midlertidig fix
                tmp = new Token(tok, getFileLineNum());
                System.out.println("Dette er en kommentar: " + tok);

            } catch (Exception e) {
                //error("ERROR: Comment did not end.");
                System.out.println("Kommentar sluttet ikke.");
            }
        }
        return tmp;
    }

}
