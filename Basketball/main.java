import java.util.*;

	public class main implements Runnable{
		
		String name;
		int time;
		Random r = new Random();
		
		public main(String s){
			name = s;
			time = r.nextInt(999);
		}
		
	
		public void run(){
			try{
				System.out.printf("%s is loading for %d\n", name, time);
				Thread.sleep(time);
				System.out.printf("%s is done\n", name);
				}catch(Exception e){}
		}
}