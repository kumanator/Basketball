import javax.swing.*;
import java.awt.*;
import java.util.*;

	public class flick implements Runnable{
		
		String name;
		int time;
		Random r = new Random();
		
		public flick(String s){
			name = s;
			time = r.nextInt(999);
		}
		
	}

	public class flick extends JFrame {
		public static void main (String[] args){
		
			private Screen s;
			private Image pic;
			private boolean loaded;
		
	}
		public void run(DisplayMode dm){
			setBackground(Color.WHITE);
			setFont(new Font("Ariel", Font.PLAIN, 24));
			loaded = false;
			
			s = new Screen();
			try{
				Syste,.out.printf("%s is loading for %d\n", name, time);
				Thread.sleep(time);
				System.out.printf("%is done\n", name);
		
				s.setFullScreen(dm, this)
			}catch(Exception e){}
		}
		
		
}
