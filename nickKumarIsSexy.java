import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class nickKumarIsSexy extends JFrame implements MouseListener, MouseMotionListener, KeyListener{
	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(1920,1080,60, DisplayMode.REFRESH_RATE_UNKNOWN);
		nickKumarIsSexy i = new nickKumarIsSexy();
		i.run(dm);
		
	}
	
	private int score = 0;
	private String mess = "";
	private Image ball;
	private Image basket;
	private boolean loaded;
	private static int x = 0;
	private static int y = 0;
	private static int z = 0;
	private int mouseX = 0, mouseY = 0;
	private boolean running;
	protected Screen s;
	private boolean mouseClicked;
	
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
				Thread.sleep(5000);
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
@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
	    mouseY = e.getY();
	    repaint();
		
	}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void drawScore(Graphics2D s){
		if(mouseClicked == true)
		s.drawString(mess, 40, 50);
		mess = "Score: +score"; score++;
		
	}

	public void stop(){
		running = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode ==KeyEvent.VK_ESCAPE){
			stop();
		}else{
			mess = "poooooo :"+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}