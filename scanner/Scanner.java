package scanner;

import main.Main;

import java.io.*;

/**
 * Scanner class used for scanning and tokenizing Pascal2016 code. Based on base code provided through INF2100.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @since 2016-09-19
 */
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

        /*
        TODO
        - Gjøre kommentar metode mer generell
        - Bruk sourcepos istedenfor substring for å navigere i sourceline
        - Javadoc
        */
		
	 /**
      * Finds and tokenizes objects from the current sourceline of the scanned document.
      * A <tt>Token</tt> object is created using the various constructors based on the content of sourceLine (except for the EOF token).
      * The sourceLine is modified along the way using substring() until it's empty.
      * Then updates nextToken so that the method is ready to be called again.
      */

    public void readNextToken() {
        curToken = nextToken;  nextToken = null;

        //Check for empty lines, run readNextLine() if empty
        checkEmptyLine();

        sourceLine = trimStart(sourceLine);
        char c = sourceLine.charAt(0);

        Token tmp;
        String tok = "";

        //Checks if comment
        if (c == '/' && sourceLine.substring(1,2).equals("*") || c == '{') {
            removeComment(tok,c);
            checkEmptyLine();
            sourceLine = trimStart(sourceLine);
            c= sourceLine.charAt(0);
        }

        //Checks if A-Z
        if (isLetterAZ(c)) {

            while (isLetterAZ(c) || isDigit(c)) {

                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(tok.toLowerCase(), getFileLineNum());
        }
        //Checks if Digit
        else if (isDigit(c) || (c == '-' && isDigit(sourceLine.charAt(1)))) {

            if (c == '-') {
                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }

            while (isDigit(c)) {
                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(Integer.parseInt(tok), getFileLineNum());
        }
        //Checks if EOF
        else if (endOfFile) {
            tmp = new Token("eof", getFileLineNum());
            sourceLine = "";
        }
        //Checks if char(s)
        else {

            //Nullpointer check for special cases
            if (sourceLine.length() >= 2) {
                tok = sourceLine.substring(0, 2);
            }
            //Checks special cases
            if (tok.equals(":=") || tok.equals(">=") || tok.equals("<=") || tok.equals("<>") || tok.equals("..")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

                nextToken = tmp;
                Main.log.noteToken(nextToken);
                return;

            }
            //Checks if ' '
            if (sourceLine.length() >= 3) {

                if (sourceLine.charAt(0) == '\'') {

                    if (sourceLine.length() >= 4) {
                        //Iteral escaped with '
                        if (sourceLine.substring(0, 4).equals("\'\'\'\'")) {
                            tmp = new Token('\'', getFileLineNum());

                            sourceLine = sourceLine.substring(4);
                            nextToken = tmp;
                            Main.log.noteToken(nextToken);
                            System.out.println("Opprettet Token: " + tmp.identify());
                            return;
                        }
                    }
                    //Iteral with whatever between '
                    if (sourceLine.charAt(2) == '\'') {
                        tmp = new Token ("'" + sourceLine.charAt(1) + "'", getFileLineNum());

                        sourceLine = sourceLine.substring(3);
                        nextToken = tmp;
                        Main.log.noteToken(nextToken);
                        System.out.println("Opprettet Token: " + tmp.identify());
                        return;
                    }
                    else {
                        //Iteral started with no end
                        error("Illegal char literal!");
                    }
                }
            }
            //Normal char
            char t = sourceLine.charAt(0);
            checkLegalChar(t);
            sourceLine = sourceLine.substring(1);
            tmp = new Token(t, getFileLineNum());

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
                    sourceLine = "*EOF*";
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
            sourceLine = trimStart(sourceLine);
        }
    }

    private String trimStart(String s){
        while (s.length() > 0 && Character.isWhitespace(s.charAt(0))){
            s = s.substring(1);
        }
        return s;
    }

    private void checkLegalChar(char c) {
        String tegn = "+:;.=<>[(*])-,";

        if (!tegn.contains(c + ""))
            error("Illegal character: '" + c + "'!");
    }

    private void removeComment(String tok, char c) {

        if (c == '{') {
            try {
                while (!sourceLine.substring(0,1).equals("}")) {

                    //if (sourceFile.hasNext()) {}

                    tok = tok + c;

                    //Multiline comment
                    if (sourceLine.length() == 1) {
                        //readNextLine();
                        checkEmptyLine();
                        System.out.println("Multiline comment. Next part: " + sourceLine);
                    }

                    if (!sourceLine.substring(0,1).equals("}")) {
                        sourceLine = sourceLine.substring(1);
                        c= sourceLine.charAt(0);
                    }

                }
                //Removes "}" at the end
                sourceLine = sourceLine.substring(1);
                tok += "}";

                System.out.println("Dette er en kommentar: " + tok);
                System.out.println("Dette er igjen av sourceline: " + sourceLine);


            } catch (Exception e) {
                error("No end for comment starting on line " + curLineNum() + "!");
            }
        } else {
            try {
                while (!sourceLine.substring(0,2).equals("*/")) {

                    tok = tok + c;

                    //Multiline comment
                    if (sourceLine.length() == 2) {
                        readNextLine();
                        checkEmptyLine();
                        System.out.println("Multiline comment. Next part: " + sourceLine);
                    }

                    if (!sourceLine.substring(0,2).equals("*/")) {
                        sourceLine = sourceLine.substring(1);
                        c= sourceLine.charAt(0);
                    }

                }
                //Removes "*/" at the end
                sourceLine = sourceLine.substring(2);
                tok += "*/";

                System.out.println("Dette er en kommentar: " + tok);

            } catch (Exception e) {
                error("No end for comment starting on line " + curLineNum() + "!");
            }
        }
    }
}
