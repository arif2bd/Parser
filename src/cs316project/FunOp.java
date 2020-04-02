package cs316project;
import java.util.*;

public abstract class FunOp {

	abstract void printParseTree(String indent);
		
	
}

class FunOpid extends FunOp{

	String id;
	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " " + id);
	
	}

	public FunOpid(String id) {
		super();
		this.id = id;
	}
	
}

class FunOppair extends FunOp{

	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <pair>");
	
		
	}

	
}

class FunOpfirst extends FunOp{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <first>");
		
		
	}


	
}

class FunOpsecond extends FunOp{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <second>");
		
	}

	
	
}
