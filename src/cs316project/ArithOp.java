package cs316project;
import java.util.*;

public abstract class ArithOp extends FunOp {
abstract void printParseTree(String indent);
}

class ArithPlus extends ArithOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " + "); 
	}
	
}

class ArithMinus extends ArithOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " - "); 
	}
	
}

class ArithMul extends ArithOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " * "); 
	}
	
}

class ArithDiv extends ArithOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " / "); 
	}
	
}