import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class fullScreen extends JFrame{
	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		fullScreen fs = new fullScreen();
		fs.run(dm);
	}
	
	private Screen screen;
	private Image ball;
	private Animation ani;
	
	/*Loads pictures from computer to Java*/
	public void loadPics(){
		ball = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball.png").getImage();
		Image basket = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball_Ring.png").getImage();
		ani = new Animation();
		ani.addScene(ball, 250);
		ani.addScene(basket, 250)
	}
	
	/*Run program*/
	public void run(DisplayMode dm){
		screen = new Screen();
		try{
			screen.setFullScreen(dm, new JFrame());
			loadPics();
			movieLoop();
		
		}finally{
			screen.restoreScreen();
		}
	}
	
	/*main movie loop*/
	public void movieLoop(){
		long startingTime = System.currentTimeMillis();
		/* hehe its a long cum time lads*/
		long cumTime = startingTime;
		
		while(cumTime - startingTime <5000){
			long timePassed = System.currentTimeMillis() -cumTime;
			cumTime += timePassed;
			ani.update(timePassed);
			
			Graphics g = screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();
			
			try{
				Thread.sleep(20);
			}catch(exception ex){}
			
		}
	}
	
	
	
	
	private Screen s;
	private Image ball;
	private Image basket;
	private boolean loaded;
	
	/*run method*/
	public void run(DisplayMode dm){
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setFont(new Font("Ariel", Font.PLAIN, 24));
		loaded = false
		
		score s = new score();
		try{
			s.setFullScreen(dm, this);
			loadpics();
			try{
				Thread.sleep(5000);
			}catch(Exception ex){}	
		}finally{
			s.restoreScreen();
		}
	}
	
	/*loads pictures*/
	public void loadpics(){
		ball = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball.png").getImage();
		basket = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball_Ring.png").getImage();
		loaded = true;
		repaint();
	}
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	
		}
		if(loaded){
			g.drawImage(ball,0,0,null);
			g.drawImage(basket,170,180, null);
		}
	}
}
