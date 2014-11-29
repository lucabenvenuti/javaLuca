
public class HelloWorldObj {
	private String msg = "Hello World!";
	public void setMsg(String newText) {
		if(newText != null)
			msg = newText;
		else
			msg = "";
		}
	public String getMsg() {
		return msg;
	}
	public void printText() {
		System.out.println (msg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			HelloWorldObj english = new HelloWorldObj();
			HelloWorldObj german = new HelloWorldObj();
			german.setMsg("Hallo liebe Leute!");
			HelloWorldObj cat = new HelloWorldObj();
			cat.setMsg("Miau!");
			english.printText();
			german.printText();
			english.printText();
			cat.printText();
			english = cat;
			english.printText();
			try {english.printText();
			
				Thread.sleep(250);
				german.printText();
				} catch (InterruptedException e) {
				e.printStackTrace();
				}


	}

}
