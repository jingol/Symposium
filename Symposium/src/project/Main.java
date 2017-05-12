package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Main {
	
	private static int iy = 600;
		
	private static int clickedF;
	private static int buttonint = 2;
	private static String buttonidx = "2";
	
	//to upgrade buttons
	private ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	private ArrayList<JButton> barr = new ArrayList<JButton>();
	
	
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
		game.setBounds(0,0,400,600);
		game.setBackground(Color.blue);
		
		System.out.println("panel created");
		
		ImageIcon i = new ImageIcon("resources/Lobby.png");
		JButton b=new JButton(buttonidx,i);//creating instance of JButton  
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setBounds(500,100,300, 200);//x axis, y axis, width, height  
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			        game.add(makeFloor(game));
			        
			          }  
			      });  
	
		
		
		JScrollPane s=new JScrollPane(game); 
		
		
		game.setAutoscrolls(true);
		
		game.add(b);//adding button in JFrame 
		
		System.out.println("button added");
		f.add(game);
		
		System.out.println("panel added");
		
	
		f.setVisible(true);//making the frame visible  
		
		System.out.println("frame visible");
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}  
	
	public Room makeRoom(){
		return null;
		
	}
	
	public static JButton makeFloor(JPanel p){
		ImageIcon icon = new ImageIcon("resources/" + paths[pathsi]);
		JButton b = new JButton(buttonidx,icon);
		b.setBounds(500,iy,400,200);
		b.setBackground(Color.black);
		b.setOpaque(true);
		System.out.println(buttonidx);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
				  upgradeFloor();
			          }  
			      });  
		p.repaint();
		buttonint++;
		buttonidx = Integer.toString(buttonint);
		iy -= 150;
		pathsi++;
		return b;
		
	}
	
	public static void upgradeFloor(){
		
		
	}
}
