import java.awt.Image;
import java.util.ArrayList;

/*Animation Class*/
public class Animation {
	
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	
	//CONSTRUCTOR//
	public Animation(){
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}
	//add scene to ArrayList and set time for each scene//
	public synchronized void addScene(Image i, long t){
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));
	}

	//starts animation from beginning//
	public synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}
	
	//changes scenes//
	public synchronized void update(long timePassed){
		if(scenes.size()>1){
			movieTime += timePassed;
			if(movieTime >= totalTime){
				movieTime = 0;
				sceneIndex = 0;
			}
			while(movieTime > getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}
	
	//get animations for current scene//
	public synchronized Image getImage(){
		//if no scenes//
		if(scenes.size() ==0){
			//do nothing
			return null;
		}else{
			return getScene(sceneIndex).ball;
		}
	}
	
	//get scene//
	private OneScene getScene(int x){
		//returns scene
		return (OneScene)scenes.get(x);
	}
	
	//Makes each scene an object//
	private class OneScene{
		Image ball;
		long endTime;
		
		public OneScene(Image ball, long endTime){
			this.ball = ball;
			this.endTime = endTime;
		}
	}
}
