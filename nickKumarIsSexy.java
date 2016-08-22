import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*public class nickKumarIsSexy extends Core implements MouseMotionListener, MouseListener, KeyListener {
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

	public void keyReleased(KeyEvent k) {
		mess ="Key released";
		
	}

	public void keyTyped(KeyEvent k) {
		
	}

	public void mouseReleased(MouseEvent k) {
		mess ="Mouse Released";
		
	}
}*/

public class nickKumarIsSexy extends Core implements MouseMotionListener, MouseListener, KeyListener {
	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		nickKumarIsSexy i = new nickKumarIsSexy();
		i.run(dm);
	}
	private String mess = "";
	private Screen s;
	private Image ball;
	private Image basket;
	private boolean loaded;
	
	
	//run method
	public void run(DisplayMode dm){
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setFocusTraversalKeysEnabled(false);
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
		
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;
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
		ball = new ImageIcon("Libraries\\Documents\\Basket.png").getImage();
		basket = new ImageIcon("Libraries\\Documents\\Basketball.png").getImage();
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
	public void draw(Graphics2D g) {
		g.drawString(mess, 10, 50);
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

	public void keyReleased(KeyEvent k) {
		mess ="Key released";
		
	}

	public void keyTyped(KeyEvent k) {}

	public void mouseReleased(MouseEvent k) {
		mess ="Mouse Released";
		
	}
}
