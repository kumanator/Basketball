import javax.swing.*;
import java.awt.*;



	public class ball extends JFrame {
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
				s.setFullScreen(dm, this)
			}
		}
		
		
}


