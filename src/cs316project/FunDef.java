package cs316project;
import java.util.*;

class FunDef extends FunDeflist
{
	HeaderAbs header;
	Exp e;
	
	FunDef(HeaderAbs s, Exp exp)
	{
		header = s;
		e = exp;
	}
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
				
		IO.displayln(indent + indent.length() + " <fundef>");
		header.printParseTree(indent1);
		e.printParseTree(indent1);
		IO.displayln(indent);
		//IO.displayln(indent1 + indent1.length() + " =");
		//e.printParseTree(indent1);
	}
}

/**
class Assignment extends AssignmentList
{
	String id; // variable on the left side of the assignment
	E e;       // expression on the right side of the assignment

	Assignment(String s, E exp)
	{
		id = s;
		e = exp;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
				
		IO.displayln(indent + indent.length() + " <assignment>");
		IO.displayln(indent1 + indent1.length() + " " + id);
		IO.displayln(indent1 + indent1.length() + " =");
		e.printParseTree(indent1);
	}
	
	
}


**/