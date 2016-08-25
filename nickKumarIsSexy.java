import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ball extends JFrame implements Runnable{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new ball());
	
	}
	
	private JFrame frame;
	private int Score = 0;
	private String mess =  "hi";
	private double mousePosition;
	private Image ball;
	PointerInfo a = MouseInfo.getPointerInfo();
	
	public void images(){
		ball = new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png").getImage();
	}

	@Override
	public void run() {
		frame = new JFrame("Basketball - Nick Kumar is HOT");
		JLabel score = new JLabel("Score = " +Score);
		score.setFont(new Font("Arial", Font.ITALIC, 48));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		frame.getMousePosition();
		frame.add(score);
		frame.pack();
		frame.setMinimumSize(new Dimension(1280, 720));
		frame.setLocationRelativeTo(null);
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png")));
		panel1.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basket.png")));
		frame.getContentPane().add(panel1);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public void win(){
		if(Score == 10){
			mess = "YOU WIN!";
		}else{
			mess = "Get 10 baskets to win!";
		}
		
	}
	
}
