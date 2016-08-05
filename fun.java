
public class fun {
	public static void main (String args[]) {
	
		Thread t1 = new Thread(new flick("one"));
		Thread t2 = new Thread(new flick("two"));
		Thread t3 = new Thread(new flick("three"));
		t1.start();
		t2.start();
		t3.start();
	
	}
}
		