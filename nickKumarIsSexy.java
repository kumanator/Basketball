//Imports packages from the java development kit
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//New public class named ball
public class nickKumarIsSexy {
	
	//Main arguments which are run when the program is started
    public static void main(String[] args) {
        new ball();
    }
		
    //new Image called ball
	public Image ball;
    //Image method
	
	public void images(){
		//creates ball as an image and grabs the image from the file path
		ball = new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png").getImage();
		}

    //public method named ball
    public ball() {
    	//creates an event queue which schedules the task and returns as a runnable method
        EventQueue.invokeLater(new Runnable() {
        	//override tells Java to override the superclass method and run this method inside the superclass method.
            @Override
            //run method
            public void run() {
            	//tries to set the look and feel of the UI if one is set. Because there isnt one set, it catches the exceptions and prints the error on the error output stream.
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                //Creates new JFrame called frame and sets the title to "BASKETBALL | Nick Kumar is HOT!!"
                JFrame frame = new JFrame("BASKETBALL | Nick Kumar is HOT!!");
                //Sets the default close operation to EXIT_ON_CLOSE so when the user clicks the red 'x'in the top right, the frame will close.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //adds Panel2 method to the frame.
                frame.add(new Panel2());
                //packs all the data in the frame so that everything fits on the frame when the frame loads.
                frame.pack();
                //sets the minimum size of the frame to 1280, 720
                frame.setMinimumSize(new Dimension(1280, 720));
                //this sets the position of the frame to null which puts it in the middle of the screen
                frame.setLocationRelativeTo(null);
                //makes the frame visible
                frame.setVisible(true);
                //sets the Icon of the JFrame to ball
                frame.setIconImage(ball);
               
            }
        });
    }
    //Creates a new class called Panel which uses files from the JPanel component
    public class Panel extends JPanel {
    	//creates a method called Panel
        public Panel() {
        	//makes a new JPanel called panel
            JPanel panel = new JPanel();
            //sets the location of the panel to 0,0 which is the top corner
            panel.setLocation(0, 0);
            //sets the panel so that it is see through
            panel.setOpaque(false);
            //adds the basketball picture to the panel as a JLabel
            panel.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basketball.png")));
            //this method adds the panel when this class is called
            add(panel);
            
            //creates a new mouse adapter called ma
            MouseAdapter ma = new MouseAdapter() {
            	//setting public variables as a Point and as a JPanel
                public Point offset;
                public Point clickPoint;
                public JPanel clickedPanel;

                //Overrides previous method 
                @Override
                //new Mouse Event subclass called mousePressed with the variable e
                public void mousePressed(MouseEvent e) {
                    //Gets the current clickPoint, this is used to determine if the mouseRelease event was part of a drag operation or not
                    clickPoint = e.getPoint();
                    //Determines if there is currently a selected panel or not
                    if (clickedPanel != null) {
                        //Moves the selected panel to a new location
                        moveSelectedPanelTo(e.getPoint());
                        //Resets all the other stuff
                        offset = null;
                        clickedPanel = null;
                    }else{
                        //Finds component which was clicked
                        findClickedComponent(e.getPoint());
                    }
                }
                
                //Overrides previous method
                @Override
                //new Mouse Event subclass called mouseReleased with variable e
                public void mouseReleased(MouseEvent e) {
                    //Check to see if the current point is equal to the clickedPoint or not. If it is, then this is part of a "clicked" operation.
                    //This means that the selected panel should remain "selected", otherwise  it's part of drag operation and should be discarded
                    if (!e.getPoint().equals(clickPoint)) {
                        clickedPanel = null;
                    }
                    clickPoint = null;
                }
                //Overrides previous method
                @Override
                //new MouseEvent method called mouseDragged with variable e 
                public void mouseDragged(MouseEvent e) {
                    //Drags the selected component to the new location
                    if (clickedPanel != null) {
                        moveSelectedPanelTo(e.getPoint());
                    }
                }
                //protected method to this subclass called findClickedComponent as a Point with variable p
                protected void findClickedComponent(Point p) {
                	//new component called comp which gets the component at Point
                    Component comp = getComponentAt(p);
                    //the Point is matched up with the JPanel which was selected
                    if (comp instanceof JPanel && !comp.equals(Panel.this)) {
                        clickedPanel = (JPanel) comp;
                        int x = p.x - clickedPanel.getLocation().x;
                        int y = p.y - clickedPanel.getLocation().y;
                        //creates offset at the new point
                        offset = new Point(x, y);
                    }

                }
                //new private method called moveSelectedPanelTo with the parameter Point with variable p
                private void moveSelectedPanelTo(Point p) {
                	//if JPanel was clicked, move to the offset point created earlier
                    if (clickedPanel != null) {
                        int x = p.x - offset.x;
                        int y = p.y - offset.y;
                        //prints coordinates to console
                        System.out.println(x + "x" + y);
                        //sets location of the clicked panel 
                        clickedPanel.setLocation(x, y);
                    }
                }

            };
            
            //adds MouseListener component
            addMouseListener(ma);
            //adds MouseMotionListener component
            addMouseMotionListener(ma);
        }

