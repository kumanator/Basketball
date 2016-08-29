//Imports packages from the java development kit
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ball {

    public static void main(String[] args) {
        new ball();
    }

    public ball() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = new JFrame("BASKETBALL | Nick Kumar is HOT!!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
                Container contentPane = frame.getContentPane();
                contentPane.setLayout(new FlowLayout());
                frame.add(new Panel2());
                frame.pack();
                frame.setMinimumSize(new Dimension(1280, 720));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
               
            }
        });
    }
    public class Panel extends JPanel {

        public Panel() {
            JPanel panel = new JPanel();
            panel.setLocation(0, 0);
            panel.setOpaque(false);
            panel.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png")));
            add(panel);

            MouseAdapter ma = new MouseAdapter() {
                public Point offset;
                public Point clickPoint;
                public JPanel clickedPanel;

                @Override
                public void mousePressed(MouseEvent e) {
                    // Get the current clickPoint, this is used to determine if the
                    // mouseRelease event was part of a drag operation or not
                    clickPoint = e.getPoint();
                    // Determine if there is currently a selected panel or nor
                    if (clickedPanel != null) {
                        // Move the selected panel to a new location
                        moveSelectedPanelTo(e.getPoint());
                        // Reset all the other stuff we might other was have set earlier
                        offset = null;
                        clickedPanel = null;
                    }else{
                        // Other wise, find which component was clicked
                        findClickedComponent(e.getPoint());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Check to see if the current point is equal to the clickedPoint
                    // or not.  If it is, then this is part of a "clicked" operation
                    // meaning that the selected panel should remain "selected", otherwise
                    // it's part of drag operation and should be discarded
                    if (!e.getPoint().equals(clickPoint)) {
                        clickedPanel = null;
                    }
                    clickPoint = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    // Drag the selected component to a new location...
                    if (clickedPanel != null) {
                        moveSelectedPanelTo(e.getPoint());
                    }
                }

                protected void findClickedComponent(Point p) {
                    Component comp = getComponentAt(p);
                    if (comp instanceof JPanel && !comp.equals(Panel.this)) {
                        clickedPanel = (JPanel) comp;
                        int x = p.x - clickedPanel.getLocation().x;
                        int y = p.y - clickedPanel.getLocation().y;
                        offset = new Point(x, y);
                    }

                }

                private void moveSelectedPanelTo(Point p) {
                    if (clickedPanel != null) {
                        int x = p.x - offset.x;
                        int y = p.y - offset.y;
                        System.out.println(x + "x" + y);
                        clickedPanel.setLocation(x, y);
                    }
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(200, 200);
        }

    }

	public class Panel2 extends JPanel {
        public Panel2() {
        	
    		Panel ballPanel = new Panel();
    		Panel3 scorePanel = new Panel3();
    		JPanel basketPanel = new JPanel(); 
    		JPanel combine = new JPanel();
        
    		basketPanel.setSize(1980, 1080);
    		basketPanel.setLocation(0, 0);
    		basketPanel.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basket.png")));
    		combine.add(ballPanel);
    		combine.add(basketPanel);
    		combine.add(scorePanel);
    		combine.setLayout(new FlowLayout());
    		add(combine);

        }
        	
        		
    }
        
        public class Panel3 extends JPanel{
        	//creates a string variable for testing
        	private String mess1 = "twitter.com/Kumanator13";
        	int Score = 10;
			public Panel3(){
        		JPanel Panel3 = new JPanel();
        		JLabel score = new JLabel("Score = " +Score);
        		JLabel mess = new JLabel("Follow me on Twitter @\r\n" + mess1);
        		mess.setFont(new Font("Arial", Font.ITALIC, 16));
        		score.setFont(new Font("Arial", Font.BOLD, 48));
        		Panel3.add(score);
        		Panel3.add(mess);
        		Panel3.setSize(100, 100);
        		mess.setLocation(50,50);
        		
        		add(Panel3);
        		
        	}
        }


			
	//Image method
	public void images(){
		//creates ball as an image and grabs the image from the file path
		ball = new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png").getImage();
		}
	
	private Image ball;
}
//http://stackoverflow.com/questions/33061624/moving-an-image-with-mouselistener-when-clicked