package cs316project;

import java.util.*;

abstract class Term
{
	Primary primary;

	abstract void printParseTree(String indent);
	abstract Val Eval(HashMap<String,Val> state);
	abstract void emitInstructions();
}