        //Overrides previous method
        @Override
        //new Dimension method called getPreferredSize
        public Dimension getPreferredSize(){
        	//returns new dimension of frame
            return new Dimension(200, 200);
        }

    }

    //NEW CLASS called Panel2 which extends the JPanel component
	public class Panel2 extends JPanel {
		//new subclass called Panel2
        public Panel2() {
        	//creates new object called ballPanel which inherits everything from the Panel class above
    		Panel ballPanel = new Panel();
    		//creates new object called scorePanel which inherits everything from Panel3 below
    		Panel3 scorePanel = new Panel3();
    		//creates a new JPanel called basketPanel 
    		JPanel basketPanel = new JPanel();
    		//creates a new JPanel called combine
    		JPanel combine = new JPanel();
        
    		//sets the size of the basketPanel to 1980, 1080
    		basketPanel.setSize(1980, 1080);
    		//sets the location of the basketPanel to 0,0 which is top left
    		basketPanel.setLocation(0, 0);
    		//adds a picture of a basket to the basketPanel as a JLabel 
    		basketPanel.add(new JLabel(new ImageIcon("C:\\Users\\kuman\\workspace\\Messenger Basketball\\src\\Basket.png")));
    		//adds ballPanel, basketPanel and scorePanel to the combine Panel
    		combine.add(ballPanel);
    		combine.add(basketPanel);
    		combine.add(scorePanel);
    		//sets the layout of everything in the combine Panel to FlowLayout which is right to left
    		combine.setLayout(new FlowLayout());
    		//adds this panel when this class is called
    		add(combine);

        }
        	
        		
    }
        //NEW CLASS called Panel3
        public class Panel3 extends JPanel{
        	//creates a string variable called mess1 for my twitter
        	private String mess1 = "twitter.com/Kumanator13";
        	//creates new integer variable called Score
        	int Score = 10;
        	//creates new subclass called Panel3
			public Panel3(){
				//creates a new JPanel called Panel3 
        		JPanel Panel3 = new JPanel();
        		//creates a new JLabel called score with the string "Score = " attached plus the integer variable Score
        		JLabel score = new JLabel("Score = " +Score);
        		//creates a new JLabel called mess with the String "Follow me on Twitter @\r\n" plus the string variable mess1
        		JLabel mess = new JLabel("Follow me on Twitter @\r\n" + mess1);
        		//sets the font and size of the JLabel mess
        		mess.setFont(new Font("Arial", Font.ITALIC, 16));
        		//sets the font and size of the JLabel score
        		score.setFont(new Font("Arial", Font.BOLD, 48));
        		//adds score JLabel to Panel3 JPanel
        		Panel3.add(score);
        		//adds mess JLabel to Panel3 JPanel
        		Panel3.add(mess);
        		//sets the size of Panel3
        		Panel3.setSize(100, 100);
        		//sets the location of the mess JLabel
        		mess.setLocation(50,50);
        		//adds this Panel when this class is called
        		add(Panel3);
        		
        	}
        }
}
