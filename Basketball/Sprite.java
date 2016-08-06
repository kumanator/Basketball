import java.awt.Image;

public class Sprite {
	
	private Animation ani;
	//x position
	private float x;
	//y position
	private float y;
	//velocity of x
	private float vx;
	//velocity of y
	private float vy;
	
	//CONSTRUCTOR
	public Sprite(Animation ani){
		//the animation is equal to whatever object we pass in
		this.ani = ani;
	}
	
	//change position
	public void update(long timePassed){
		
		x += vx * timePassed;
		y += vy * timePassed;
		ani.update(timePassed);
		
	}
	
	//get the x position 
	public float getX(){
		return x;
	}
	
	//get the y position
	public float getY(){
			return y;
	}
	
	//set sprite x position
	public void setX(float x){
			this.x =x;
	}
				
	//set position of y sprite
	public void setY(float y){
		this.y =y;
	}
	
	//get sprite width
	public int getWidth(){
		return ani.getImage().getHeight(null);
	}
		
	//get sprite width
	public int getHeight(){
		return ani.getImage().getHeight(null);
		
	}
	
	//get horizontal velocity
	public float getVelocityX(){
		return vx;
	}
	
	//get vertical velocity
	public float getVelocityY(){
		return vy;
	}
	
	//set horizontal velocity
	public void setVelocityX(float vx){
		this.vx = vx;
	}
	
	//set vertical velocity
	public void setVelocityY(float vy){
		this.vy = vy;
	}
	
	//get sprites/images
	public Image getImage(){
		return ani.getImage();
	}
}
