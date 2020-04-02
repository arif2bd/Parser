package cs316project;
import java.util.*;

public abstract class BoolOp extends FunOp {
abstract void printParseTree(String indent);
}

class BoolOpor extends BoolOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " or"); 
	}
	
}

class BoolOpand extends BoolOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " and"); 
	}
	
}

class BoolOpnot extends BoolOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " not"); 
	}
	
}
