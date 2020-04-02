package cs316project;

/**
Author: Arif Rahman
CUNY ID: 12283520

This class is a lexical analyzer for the tokens defined by the grammar:

<letter> --> a | b | ... | z | A | B | ... | Z
<digit> --> 0 | 1 | ... | 9
<id> --> <letter< {<letter> | <digit>}
<int> --> [+|-] {<digit>}+
<float> --> [+|-] ( {<digit>}+ "." {<digit>}  |  "." {<digit>}+ )
<floatE> --> (<int> | <float>) (e|E) [+|-] {<digit>}+
<floatF> --> (<int> | <float> | <floatE>) ("f" | "F")
<add> --> +
<sub> --> -
<mul> --> *
<div> --> /
<lt> --> <
<le> --> "<="
<gt> --> >
<ge> --> ">="
<eq> --> =
<LParen> --> (
<RParen> --> )
<LBrace> --> {
<RBrace> --> }  

<Keyword_if>    --> if
<Keyword_then>  --> then		
<Keyword_else>	-->	else
<Keyword_or>	-->	or
<Keyword_and>	-->	and
<Keyword_not>	-->	not
<Keyword_pair>	-->	pair	
<Keyword_first>	-->	first
<Keyword_second>-->	second
<Keyword_nil>	-->	nil
<Semicolon>     -->  ;
**/

public abstract class LexAnalyzer extends IO
{
	public enum State 
       	{ 
	  // non-final states     ordinal number

		Start,             // 0
		dot,               // 1
		E,                 // 2
		EPlusMinus,        // 3

	  // final states

		Id,                // 4
		Int,               // 5
		Float,             // 6
		FloatE,            // 7
		Add,               // 8
		Sub,               // 9
		Mul,               // 10
		Div,               // 11
		LParen,            // 12
		RParen,            // 13
		Lt,					//14
		Le,					//15
		Gt,					//16
		Ge,					//17
		Eq,					//18
		LBrace,				//19
		RBrace,				//20 
		FloatF,				//21
		
		
		//additional keyword
		Keyword_if,			//22
		Keyword_then,		//23
		Keyword_else,		//24
		Keyword_or,			//25
		Keyword_and,		//26
		Keyword_not,		//27
		Keyword_pair,		//28	
		Keyword_first,		//29
		Keyword_second,		//30
		Keyword_nil,		//31
		Semicolon,			//32
		
		UNDEF;

		private boolean isFinal()
		{
			return ( this.compareTo(State.Id) >= 0 );  
		}	
	}

	// By enumerating the non-final states first and then the final states,
	// test for a final state can be done by testing if the state's ordinal number
	// is greater than or equal to that of Id.

	// The following variables of "IO" class are used:

	//   static int a; the current input character
	//   static char c; used to convert the variable "a" to the char type whenever necessary

	public static String t; // holds an extracted token
	public static State state; // the current state of the FA

	private static State nextState[][] = new State[33][128];
 
          // This array implements the state transition function State x (ASCII char set) --> State.
          // The state argument is converted to its ordinal number used as
          // the first array index from 0 through 31. 

	private static int driver()

	// This is the driver of the FA. 
	// If a valid token is found, assigns it to "t" and returns 1.
	// If an invalid token is found, assigns it to "t" and returns 0.
	// If end-of-stream is reached without finding any non-whitespace character, returns -1.

	{
		State nextSt; // the next state of the FA

		t = "";
		state = State.Start;

		if ( Character.isWhitespace((char) a) )
			a = getChar(); // get the next non-whitespace character
		if ( a == -1 ) // end-of-stream is reached
			return -1;

		while ( a != -1 ) // do the body if "a" is not end-of-stream
		{
			c = (char) a;
			nextSt = nextState[state.ordinal()][a];
			if ( nextSt == State.UNDEF ) // The FA will halt.
			{
				if ( state.isFinal() ) 
					return 1; // valid token extracted
				else // "c" is an unexpected character
				{
					t = t+c;
					a = getNextChar();
					return 0; // invalid token found
				}
			}
			else // The FA will go on.
			{
				state = nextSt;
				t = t+c;
				a = getNextChar();
			}
		}

		// end-of-stream is reached while a token is being extracted

		if ( state.isFinal() ) 
				return 1; // valid token extracted 
		else
			return 0; // invalid token found
	} // end driver

	public static void getToken()

	// Extract the next token using the driver of the FA.
	// If an invalid token is found, issue an error message.

	{
		int i = driver();
		if ( i == 0 )
			displayln(t + " : Lexical Error, invalid token");
	}

