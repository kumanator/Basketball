
public class thread {
	public static void main (String args[]) {
	
		Thread t1 = new Thread(new main("one"));
		Thread t2 = new Thread(new main("two"));
		Thread t3 = new Thread(new main("three"));
		t1.start();
		t2.start();
		t3.start();
	
	}
}