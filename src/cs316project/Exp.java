package cs316project;
import java.util.*;

abstract class Exp {
	abstract void printParseTree(String indent);
	
	
}

class ExpId extends Exp{

	String id;
	
	// cons
	
	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <Exp>");
		
		String s = indent + " ";
		
		IO.displayln(s + s.length() + id); 
		
	}

	public ExpId(String id) {
		super();
		this.id = id;
	}
	
}

class ExpInt extends Exp{

int id;
	
	// cons
	
	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <Exp>");
		
		String s = indent + " ";
		
		IO.displayln(s + s.length() + id); 
		
	}

	public ExpInt(int id) {
		super();
		this.id = id;
	}
	
}

class Expfloat extends Exp{

float id;
	
	// cons
	
	
	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <Exp>");
		
		String s = indent + " ";
		
		IO.displayln(s + s.length() + id); 
		
	}

	public Expfloat(float id) {
		super();
		this.id = id;
	}
	
}

class Expnil extends Exp{

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
       IO.displayln(indent + indent.length() + " <Exp>");
		
		String s = indent + " ";
		
		IO.displayln(s + s.length() + "<nil>"); 
	}
	
}

class Expif extends Exp{
	Exp e1;
	Exp e2;
	Exp e3;
	
	

	public Expif(Exp e1, Exp e2, Exp e3) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}



	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		
		 IO.displayln(indent + indent.length() + " <Exp>");
		 
		 String s = indent+" ";
		 IO.displayln(s + s.length() + " <if>");
		 e1.printParseTree(s+" ");
		 IO.displayln(s + s.length() + " <then>");
		 e2.printParseTree(s+" ");
		 IO.displayln(s + s.length() + " <else>");
		 e3.printParseTree(s+" ");
	}
	
}
class Expfunexp extends Exp{
	FunOp funop;
	ExpList explist;
	
	
	public Expfunexp(FunOp funop, ExpList explist) {
		super();
		this.funop = funop;
		this.explist = explist;
	}


	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

IO.displayln(indent + indent.length() + " <Exp>"); 
String s = indent+ " ";
IO.displayln(s + s.length() + " <FunExp>" ); 
funop.printParseTree(s + " ");
explist.printParseTree(s + " ");

	}
	
}
/**
abstract class E
{
	Term term;

	abstract void printParseTree(String indent);
	abstract Val Eval(HashMap<String,Val> state);
	abstract void emitInstructions();
}

**/