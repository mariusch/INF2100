package scanner;

import static scanner.TokenKind.*;

public class Token {
    public TokenKind kind;
    public String id;
    public char charVal;
    public int intVal, lineNum;

    Token(TokenKind k, int lNum) {
	    kind = k;  lineNum = lNum;
    }

    /**
     * Creates Token based on string input.
     * Modified to handle operators, literals and EOF.
     *
     * @param s
     * @param lNum
     */
    Token(String s, int lNum) {
	if (s.equals("and"))
	    kind = andToken;
	else if (s.equals("array"))
	    kind = arrayToken;
	else if (s.equals("begin"))
	    kind = beginToken;
	else if (s.equals("const"))
	    kind = constToken;
	else if (s.equals("div"))
	    kind = divToken;
	else if (s.equals("do"))
	    kind = doToken;
	else if (s.equals("else"))
	    kind = elseToken;
	else if (s.equals("end"))
	    kind = endToken;
	else if (s.equals("function"))
	    kind = functionToken;
	else if (s.equals("if"))
	    kind = ifToken;
	else if (s.equals("mod"))
	    kind = modToken;
	else if (s.equals("not"))
	    kind = notToken;
	else if (s.equals("of"))
	    kind = ofToken;
	else if (s.equals("or"))
	    kind = orToken;
	else if (s.equals("procedure"))
	    kind = procedureToken;
	else if (s.equals("program"))
	    kind = programToken;
	else if (s.equals("then"))
	    kind = thenToken;
	else if (s.equals("var"))
	    kind = varToken;
	else if (s.equals("while"))
	    kind = whileToken;

	//Operator tokens and EOF
	else if (s.equals("+"))
		kind = addToken;
	else if (s.equals(":="))
		kind = assignToken;
	else if (s.equals(">="))
		kind = greaterEqualToken;
	else if (s.equals("<="))
		kind = lessEqualToken;
	else if (s.equals("<>"))
		kind = notEqualToken;
	else if (s.equals(".."))
		kind = rangeToken;
    else if (s.equals("eof"))
        kind = eofToken;

    //We know the length of this String is 3 because of how strings are handled in Scanner.
    else if (s.startsWith("'") && s.endsWith("'")) {
        String tmp = s.substring(1,2);
        charVal = tmp.charAt(0);
        kind = charValToken;
    }
	else
	    kind = nameToken;

	id = s;  lineNum = lNum;
    }

    Token(int n, int lNum) {
	    kind = intValToken;  intVal = n;  lineNum = lNum;
    }

    Token(char c, int lNum) {
	    charVal = c;  lineNum = lNum;
		//Sets kind based on char value
		if (c == '+')
			kind = addToken;
		else if (c == ':')
			kind = colonToken;
		else if (c == ',')
			kind = commaToken;
		else if (c == '.')
			kind = dotToken;
		else if (c == '=')
			kind = equalToken;
		else if (c == '>')
			kind = greaterToken;
		else if (c == '[')
			kind = leftBracketToken;
		else if (c == '(')
			kind = leftParToken;
		else if (c == '<')
			kind = lessToken;
		else if (c == '*')
			kind = multiplyToken;
		else if (c == ']')
			kind = rightBracketToken;
		else if (c == ')')
			kind = rightParToken;
		else if (c == ';')
			kind = semicolonToken;
		else if (c == '-')
			kind = subtractToken;
		else
			kind = charValToken;
    }


    public String identify() {
        String t = kind.identify();
        if (lineNum > 0)
            t += " on line " + lineNum;

        switch (kind) {
            case nameToken:    t += ": " + id;  break;
            case intValToken:  t += ": " + intVal;  break;
            case charValToken: t += ": '" + charVal + "'";  break;
        }
        return t;
    }
}
