package TGOM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Object extends Enemy {
	
	public static final int YLAND = 500;
	
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter mainCharacter;
	
	private Rectangle rectBound;
	
	public Object(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) 
	{
		this.posX=posX;
		this.width=width;
		this.height=height;
		this.image=image;
		this.mainCharacter=mainCharacter;
		rectBound=new Rectangle();
	}
	
	public void update() 
	{
		posX-=mainCharacter.getSpeedX();
	}
	
	public void draw(Graphics g) 
	{
		g.drawImage(image,posX,YLAND-image.getHeight(),null);
		g.setColor(Color.red);

	}
	
	public Rectangle getBound() {
		rectBound=new Rectangle();
		rectBound.x=posX;
		rectBound.y =500-image.getHeight();
		rectBound.width =width;
		rectBound.height= height;
		return rectBound;
	}

	public boolean isOutOfScreen() {
		if(posX<-image.getWidth()) {
			return true;
		}
		return false;
	}
	
}