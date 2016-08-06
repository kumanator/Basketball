import java.awt.*;
import java.awt.event.*;
	
public class KeyTest extends Core implements KeyListener,MouseMotionListener,MouseListener{
	public static void main(String[] args){
		new KeyTest().run();
		
	}

	private String mess = "";
	
	//init calls super init
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
	
	//key pressed
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode ==KeyEvent.VK_ESCAPE){
			stop();
		}else{
			mess = "poooooo :"+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}
		
		//key released
		public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
		mess = "released";
		e.consume();
		}
		
		//last method from interface
		public void keyTyped(KeyEvent e){
			e.consume();
		}

	
	//another draw method
	public synchronized void draw(Graphics2D g){
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0,0,s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 40, 50);
	}
	
	//mouse listener interface
	public void mousePressed(MouseEvent e){
		mess = "you smell like bollocks";
	}
	public void mouseReleased(MouseEvent e){
		mess = "you are bollocks";
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	//mouse motion interface
	public void mouseDragged(MouseEvent e){
		mess ="you are dragging the mouse";
		
	}
	public void mouseMoved(MouseEvent e){
		mess="you are moving the mouse";
	}
	
	
}
	
