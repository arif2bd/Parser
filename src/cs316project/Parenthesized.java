package cs316project;

import java.util.*;


class Parenthesized extends Exp
{
	Exp e;

	Parenthesized(Exp exp)
	{
		e = exp;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary>"); 
		e.printParseTree(indent+" ");
	}
/**
	Val Eval(HashMap<String,Val> state)
	{
		return e.Eval(state);
	}
	
	void emitInstructions()
	{
		e.emitInstructions();
	}
	**/
}


/**
class Parenthesized extends Primary
{
	E e;

	Parenthesized(E exp)
	{
		e = exp;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary>"); 
		e.printParseTree(indent+" ");
	}

	Val Eval(HashMap<String,Val> state)
	{
		return e.Eval(state);
	}
	
	void emitInstructions()
	{
		e.emitInstructions();
	}
}


**/
