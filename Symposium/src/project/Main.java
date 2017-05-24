package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Main {
	
	private static int iy = 700;
		
	private static int clickedF;
	private static int buttonint = 2;
	private static String buttonidx = "2";
	
	//to upgrade buttons
	private ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	private ArrayList<JButton> barr = new ArrayList<JButton>();
	
	final static JPopupMenu jp = new JPopupMenu();
	
	//adding floors
	private static int pathsi = 0;
	private static String[] paths = {"blue.jpg","Haunted.png","lounge.jpg",
			"piano.png","red.png","Room.png","rustic.png"};
	
	
	//write method that will getText of button to see index (upgrade method)
	
	
	//addfloor : new Jbutton(buttonidx,imagesrc)
	//buttonidx = Integer.toString(buttonint);
	//Add button to barr
	
	public static void main(String[] args) {  
		JFrame f=new JFrame("Hotello");//creating instance of JFrame 
		f.setSize(1200,1000);//400 width and 500 height  
		
		JPanel game = new JPanel();
		game.setOpaque(true);
		game.setBackground(Color.blue);
		game.setBounds(200,0,600,800);
		
		

		
		ImageIcon i = new ImageIcon("resources/Lobby.png");
		Image img = i.getImage();
		Image scaled = img.getScaledInstance(400, 150,  java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scaled);
		
		JButton b=new JButton(i);//creating instance of JButton  
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setBounds(400,150,200,200);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			     game.add(makeFloor(game,f));
			     System.out.println("buttadded");
			    
			          }  
			      });  
		
		jp.add(new JMenuItem("Upgrade"));
		
		
//		JScrollPane s=new JScrollPane(game); 
//		
//		
//		game.setAutoscrolls(true);
		
		game.add(b);//adding button in JFrame 
		
		
		f.add(game);
		
		f.setLayout(null);
		f.setVisible(true);//making the frame visible  
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}  
	
	
	public static JButton makeFloor(JPanel p, JFrame j){
		ImageIcon icon = new ImageIcon("resources/" + paths[pathsi]);
		JButton b = new JButton(buttonidx,icon);
		b.setBounds(300,iy,400,200);
		b.setBackground(Color.black);
		b.setOpaque(true);
		System.out.println(buttonidx);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
				  jp.show(b,b.getBounds().x/4, b.getBounds().y/4
			              + b.getBounds().height/4);
			          }  
			      });  
		buttonint++;		
		buttonidx = Integer.toString(buttonint);
		iy -= 100;
		pathsi++;
		if(pathsi == paths.length){
			pathsi = 0;
		}
		
		p.setVisible(true);
		p.repaint();
		return b;
	}
	
	
	public static void upgradeFloor(JButton b){
		b.add(new PopupMenu());
		  
	}
}
