package scanner;

import main.Main;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
        - Implenetere tegn-tokens
        - Ta høyde for linjeskift i kommentarer (antar det finnes)
        - Sjekke for e-o-f på slutten av filen
        - Dele opp metoden i mindre deler
        - Javadoce

        Testenv: -testscanner ./ressurser/test/mini.pas
        På original mini.pas
        */

	    curToken = nextToken;  nextToken = null;

        //Sjekker for tom linje(r)
        while (sourceLine.trim().isEmpty() ) {

            readNextLine();
            System.out.println("Linje var tom. Readnextline() kjørt, linje er nå: " + sourceLine);

        }

        //Fjerner space
        sourceLine = sourceLine.trim();
        System.out.println("Linje: " + sourceLine);

        Token tmp = null;
        String tok = "";
        char c= sourceLine.charAt(0);

        //Sjekker om A-Z
        if (isLetterAZ(c)) {
            while (isLetterAZ(c)) {
                tok += c;

                //Kodesnutten under tror jeg ikke fungerer
                if (sourceLine.length() == 0) {
                    System.out.println(" Linje: " + getFileLineNum());
                    readNextLine();
                }

                sourceLine = sourceLine.substring(1);
                c= sourceLine.charAt(0);
            }
            tmp = new Token(tok, getFileLineNum());
        }
        //Sjekker om Digit
        else if (isDigit(c)) {
            while (isDigit(c))
            {
                tok = tok + c;

                //Kodesnutten under tror jeg ikke fungerer
                if (sourceLine.length() == 0) {
                    System.out.println(" Linje: " + getFileLineNum());
                    readNextLine();
                }
                sourceLine = sourceLine.substring(1);
                c= sourceLine.charAt(0);
            }
        }
        //Sjekk om kommentar
        else if (c == '/' && sourceLine.substring(1,2).equals("*")) {

            try {
                System.out.println("Fant kommentar start på linjepos: " + sourcePos);
                int teller = 1;
                while (!sourceLine.substring(0,2).equals("*/")) { //  c != '*' && !sourceLine.substring(1,2).equals("/"

                    //Debugg
                    //System.out.println(teller + ": " + "C: " + c + " andre: " + sourceLine.substring(1,2));
                    //teller++;

                    tok = tok + c;

                    //Kodesnutten under tror jeg ikke fungerer
                    if (sourceLine.trim().isEmpty()) {
                        System.out.println("Linjeskift i kommentar: " + getFileLineNum());
                        readNextLine();
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
               error("ERROR: Comment did not end.");
            }
        }
        //Alle tegn (ikke tall, bokstaverAZ eller kommentar)
        else {

            System.out.println("*Ikke implementert* Dette antar jeg er et tegn: " + sourceLine);

            /* Disse er de sammensatte tegnene: (resten kan behandles enklere)
            1: :=
            2: >=
            3: <=
            4: <>
            */


            


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
