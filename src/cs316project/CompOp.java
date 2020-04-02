package cs316project;
import java.util.*;

public abstract class CompOp extends FunOp {
abstract void printParseTree(String indent);
}

class CompOpLt extends CompOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " <"); 
	}
	
}

class CompOpLe extends CompOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " <="); 
	}
	
}

class CompOpGt extends CompOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " >"); 
	}
	
}
class CompOpGe extends CompOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " >="); 
	}
	
}
class CompOpEq extends CompOp
{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " ="); 
	}
	
}