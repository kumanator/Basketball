import java.awt.*;
import javax.swing.JFrame;

public class score {
	
	private GraphicsDevice vc;
	
	public score(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame screen){
		screen.setUndecorated(true);
		screen.setResizable(false);
		vc.setFullScreenWindow(screen);
		
		if(dm != null && vc.isDisplayChangeSupported()){
			try{
				vc.setDisplayMode(dm);	
			}catch(Exception ex){}
		}
	}	

	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		vc.setFullScreenWindow(null);
	}
	
}