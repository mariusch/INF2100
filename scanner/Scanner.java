package scanner;

import main.Main;

import java.io.*;

/**
 * Scanner class used for scanning and tokenizing input from Pascal2016 code files. Base code provided through INF2100.
 *
 * @author Marius Christensen
 * @author Silje Merethe Dahl
 * @version 2016-09-19
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
        Main.error("Scanner error" +
                (getFileLineNum()>0 ? " on line "+getFileLineNum() : "") +
                ": " + message);
    }
		
	 /**
      * Finds and tokenizes objects from the current sourceline of the scanned document.
      * A <tt>Token</tt> object is created using the various constructors based on the content of sourceLine (except for the EOF token).
      * The sourceLine is modified along the way using substring() until it's empty.
      * Then updates nextToken so that the method is ready to be called again.
      */

    public void readNextToken() {
        curToken = nextToken;  nextToken = null;

        //Check for e-o-f since the scanner is running ahead of the parser
        if (endOfFile) {
            //curToken = nextToken;
            return;
        }

        //Check for empty lines and run readNextLine() if empty
        checkEmptyLine();

        //Remove excess whitespace at beginning of sourceLine
        sourceLine = trimStart(sourceLine);

        char c = sourceLine.charAt(0);
        Token tmp;
        String tok = "";

        //Checks for and removes eventual comments
        if (c == '/' && sourceLine.substring(1,2).equals("*") || c == '{') {
            removeComment(c);
            checkEmptyLine();
            c = sourceLine.charAt(0);
        }

        //Checks if token string consists of a letter, possibly followed by letters or digits
        if (isLetterAZ(c)) {

            while (isLetterAZ(c) || isDigit(c)) {

                tok += c;
                sourceLine = sourceLine.substring(1);
                c = sourceLine.charAt(0);
            }
            tmp = new Token(tok.toLowerCase(), getFileLineNum());
        }
        //Checks if token string is a number
        else if (isDigit(c) || (c == '-' && isDigit(sourceLine.charAt(1)))) {

            if (c == '-') {
                sourceLine = sourceLine.substring(1);
                tmp = new Token(c, getFileLineNum());

                nextToken = tmp;
                Main.log.noteToken(nextToken);
                return;
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
        else {

            //Checks for operators
            if (sourceLine.length() >= 2) {
                tok = sourceLine.substring(0, 2);
            }
            if (tok.equals(":=") || tok.equals(">=") || tok.equals("<=") || tok.equals("<>") || tok.equals("..")) {

                tmp = new Token(tok, getFileLineNum());
                sourceLine = sourceLine.substring(2);

                nextToken = tmp;
                Main.log.noteToken(nextToken);
                return;

            }

            //Checks for special cases
            if (sourceLine.length() >= 3) {

                if (sourceLine.charAt(0) == '\'') {

                    if (sourceLine.length() >= 4) {

                        //Literal ', which in Pascal2016 is escaped with '
                        if (sourceLine.substring(0, 4).equals("\'\'\'\'")) {
                            tmp = new Token('\'', getFileLineNum());

                            sourceLine = sourceLine.substring(4);
                            nextToken = tmp;
                            Main.log.noteToken(nextToken);
                            return;
                        }
                    }
                    //Other literal characters
                    if (sourceLine.charAt(2) == '\'') {
                        tmp = new Token ("'" + sourceLine.charAt(1) + "'", getFileLineNum());

                        sourceLine = sourceLine.substring(3);
                        nextToken = tmp;
                        Main.log.noteToken(nextToken);
                        return;
                    }
                    else {
                        error("Illegal char literal!");
                    }
                }
            }
            //Normal symbol
            char t = sourceLine.charAt(0);
            checkLegalChar(t);
            sourceLine = sourceLine.substring(1);
            tmp = new Token(t, getFileLineNum());

        }

        //Set nextToken and log
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

    /**
     * Removes preliminary white space from a string.
     *
     * @param s The String to be trimmed
     * @return String with preliminary white space removed
     */
    private String trimStart(String s){
        while (s.length() > 0 && Character.isWhitespace(s.charAt(0))){
            s = s.substring(1);
        }
        return s;
    }

    private void checkLegalChar(char c) {
        String tegn = "+:;.= <>[(*])-,";

        if (!tegn.contains(c + ""))
            error("Illegal character: '" + c + "'!");
    }

    /**
     * Removes single and multiline comments.
     * Gives an error if the comment was never closed.
     *
     * @param c Decides which start of comment marker was used
     */
    private void removeComment(char c) {
        String commentEnd;

        if (c == '{') {
            commentEnd = "}";
        }
        else {
            commentEnd = "*/";
        }

        while (!sourceLine.substring(0,commentEnd.length()).equals(commentEnd)) {

            if (sourceLine.length() == commentEnd.length()) {
                readNextLine();
                checkEmptyLine();
            }

            if (endOfFile) {
                error("No end for comment starting on line " + curLineNum() + "!");
            }

            if (!sourceLine.substring(0,commentEnd.length()).equals(commentEnd)) {
                sourceLine = sourceLine.substring(1);
            }
        }
        sourceLine = sourceLine.substring(commentEnd.length());
    }
}
