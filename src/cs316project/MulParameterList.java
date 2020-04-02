package cs316project;

public class MulParameterList extends ParameterList {
	String ID;
	ParameterList parameterlist;
	
	public MulParameterList(String iD, ParameterList parameterlist) {
		super();
		ID = iD;
		this.parameterlist = parameterlist;
	}

	@Override
	void printParseTree(String indent) {
		// TODO Auto-generated method stub

		IO.displayln(indent + indent.length() + " <ParameterLIst>"); 
		String t= indent + " ";
		IO.displayln(t + t.length() + " <ParameterLIst>");
		// recursive pr
		
		if(parameterlist instanceof MulParameterList)
		{
			multipleParams(parameterlist, indent);
		}
		
	}
	
	void multipleParams(ParameterList p, String indent)
	{
		IO.displayln(indent + indent.length() + " " + ID);
		if(p != null)
		{
			MulParameterList m = (MulParameterList)p;
			multipleParams(m.parameterlist, indent);
		}
	}

}
