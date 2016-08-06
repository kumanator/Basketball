import java.awt.*;
import java.awt.image.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class ScreenManager {
	
	private GraphicsDevice vc;
	
	//give video card access to the monitor
	public ScreenManager(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = e.getDefaultScreenDevice();
		
	}
	//get all compatible display modes
	public DisplayMode[] getCompatibleDisplayModes(){
		return vc.getDisplayModes();
	}
	
	//compares display modes passed in to video card display modes to see if they match
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){
		DisplayMode goodModes[] = vc.getDisplayModes();
		//loops through modes
		for(int x=0;x<modes.length;x++){
			//loops through video card modes
			for(int y=0;y<goodModes.length;y++){
				if(displayModesMatch(modes[x], goodModes[y])){
					return modes[x];
				}
			}
		}
		return null;
	}
	
	//get current display mode
	public DisplayMode getCurrentDisplayMode(){
		return vc.getDisplayMode();
	}
	
	//checks if two modes match each other
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
		if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){
			return false;
		}
		//checks to see if the bit depths are the same
		if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){
			return false;
		}
		//checks to see if refresh rate is the same
		if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()){
			return false;
		}
		
		return true;
	}
	
	//make frame full screen
	public void setFullScreen(DisplayMode dm){
		JFrame f = new JFrame();
		//settings for full screen
		f.setUndecorated(false);
		f.setIgnoreRepaint(true);
		f.setResizable(true);
		vc.setFullScreenWindow(f);
		
		if(dm != null & vc.isDisplayChangeSupported()){
			try{
				vc.setDisplayMode(dm);
			}catch(Exception ex){}
		}
		//creates buffer strategy with 2 buffers
		f.createBufferStrategy(2);
	}
	
	//set Graphics object = to what this method returns
	public Graphics2D getGraphics(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			BufferStrategy s = w.getBufferStrategy();
			return (Graphics2D)s.getDrawGraphics();
			//if graphics return nothing
		}else{
			return null;
		}
	}
	
	//updates display
	public void update(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			BufferStrategy s = w.getBufferStrategy();
			//if no contents, calls show method
			if(!s.contentsLost()){
				s.show();
			}
		}
	}
	
	//return full screen window
	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	//gets width of window
	public int getWidth(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			return w.getWidth();
		}else{
			return 0;
		}
	}
	
	//gets height of window
	public int getHeight(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			return w.getHeight();
		}else{
			return 0;
			}
		}
		
		//get out of fullscreen
		public void restoreScreen(){
			Window w = vc.getFullScreenWindow();
			if(w != null){
				w.dispose();
			}
			vc.setFullScreenWindow(null);
		}
		
		//create image compatible with monitor
		public BufferedImage createCompatibleImage(int w, int h, int t){
			Window win = vc.getFullScreenWindow();
			if(win != null){
				GraphicsConfiguration gc = win.getGraphicsConfiguration();
				return gc.createCompatibleImage(w,h,t);
			}
			return null;
		}
}
