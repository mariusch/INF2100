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

    Token(String s, int lNum) {
	if (s.equalsIgnoreCase("and"))
	    kind = andToken;
	else if (s.equalsIgnoreCase("array"))
	    kind = arrayToken;
	else if (s.equalsIgnoreCase("begin"))
	    kind = beginToken;
	else if (s.equalsIgnoreCase("const"))
	    kind = constToken;
	else if (s.equalsIgnoreCase("div"))
	    kind = divToken;
	else if (s.equalsIgnoreCase("do"))
	    kind = doToken;
	else if (s.equalsIgnoreCase("else"))
	    kind = elseToken;
	else if (s.equalsIgnoreCase("end"))
	    kind = endToken;
	else if (s.equalsIgnoreCase("function"))
	    kind = functionToken;
	else if (s.equalsIgnoreCase("if"))
	    kind = ifToken;
	else if (s.equalsIgnoreCase("mod"))
	    kind = modToken;
	else if (s.equalsIgnoreCase("not"))
	    kind = notToken;
	else if (s.equalsIgnoreCase("of"))
	    kind = ofToken;
	else if (s.equalsIgnoreCase("or"))
	    kind = orToken;
	else if (s.equalsIgnoreCase("procedure"))
	    kind = procedureToken;
	else if (s.equalsIgnoreCase("program"))
	    kind = programToken;
	else if (s.equalsIgnoreCase("then"))
	    kind = thenToken;
	else if (s.equalsIgnoreCase("var"))
	    kind = varToken;
	else if (s.equalsIgnoreCase("while"))
	    kind = whileToken;
	//Andre tokens bestående av rekker med symboler
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
    else if (s.equalsIgnoreCase("eof"))
        kind = eofToken;
	else
	    kind = nameToken;

	id = s;  lineNum = lNum;
    }

    Token(int n, int lNum) {
	    kind = intValToken;  intVal = n;  lineNum = lNum;
    }

    Token(char c, int lNum) {
	    charVal = c;  lineNum = lNum;
		//Setter kind basert på char-verdi
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
