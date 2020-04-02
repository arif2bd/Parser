package cs316project;

public class FunDefRec extends FunDeflist {

	FunDef fundef;
	FunDefRec fundefrec;
	
	 void printParseTree(String indent) {
		 fundef.printParseTree(indent);
		 fundefrec.printParseTree(indent);
	 }
	 
	 FunDefRec(FunDef f, FunDefRec r){
		 fundef =f;
		 fundefrec = r;
	 }
}
