package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Hotello implements Scrollable {
	
		
	private static int clickedF;
	private static int buttonint = 2;
	private static String buttonidx = "1";
	private static int ySpring = 15;
	private static int heightmulti = 0;
	
	//to upgrade buttons
	private static ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	private static ArrayList<Integer> levels = new ArrayList<Integer>();
	private static ArrayList<JButton> barr = new ArrayList<JButton>();
	
	final static JPopupMenu jp = new JPopupMenu();
	
	//adding floors
	private static int pathsi = 0;
	private static String[] paths = {"Bubblesoak_Suite.png","Haunted.png",
			"groovy.png","lounge.jpg","piano.png","red.png","Room.png",
			"marble.jpg","rustic.png","zen.png","castle.jpg","dragon.png"
			,"Honeymoon.png","Island.png","Mystik_Lounge.png","pent.jpg"
			,"pop.jpg","Roman.png","ruby.jpg"
			};

	
	
	
	//write method that will getText of button to see index (upgrade method)
	
	
	//addfloor : new Jbutton(buttonidx,imagesrc)
	//buttonidx = Integer.toString(buttonint);
	//Add button to barr
	
	public static void main(String[] args) {  
		JFrame f=new JFrame("Hotello");//creating instance of JFrame 
		f.setSize(1200,800);//400 width and 500 height  
		
		
		JPanel game = new JPanel();
		game.setOpaque(true);
		game.setBackground(new Color(255,255,255,0));
		game.setBounds(200,0,1000,900);
		SpringLayout spring = new SpringLayout();
		game.setLayout(spring);
		
		

		
		ImageIcon i = new ImageIcon("resources/Lobby.png");
		Image img = i.getImage();
		Image scaled = img.getScaledInstance(400, 150,  java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scaled);
		
		JButton b=new JButton(i);//creating instance of JButton  
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			     game.add(makeFloor(game));
			     setSpringD(spring,game,barr);
			     game.setBounds(200,0,1000,++heightmulti * 150);
			     f.setVisible(true);
			          }  
			      });  
		
		jp.add(new JMenuItem("Upgrade"));
		
		
		JScrollPane jsp = new JScrollPane(game);
//		jsp.setLayout(spring);
		jsp.setOpaque(true);
		jsp.setBackground(Color.PINK);
//		f.add(jsp);
		f.setContentPane(jsp);
		
	    jsp.setPreferredSize(new Dimension(200,300));
	    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		
		game.add(b);//adding button in JFrame 
		spring.putConstraint(SpringLayout.WEST, b, 0, SpringLayout.WEST, game);
		
//		f.add(game);
//		jsp.add(game);
		f.setBackground(Color.red);
		f.setVisible(true);//making the frame visible  
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}  
	
	
	public static JButton makeFloor(JPanel p){
		ImageIcon icon = new ImageIcon("resources/" + paths[pathsi]);
		JButton b = new JButton(buttonidx,icon);
		b.setBackground(Color.black);
		b.setOpaque(true);
		System.out.println(buttonidx);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
//				  jp.show(b,b.getBounds().x/2, b.getBounds().y/2
//			              + b.getBounds().height/2);
				  upgradeFloor(b);
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
		
		p.setVisible(true);
		p.repaint();
		barr.add(b);
		return b;
	}
	
	
	public static void upgradeFloor(JButton b){
		int modify = Integer.parseInt(b.getText());
		levels.set(modify-1,levels.get(modify-1) + 1);
		System.out.println(levels.get(modify-1));
		
	}
	
	public static void setSpringD(SpringLayout lay, JPanel p, ArrayList<JButton> arr){
		Component b = arr.get(arr.size()-1);
		lay.putConstraint(SpringLayout.WEST,b,10,SpringLayout.WEST,p);
		lay.putConstraint(SpringLayout.EAST,b,-20,SpringLayout.EAST,p);
//		lay.putConstraint(b.NORTH, b, 400, b.SOUTH, b);
		lay.putConstraint(SpringLayout.NORTH,b,ySpring,SpringLayout.NORTH,p);
		ySpring += 150;
	}


	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getScrollableBlockIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getScrollableUnitIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
