package cs316project;
import java.util.*;

public class FunName {
	String ID ;

	public FunName(String iD) {
		super();
		ID = iD;
	}
	 void printParseTree(String indent) {

		 IO.displayln(indent + indent.length() + " <FunName> " + ID); 

	 }
}
