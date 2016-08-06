import java.awt.*;
import javax.swing.*;


public class fullScreen2 extends JFrame{
	
	public static void main(String[] args) {
		fullScreen2 fs = new fullScreen2();
		fs.run();
	}
	
	private Sprite sprite;
	private Animation ani;
	private ScreenManager s;
	private Image bg;
	
	//creating all display modes
	private static final DisplayMode modes1[] = {
			new DisplayMode(800,600,32,0),
			new DisplayMode(800,600,24,0),
			new DisplayMode(800,600,16,0),
			new DisplayMode(640,480,32,0),
			new DisplayMode(640,480,24,0),
			new DisplayMode(640,480,16,0),
			new DisplayMode(1024,768,32,0),
			new DisplayMode(1024,768,16,0),
			new DisplayMode(1024,768,24,0),
			new DisplayMode(1280,1024,32,0),
			new DisplayMode(1280,1024,16,0),
			new DisplayMode(1280,1024,24,0),
			new DisplayMode(1600,1200,32,0),
			new DisplayMode(1600,1200,16,0),
			new DisplayMode(1600,1200,24,0),
			new DisplayMode(1920,1080,60,0),
			new DisplayMode(1920,1080,64,0),
	};
	
	//load images and add scenes
	public void loadPics(){
		Image ball = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basketball.png").getImage();
		Image basket = new ImageIcon("C:\\Users\\kuman\\OneDrive\\Documents\\GitHub\\Basketball\\Basketball\\src\\Basket.png").getImage();
		
		ani = new Animation();
		ani.addScene(ball, 250);
		ani.addScene(basket, 250);
		
		sprite = new Sprite(ani);
		sprite.setVelocityX(0.3f);
		sprite.setVelocityY(0.0f);
	}
	
	//main method called from main
	public void run(){
		s = new ScreenManager();
		try{
			DisplayMode dm = s.findFirstCompatibleMode(modes1);
			s.setFullScreen(dm);
			loadPics();
			movieLoop();
		}finally{
			s.restoreScreen();
		}
	}
	
	//plays movie
	private void movieLoop(){
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		while(cumTime - startingTime <5000);
		long timePassed = System.currentTimeMillis() - cumTime;
		cumTime += timePassed;
		update(timePassed);
		
		//draw and update the screen
		Graphics2D g = s.getGraphics();
		draw(g);
		g.dispose();
		s.update();
		
		try{
			Thread.sleep(20);
		}catch(Exception ex){}
	}
	
	//draws images
	public void draw(Graphics g){
		g.drawImage(bg, 0,0,null);
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
	}
	
	//update method
	public void update(long timePassed){
		//setting screen boundaries
		if(sprite.getX() < 0){
			sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
		}else if(sprite.getX() + sprite.getWidth() >s.getWidth()){
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
		}
		if(sprite.getY() < 0){
			sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
		}else if(sprite.getY() + sprite.getHeight() >s.getHeight()){
			sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
	}
		
		sprite.update(timePassed);
	}
}