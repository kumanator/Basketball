//Imports packages from the java development kit
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//created the nickKumarIsSexy class
public class nickKumarIsSexy extends JFrame implements Runnable{
	public static void main(String[] args){
		//runs the method after the AWT event dispathcing thread
		SwingUtilities.invokeLater(new nickKumarIsSexy());
	
	}
	
	//creating variables 
	//setting up JFrame
	private JFrame frame;
	//creates a score variable as an integer
	private int Score = 0;
	//creates a string variable for testing
	private String mess =  "hi";
	//creates ball variable as an Image
	private Image ball;
	PointerInfo a = MouseInfo.getPointerInfo();
	
	//Image method
	public void images(){
		//creates ball as an image and grabs the image from the file path
		ball = new ImageIcon("C:\\Users\\nicholas.kumar1\\Documents\\Basketball.png").getImage();
	}

	@Override
	//run method
	public void run() {
		//Creating JFrame with the title "Basketball - Nick Kumar is HOT"
		frame = new JFrame("Basketball - Nick Kumar is HOT");
		//creates a label called Score which prints the score integer
		JLabel score = new JLabel("Score = " +Score);
		//sets the font and font size of the score integer when it prints
		score.setFont(new Font("Arial", Font.ITALIC, 48));
		//sets the default close operation to exit
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//sets the size of the JFrame
		frame.setSize(1980, 1080);
		//sets the JFrame as visible
		frame.setVisible(true);
		//adds the label of score to the JFrame
		frame.add(score);
		//sizes the frame so all the images are at their preferred sizes
		frame.pack();
		//(supposed to)change the icon of the JFrame to the basketball
		frame.setIconImage(ball);
		//sets the minimum size of the JFrame 
		frame.setMinimumSize(new Dimension(1280, 720));
		//sets the position of the JFrame to the middle of the screen
		frame.setLocationRelativeTo(null);
		//creates a new JPanel object called panel1 
		JPanel panel1 = new JPanel();
		//adds the basketball image to the JPanel
		panel1.add(new JLabel(new ImageIcon("C:\\Users\\nicholas.kumar1\\Documents\\Basketball.png")));
		//adds the basket image to the JPanel
		panel1.add(new JLabel(new ImageIcon("C:\\Users\\nicholas.kumar1\\Documents\\Basket.png")));
		//adds the panel1 JPanel to the JFrame
		frame.getContentPane().add(panel1);
		
		MouseAdapter ma = new MouseAdapter(){
			private Point offset;
            private Point clickPoint;
            private JPanel clickedPanel;
		};
	}
            

            public void mousePressed(MouseEvent e){	
            }
	
	public void win(){
		if(Score == 10){
			mess = "YOU WIN!";
		}else{
			mess = "Get 10 baskets to win!";
		}
	}
}
//http://stackoverflow.com/questions/33061624/moving-an-image-with-mouselistener-when-clicked
