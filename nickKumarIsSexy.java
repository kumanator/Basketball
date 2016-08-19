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
