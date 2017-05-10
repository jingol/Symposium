package project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Main {
		
	int clickedF = 0;
	static int buttonint = 2;
	static String buttonidx = "1";
	ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	ArrayList<JButton> barr = new ArrayList<JButton>();
	
	//write method that will getText of button to see index (upgrade method)
	
	
	//addfloor : new Jbutton(buttonidx,imagesrc)
	//buttonidx = Integer.toString(buttonint);
	//Add button to barr
	
	public static void main(String[] args) {  
		JFrame f=new JFrame();//creating instance of JFrame 
		ImageIcon i = new ImageIcon("resources/blue.jpg");
		JButton b=new JButton("pie",i);//creating instance of JButton  
		buttonidx =Integer.toString(buttonint);
		System.out.println(buttonidx);
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setBounds(130,100,300, 200);//x axis, y axis, width, height  
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			               
			          }  
			      });  
	
		
		f.setSize(600,800);//400 width and 500 height  
		
		JScrollBar s=new JScrollBar();  
		s.setBounds(f.getWidth()-50,100, 50,100);
		
		Room r = new Room(0,200,100,300,new ImageIcon("cherry.jpg"));
		f.add(r);
		
		f.add(s);
		f.add(b);//adding button in JFrame  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}  
	
	public Room makeRoom(){
		return null;
		
	}
}