	private static void setNextState()
	{
		for (int s = 0; s <= 32; s++ )
			for (int c = 0; c <= 127; c++ ) 
				nextState[s][c] = State.UNDEF;
		
		for (char c = 'A'; c <= 'Z'; c++)
		{
			nextState[State.Start.ordinal()][c] = State.Id;
			nextState[State.Id   .ordinal()][c] = State.Id;
		}
		
		
		for (char c = 'a'; c <= 'z'; c++)
		{
			nextState[State.Start.ordinal()][c] = State.Id;
			nextState[State.Id   .ordinal()][c] = State.Id;

		}

		for (char d = '0'; d <= '9'; d++)
		{
			nextState[State.Start     .ordinal()][d] = State.Int;
			nextState[State.Id        .ordinal()][d] = State.Id;
			nextState[State.Int       .ordinal()][d] = State.Int;
			
			nextState[State.Add		   .ordinal()][d] = State.Int;
			nextState[State.Sub		   .ordinal()][d] = State.Int;
			
			nextState[State.dot    .ordinal()][d] = State.Float;
			nextState[State.Float     .ordinal()][d] = State.Float;
			nextState[State.E         .ordinal()][d] = State.FloatE;
			nextState[State.EPlusMinus.ordinal()][d] = State.FloatE;
			nextState[State.FloatE    .ordinal()][d] = State.FloatE;
		}

		nextState[State.Start.ordinal()]['+'] = State.Add;
		nextState[State.Start.ordinal()]['-'] = State.Sub;
		nextState[State.Start.ordinal()]['*'] = State.Mul;
		nextState[State.Start.ordinal()]['/'] = State.Div;
		nextState[State.Start.ordinal()]['('] = State.LParen;
		nextState[State.Start.ordinal()][')'] = State.RParen;
		nextState[State.Start.ordinal()]['{'] = State.LBrace;
		nextState[State.Start.ordinal()]['}'] = State.RBrace;
		nextState[State.Start.ordinal()]['>'] = State.Gt;
		nextState[State.Start.ordinal()]['<'] = State.Lt;
		nextState[State.Start.ordinal()]['='] = State.Eq;
		nextState[State.Start.ordinal()][';'] = State.Semicolon;
		
		nextState[State.Add.ordinal()]['.'] = State.dot;
		nextState[State.Sub.ordinal()]['.'] = State.dot;
		nextState[State.Gt.ordinal()]['='] = State.Ge;
		nextState[State.Lt.ordinal()]['='] = State.Le;
		nextState[State.Start.ordinal()]['.'] = State.dot;
		nextState[State.Int.ordinal()]['f'] = State.FloatF;
		nextState[State.Int.ordinal()]['F'] = State.FloatF;
		nextState[State.Float.ordinal()]['f'] = State.FloatF;
		nextState[State.Float.ordinal()]['F'] = State.FloatF;
		nextState[State.FloatE.ordinal()]['f'] = State.FloatF;
		nextState[State.FloatE.ordinal()]['F'] = State.FloatF;
				
		
		nextState[State.Int.ordinal()]['.'] = State.Float;
		nextState[State.Int.ordinal()]['e'] = State.E;
		nextState[State.Int.ordinal()]['E'] = State.E;
		
		nextState[State.Float.ordinal()]['E'] = state.E;
		nextState[State.Float.ordinal()]['e'] = state.E;
			
		nextState[State.E.ordinal()]['+'] = State.EPlusMinus;
		nextState[State.E.ordinal()]['-'] = State.EPlusMinus;

	} // end setNextState

	public static void setLex()

	// Sets the nextState array.

	{
		setNextState();
	}

	public static void main(String argv[])

	{		
		// argv[0]: input file containing source code using tokens defined above
		// argv[1]: output file displaying a list of the tokens 

		setIO( argv[0], argv[1] );
		setLex();
		
		int i;

		while ( a != -1 ) // while "a" is not end-of-stream
		{
			i = driver(); // extract the next token
			if ( i == 1 ) {
				//check if it matches to the keyword
				if(t.equals("if")) {
					state = State.Keyword_if;
				}else if(t.equals("then")) {
					state = State.Keyword_then;
				}else if(t.equals("else")) {
					state = State.Keyword_else;
				}else if(t.equals("or")) {
					state = State.Keyword_or;
				}else if(t.equals("and")) {
					state = State.Keyword_and;
				}else if(t.equals("not")) {
					state = State.Keyword_not;
				}else if(t.equals("pair")) {
					state = State.Keyword_pair;
				}else if(t.equals("first")) {
					state = State.Keyword_first;
				}else if(t.equals("second")) {
					state = State.Keyword_second;
				}else if(t.equals("nil")) {
					state = State.Keyword_nil;
				}else {
					
				}
				displayln( t+"   : "+state.toString() ); 
			}
			else if ( i == 0 )
				displayln( t+" : Lexical Error, invalid token");
		} 

		closeIO();
	}
} 
