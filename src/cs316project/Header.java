package cs316project;

public class Header extends HeaderAbs {

	FunName funname;
	ParameterList parameterlist;
	
	Header(FunName f, ParameterList p){
		funname = f;
		parameterlist = p;
		
	}

	public Header(FunName funName2) {
		// TODO Auto-generated constructor stub
		funname = funName2;
	}

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub
		IO.displayln(indent + indent.length() + " <Header>"); 
		
		String s = indent+" ";
		funname.printParseTree(s);
		parameterlist.printParseTree(s);
		IO.displayln(s + s.length() + " <Parameterlist>"); 
		
	}
	
	
}
