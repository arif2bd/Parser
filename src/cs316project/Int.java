package cs316project;

import java.util.*;

class Int extends Exp
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary> " + val);
	}

	Val Eval(HashMap<String,Val> state)
	{
		return new IntVal(val);
	}
	
	void emitInstructions()
	{
		IO.displayln("push " + val);
	}
}


/**
class Int extends Primary
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary> " + val);
	}

	Val Eval(HashMap<String,Val> state)
	{
		return new IntVal(val);
	}
	
	void emitInstructions()
	{
		IO.displayln("push " + val);
	}
}

**/