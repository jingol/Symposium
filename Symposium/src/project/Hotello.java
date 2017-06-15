package project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class Hotello extends JLayeredPane{
	
		
	private static int clickedF;
	private static int buttonint = 2;
	private static String buttonidx = "1";
	private static int ySpring = 180;
	private static int heightmulti = 1;
	private static int bwidth = 212;
	private static boolean running = false;
	private static SpringLayout spring = new SpringLayout();
	private static int income = 0;
	private static int balance = 1000;
	private static int time = 3000;
	
	private static JLabel money = new JLabel("Income:$" + income + "/Balance:" + balance);
	
	
	
	//to upgrade buttons
	private static ArrayList<Integer> buttidx = new ArrayList<Integer>(); 
	private static ArrayList<Integer> levels = new ArrayList<Integer>();
	private static ArrayList<JButton> barr = new ArrayList<JButton>();
	private static ArrayList<JButton> unoccupied = new ArrayList<JButton>();
	
	final static JPopupMenu jp = new JPopupMenu();
	
	//adding floors
	private static int pathsi = 0;
	private static String[] paths = {"blue.png","Bubblesoak_Suite.png","Haunted.png",
			"groovy.png","piano.png","red.png","Room.png",
			"marble.png","rustic.png","zen.png","castle.png","dragon.png"
			,"Honeymoon.png","Island.png","Mystik_Lounge.png","pent.png"
			,"pop.png","Roman.png",
			};
	private static String[] cust = {"choco.png","cloud.png","hope.png","lann.png","light.png","noct.png","orl.png","reyna.png","rinoa.png"
			,"squall.png","terra.png","tifa.png","vincent.png","zidane.png","aria.png","ingus.png","moogle.png","tidus.png","kuma.png"};

	
	
	
	//write method that will getText of button to see index (upgrade method)
	
	
	//addfloor : new Jbutton(buttonidx,imagesrc)
	//buttonidx = Integer.toString(buttonint);
	//Add button to barr
	
	public static void main(String[] args) throws IOException {  
		JFrame f=new JFrame("Hotello");//creating instance of JFrame 
		f.setSize(1200,800);//400 width and 500 height  
		
		JLayeredPane game = new JLayeredPane();
		game.setOpaque(false);
		game.isOptimizedDrawingEnabled();
		game.setPreferredSize(new Dimension(800,900));
		game.setLayout(spring);
		
		money.setBounds(0,0,200,100);
		money.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		
		JPanel back = new JPanel();
		Color col = new Color(102, 255, 153);
		back.setBackground(col);
		
		
		JScrollPane jsp = new JScrollPane(game);
		jsp.getVerticalScrollBar().setUnitIncrement(20);	
		jsp.setBackground(Color.PINK);		
		
		Timer occ = new Timer(2500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(unoccupied.size() > 0){
            	   customer();
            	 
               }
            }
        });
		occ.setInitialDelay(5000);
		occ.setCoalesce(false);
	
	
	
		Timer bank = new Timer(1000,new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				balance += income;
				update();
					
				}
		});
			
		ImageIcon i = new ImageIcon("resources/Lobby.png");
		Image img = i.getImage();
		Image scaled = img.getScaledInstance(650, 160,  java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(scaled);
		JButton b=new JButton(i);//creating instance of JButton  
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setPreferredSize(new Dimension(800,180));
		b.addActionListener(new ActionListener(){  

			public void actionPerformed(ActionEvent e){ 
				if(!running){
					occ.start();
					bank.start();
					running = true;
				}
			    if(balance >= 500){
			    	 game.add(makeFloor(game));
				     setSpringD(spring,game,barr);
				     game.setPreferredSize(new Dimension(800,heightmulti * bwidth));
				     heightmulti++;
				     bwidth--;
				     jsp.getVerticalScrollBar().setValue(0);
				     balance -= 500;
				     game.setVisible(true);
				     f.setVisible(true);
				          }  
			    }
			      }); 
	
		
		
		JMenuItem up = new JMenuItem("Upgrade");
		up.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			   upgradeFloor(clickedF);
			          }  
			      }); 
		JMenuItem clean = new JMenuItem("Clean");
		clean.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cleanUp(clickedF);
				
			}
		});
		jp.add(up); 
		jp.add(clean);
		
		game.add(b,0);
		back.add(money);
		game.add(back);
		
		spring.putConstraint(SpringLayout.WEST, b, 320, SpringLayout.WEST, game);
		spring.putConstraint(SpringLayout.EAST, b, -0, SpringLayout.EAST, game);
		spring.putConstraint(SpringLayout.SOUTH, b, 0, SpringLayout.SOUTH, game);
		
		f.add(jsp);
		f.setBackground(Color.red);
		f.setVisible(true);//making the frame visible  
		
		jsp.getVerticalScrollBar().setValue(300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		}  
	
	public static int getRand(){
		int rand = (int) (Math.random() * unoccupied.size());
		return rand;
	}
	
	public static JButton makeFloor(JLayeredPane game){
		ImageIcon icon = new ImageIcon("resources/" + paths[pathsi]);
		Image img = icon.getImage();
		icon = new ImageIcon(img);
		JButton b = new JButton("Floor " + buttonidx + ", Level 1",icon);
		b.setHorizontalAlignment(SwingConstants.RIGHT);
		b.setForeground(Color.WHITE 	);
		b.setBackground(Color.black);
		b.setOpaque(true);
		b.setPreferredSize(new Dimension(200,180));
		b.setFont(new Font("Lucida Calligraphy",Font.PLAIN,20));
		
		System.out.println(buttonidx);
		b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
				  jp.show(b,b.getWidth()/2, b.getHeight()/2);
				  String flr = b.getText().substring(6,7);
				  clickedF = Integer.parseInt(flr);
			          }  
			      });  		
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
		unoccupied.add(b);
		
		return b;
	}
	
	
	public static void upgradeFloor(int f){
		int cost;
		if(levels.get(f-1) <= 2){
			cost = levels.get(f-1)*200;
		}
		else{
			cost = levels.get(f-1)*350;
		}
		if(balance >= cost){
			levels.set(f-1,levels.get(f-1) + 1);
			barr.get(f-1).setText("Floor " + f + ", Level " + levels.get(f-1));
			balance -= cost;
		}
		
		
	}
	
	public static void setSpringD(SpringLayout lay, JLayeredPane game, ArrayList<JButton> arr){
		Component b = arr.get(arr.size()-1);
		lay.putConstraint(SpringLayout.WEST,b,320,SpringLayout.WEST,game);
		lay.putConstraint(SpringLayout.EAST,b,0,SpringLayout.EAST,game);
		lay.putConstraint(SpringLayout.SOUTH,b,-ySpring,SpringLayout.SOUTH,game);
		ySpring += 170;		
		
	}
	
	
	

	public static void customer(){
		int rand = getRand();
		ImageIcon org = (ImageIcon) barr.get(rand).getIcon();
		ImageIcon stop = new ImageIcon("customers/stop.png");
		int profit;
		if(org == stop){
			profit = 0;
			barr.get(rand).setIcon(stop);
		}
		else{
			profit = levels.get(rand) * 50;
			int rc = (int) (Math.random() * cust.length);
			Icon i1 = new ImageIcon("customers/" + cust[rc]);
			Icon i2 = org;
			Image image1 = ((ImageIcon) i1).getImage();
			Image image2 = ((ImageIcon) i2).getImage();
			Image com = new BufferedImage(i2.getIconWidth()+100,i2.getIconHeight(),1);
			Graphics2D g2 = ((BufferedImage) com).createGraphics();
			g2.drawImage(image1, 0, 50, null);
			g2.drawImage(image2, image1.getWidth(null), 0, null);
			g2.dispose();
			ImageIcon ni = 	new ImageIcon(com);
			barr.get(rand).setIcon(ni);
			income += profit;
			update();
			Timer change = new Timer(3000,new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	income -= profit;
	            	if(!createAnomaly()){
	            		barr.get(rand).setIcon(new ImageIcon("customers/stop.png"));
	            	}
	            	else{
	            		barr.get(rand).setIcon(org);
	            	}
	            	
	            		}
		        });
			Timer meh = new Timer(5000,new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	change.stop();
	            		}
		        });
			change.setCoalesce(false);
			change.start();
			meh.start();
		}
	}
	
	public static boolean createAnomaly(){
		int rand = (int) (Math.random() * 20);
		if(rand > 3){
			return true;
		}
		return false;
	}
	
	public static void update(){
		money.setText("Income:" + income + "/Balance:" + balance);
	}
	
	public static void cleanUp(int i){
		barr.get(i-1).setIcon(new ImageIcon("resources/" + paths[i-1]));
	}
	
	public static void removeAnomaly(){
		
		
	}


}
