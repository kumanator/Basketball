<<<<<<< HEAD:Basketball/nickKumarIsSexy.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class nickKumarIsSexy extends Core implements MouseMotionListener,MouseListener,KeyListener {
	public static void main(String[] args){
		DisplayMode dm = new DisplayMode(1920,1080,60, DisplayMode.REFRESH_RATE_UNKNOWN);
		Images i = new Images();
		i.run(dm);
	}
	private String mess = "";
	private Image ball;
	private Image basket;
	private boolean loaded;
	private Screen s;
	
	public void init(){
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		mess ="press escape to exit";
		w.addMouseListener(this);
		w.addKeyListener(this);
		w.addMouseMotionListener(this);
	}
	
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
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode ==KeyEvent.VK_ESCAPE){
			stop();
		}else{
			mess = "poooooo :"+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}
	public synchronized void draw(Graphics2D g){
		Window w = s.getFullScreenWindow();
		g.drawString(mess, 40, 50);
	}
	
	public void mousePressed(MouseEvent e){
		mess = "you pressed the mouse";
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public void loadpics(){
			ball = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball.png").getImage();
			basket = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basket.png").getImage();
			loaded = true;
			repaint();
		}
	
	public void mouseMoved(MouseEvent e){
		
}
	
	public void mouseDragged(MouseEvent e){
		mess ="you are dragging the mouse";
	}
}
=======
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class nickKumarIsSexy extends Core implements MouseMotionListener, MouseListener, KeyListener {
	public static void main(String[] args){
		new nickKumarIsSexy().run();
	}
	private String mess = "";
	
	public void init(){
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		mess ="press escape to exit";
		w.addMouseListener(this);
		w.addKeyListener(this);
		w.addMouseMotionListener(this);
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode ==KeyEvent.VK_ESCAPE){
			stop();
		}else{
			mess = "You pressed the :"+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}
	public synchronized void draw(Graphics2D g){
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0,0,s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 10, 50);
	}
	
	public void mousePressed(MouseEvent e){
		mess = "you pressed the mouse";
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public void mouseMoved(MouseEvent e){
		mess="you are moving the mouse";
	}
	
	public void mouseDragged(MouseEvent e){
		mess ="you are dragging the mouse";
	}

	@Override
	public void keyReleased(KeyEvent k) {
		mess ="Key released";
		
	}

	@Override
	public void keyTyped(KeyEvent k) {

		
	}

	@Override
	public void mouseReleased(MouseEvent k) {
		mess ="Mouse Released";

		
	}
}
>>>>>>> origin/master:nickKumarIsSexy.java
