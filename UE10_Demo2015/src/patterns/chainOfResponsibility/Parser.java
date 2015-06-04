package patterns.chainOfResponsibility;

public abstract class Parser {

	private Parser successor;

	Parser getSuccessor() {
		return successor;
	}

	void setSuccessor(Parser successor) {
		this.successor = successor;
	}
	
	boolean canHandleFile(String fileName, String format){
		return (fileName == null) || (fileName.endsWith(format));
	}

	void delegateCall(String fileName){
		if ( getSuccessor() != null ){
			getSuccessor().parse(fileName);
		}
		else{
			System.out.println("Unable to find parser for file: " + fileName);
		}
	}
	
	public abstract void parse(String fileName);

}
