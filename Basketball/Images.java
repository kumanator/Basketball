import java.awt.*;
import javax.swing.*;


public class Images extends JFrame{
	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(1920,1080,60, DisplayMode.REFRESH_RATE_UNKNOWN);
		Images i = new Images();
		i.run(dm);
		
	}
	
	private Screen s;
	private Image ball;
	private Image basket;
	private boolean loaded;
	
	
	//run method
	public void run(DisplayMode dm){
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;
		
		s = new Screen();
		try{
			s.setFullScreen(dm, this);
			loadpics();
			try{
				Thread.sleep(2000);
			}catch(Exception ex){}	
		}finally{
			s.restoreScreen();
		}
	}
	
	//loads pictures
	public void loadpics(){
		ball = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball.png").getImage();
		basket = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basket.png").getImage();
		loaded = true;
		repaint();
	}
	
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded){
			g.drawImage(ball,750,700,null);
			g.drawImage(basket,550,-100,null);
			}
	}
}