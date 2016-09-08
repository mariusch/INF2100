package scanner;

import main.Main;
import static scanner.TokenKind.*;

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

	readNextToken();  readNextToken();
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
	curToken = nextToken;  nextToken = null;

        //Første kjøring


        // Del 1 her:
        //TODO Oblig 1 skal skrives her

        //Den viktigste metoden i Scanner er readNextToken som leser neste
        //symbol fra innfilen og lar nextToken peke på et nytt Token-objekt.

        //System.out.println("Linje: " + getFileLineNum());

        if (sourceLine.length() == 0) {
            System.out.println(" Linje: " + getFileLineNum());
            readNextLine();
        }

        sourceLine = sourceLine.trim();
        char c= sourceLine.charAt(0);

        //Hvis første char er A-Z eller a-z så må vi gå videre for å se om det er et name, programtoken eller noe annet ... helt til vi kommer til space
        Token tmp = null;

        //Hvis space, gå videre til ikke space

        String tok = "";

        if (isLetterAZ(c)) {
            while (isLetterAZ(c) == true) {
                tok += c;

                if (sourceLine.length() == 0) {
                    System.out.println(" Linje: " + getFileLineNum());
                    readNextLine();
                }
                sourceLine = sourceLine.substring(1);
                c= sourceLine.charAt(0);
            }
            tmp = new Token(tok, getFileLineNum());
        }
        //Hvis første er et siffer
        else if (isDigit(c)) {
            while (isDigit(c))
            {
                tok = tok + c;

                if (sourceLine.length() == 0) {
                    System.out.println(" Linje: " + getFileLineNum());
                    readNextLine();
                }
                sourceLine = sourceLine.substring(1);
                c= sourceLine.charAt(0);
            }
        }
        //Hvis annet tegn,
        else {
            //Hvis første er kommentartegn ...
                //Vi skal ta høyde for (fange) feil dersom det ikke er noen slutt på kommentar
            //Andre tegn ...
        }
        System.out.println("End of token! New token: " + tmp.identify());
        /*if isLetterAZ(c)
        {
        }*/
        nextToken = tmp;



        //Gjør dette til slutt
        Main.log.noteToken(nextToken);
    }


    private void readNextLine() {
	if (sourceFile != null) {
	    try {
		sourceLine = sourceFile.readLine();
		if (sourceLine == null) {
		    sourceFile.close();  sourceFile = null;
		    sourceLine = "";  
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
}
