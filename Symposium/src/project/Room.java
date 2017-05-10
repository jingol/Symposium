package project;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Room extends Component{

	private ImageIcon displayPhoto;
	private int x;
	private int y;
	
	public Room(int x, int y,int width, int height, ImageIcon photo)
	{
		this.x = x;
		this.y = y;
		displayPhoto = photo;
		
		//button with function createImageIcon (returns new ImageIcon(string filename);
	}
}
