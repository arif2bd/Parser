package cs316project;
import java.util.*;

class MultipleFunDef extends FunDeflist
{
	FunDef fundef;
	FunDeflist fundefList;

	MultipleFunDef(FunDef a, FunDeflist al)
	{
		fundef = a;
		fundefList = al;
	}
 
	void printParseTree(String indent)
	{		
		fundef.printParseTree(indent);
		fundefList.printParseTree(indent);
	}

	/**
	void M(HashMap<String,Val> state) // function to interpret this list of multiple assignments
	{
		assignment.M(state);
		assignmentList.M(state);
	}
	
	void emitInstructions()
	{
		assignment.emitInstructions();
		assignmentList.emitInstructions();
	}
	**/
}


