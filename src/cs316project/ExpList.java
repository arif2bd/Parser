package cs316project;
import java.util.*;

public abstract class ExpList {
abstract void printParseTree(String indent);
}

class SingleExpList extends ExpList
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " <ExpList>"); 
	}
	
}

class MulExpList extends ExpList
{
	Exp exp;
	ExpList expList;

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " <ExpList>"); 
		
		exp.printParseTree(indent + " ");
		
		// recusive explist
	}
	
}
