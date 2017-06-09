package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Hotello extends JLayeredPane implements Runnable{
	
		
	private static int clickedF;
	private static int buttonint = 2;
	private static String buttonidx = "1";
	private static String curl = "resources/monk.png";
	private static int ySpring = 170;
	private static int heightmulti = 1;
	private static int bwidth = 182;
	private static boolean running = false;
	private static SpringLayout spring = new SpringLayout();
	//to upgrade buttons
	private static ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	private static ArrayList<Integer> levels = new ArrayList<Integer>();
	private static ArrayList<JButton> barr = new ArrayList<JButton>();
	private static ArrayList<JButton> unoccupied = new ArrayList<JButton>();
	
	final static JPopupMenu jp = new JPopupMenu();
	
	//adding floors
	private static int pathsi = 0;
	private static String[] paths = {"blue.png","Bubblesoak_Suite.png","Haunted.png",
			"groovy.png","lounge.jpg","piano.png","red.png","Room.png",
			"marble.png","rustic.png","zen.png","castle.png","dragon.png"
			,"Honeymoon.png","Island.png","Mystik_Lounge.png","pent.png"
			,"pop.png","Roman.png",
			};
	private static String[] cust = {};

	
	
	
	//write method that will getText of button to see index (upgrade method)
	
	
	//addfloor : new Jbutton(buttonidx,imagesrc)
	//buttonidx = Integer.toString(buttonint);
	//Add button to barr
	
	public static void main(String[] args) {  
		JFrame f=new JFrame("Hotello");//creating instance of JFrame 
		f.setSize(1200,800);//400 width and 500 height  
		
		
		JLayeredPane game = new JLayeredPane();
		game.setOpaque(true);
		


		game.setLayout(spring);
		
		JScrollPane jsp = new JScrollPane(game);
		jsp.getVerticalScrollBar().setUnitIncrement(20);
		game.setPreferredSize(new Dimension(800,900));
		
		jsp.setBackground(Color.PINK);

		ImageIcon a = new ImageIcon(curl);
		JButton c = new JButton(a);
		c.setOpaque(false);
		c.setContentAreaFilled(false);
		c.setBorderPainted(false);
		
		
		ImageIcon i = new ImageIcon("resources/Lobby.png");
		Image img = i.getImage();
		Image scaled = img.getScaledInstance(520, 160,  java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scaled);
		
		JButton b=new JButton(i);//creating instance of JButton  
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.addActionListener(new ActionListener(){  

			public void actionPerformed(ActionEvent e){  
			     game.add(makeFloor(game));
			     setSpringD(spring,game,barr,c);
//			     spring.putConstraint(SpringLayout.SOUTH,game,ySpring,SpringLayout.SOUTH,);
			     game.setPreferredSize(new Dimension(800,heightmulti * bwidth));
			     heightmulti++;
			     bwidth--;
			     updateFloor(spring,game,barr,c);
			     jsp.getVerticalScrollBar().setValue(0);
			     f.setVisible(true);
			          }  
			      }); 
	
		
		
		JMenuItem up = new JMenuItem("Upgrade");
		up.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			   upgradeFloor(clickedF);
			   
			          }  
			      }); 
		jp.add(up);
		
	  
	    
		
		game.add(b);
		game.add(c,0,0);
		spring.putConstraint(SpringLayout.WEST, b, 30, SpringLayout.WEST, game);
		spring.putConstraint(SpringLayout.EAST, b, -30, SpringLayout.EAST, game);
		spring.putConstraint(SpringLayout.SOUTH, b, 0, SpringLayout.SOUTH, game);
		spring.putConstraint(SpringLayout.WEST, c, 300, SpringLayout.WEST, game);
		spring.putConstraint(SpringLayout.EAST, c, -300, SpringLayout.EAST, game);
		spring.putConstraint(SpringLayout.SOUTH, c, 0, SpringLayout.SOUTH, game);
		
		f.add(jsp);
		f.setBackground(Color.red);
		f.setVisible(true);//making the frame visible  
		
		jsp.getVerticalScrollBar().setValue(300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}  
	
	
	public static JButton makeFloor(JLayeredPane game){
		ImageIcon icon = new ImageIcon("resources/" + paths[pathsi]);
		JButton b = new JButton(buttonidx,icon);
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setPreferredSize(new Dimension(200,150));
		System.out.println(buttonidx);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
				  jp.show(b,b.getWidth()/2, b.getHeight()/2);
				  clickedF = Integer.parseInt(b.getText());
			          }  
			      });  		
		System.out.println(b.getText());
		buttidx.add(buttonint);
		levels.add(1);
		buttonidx = Integer.toString(buttonint);
		buttonint++;
		pathsi++;
		if(pathsi == paths.length){
			pathsi = 0;
		}
		
		game.setVisible(true);
		game.repaint();
		barr.add(b);
		
		return b;
	}
	
	
	public static void upgradeFloor(int f){
		levels.set(f-1,levels.get(f-1) + 1);
		System.out.println(levels.get(f-1));
		
	}
	
	public static void setSpringD(SpringLayout lay, JLayeredPane game, ArrayList<JButton> arr, JButton c){
		Component b = arr.get(arr.size()-1);
		lay.putConstraint(SpringLayout.WEST,b,30,SpringLayout.WEST,game);
		lay.putConstraint(SpringLayout.EAST,b,-30,SpringLayout.EAST,game);
		lay.putConstraint(SpringLayout.SOUTH,b,-ySpring,SpringLayout.SOUTH,game);
		ySpring += 150;
		
		//remove c parameter when implement part into AI
		
		
	}
	
	


	public static void updateFloor(SpringLayout lay, JLayeredPane game,ArrayList<JButton> arr, JButton c){
		//change iamge icon of the button to the floor with a resident inside
		//alternate way:using spring layout to put each resident (harder)
//		ImageIcon org = (ImageIcon) b.getIcon();
//		ImageIcon img = new ImageIcon("resources/blue.png");
//		b.setIcon(img);
//		b.repaint();
		
		Timer timer = new Timer(3000, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	setCustD(spring,game,arr,c);
		    }

			private void setCustD(SpringLayout spring, JLayeredPane game, ArrayList<JButton> arr, JButton c) {
				Integer a = Integer.parseInt(arr.get(arr.size()-1).getText());
				lay.putConstraint(SpringLayout.WEST,c,500,SpringLayout.WEST,game);
				lay.putConstraint(SpringLayout.EAST,c,-500,SpringLayout.EAST,game);
				lay.putConstraint(SpringLayout.SOUTH,c,-a*152,SpringLayout.SOUTH,game);
				
			}    
		});
		timer.start();
	}
	
	public static boolean createAnomaly(JButton b){
		//based on a random chance 
		//prevents floor from being occupied
		return false;
	}
	
	public static void customer(){
		int rand = (int) (Math.random() * barr.size());
		
	}
	
	public static void leave(){
		
		
	}
	
	public static void generate(){
		
	}


	@Override
	public void run() {
		
		
	}
}
