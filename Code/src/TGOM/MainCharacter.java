package TGOM;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import TGOM.Animation;
import TGOM.Resource;

public class MainCharacter {

	public static final int LAND_POSY = 425;
	public static final float GRAVITY = 0.4f;
	
	private static final int NORMAL_RUN = 0;
	private static final int JUMPING = 1;
	private static final int DEATH = 2;
	
	private float posY;
	private float posX;
	private float speedX;
	private float speedY;
	private Rectangle rectBound;
	
	public int score = 0;
	public int highscore=0;
	
	private int state = NORMAL_RUN;
	
	private Animation normalRunAnim;
	private BufferedImage jumping;
	private BufferedImage deathImage;
	
	
	public MainCharacter() {
		
		posX = 50;
		posY = LAND_POSY;
		rectBound = new Rectangle();
		normalRunAnim = new Animation(150);
		normalRunAnim.addFrame(Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Minion1.png"));
		jumping = Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Minion2.png");
		deathImage = Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Evil.png");
	}

	public float getSpeedX()
	{
		return speedX;
	}

	public void setSpeedX(int speedX)
	{
		this.speedX = speedX;
	}
	
	public void draw(Graphics g) {
		switch(state) {
			case NORMAL_RUN:
				g.drawImage(normalRunAnim.getFrame(), (int) posX, (int) posY, null);
				break;
			case JUMPING:
				g.drawImage(jumping, (int) posX, (int) posY, null);
				break;
			case DEATH:
				g.drawImage(deathImage, (int) posX, (int) posY, null);
				break;
		}
	}
	
	public void update() {
		normalRunAnim.updateFrame();
		if(posY >= LAND_POSY) {
			posY = LAND_POSY;
				state = NORMAL_RUN;
			
		} else
		{
			speedY += GRAVITY;
			posY += speedY;
		}
	}
	
	public void jump()
	{
			speedY = -10.7f;
			posY += speedY;
			state = JUMPING;
		}
	
	
		
	
	
	public Rectangle getBound() {
		rectBound = new Rectangle();
		
			rectBound.x = (int) posX;
			rectBound.y = (int) posY;
			rectBound.width = normalRunAnim.getFrame().getWidth();
			rectBound.height = normalRunAnim.getFrame().getHeight();
		
		return rectBound;
	}
	
	public void dead(boolean isDeath) {
		if(isDeath) {
			state = DEATH;
		} else {
			state = NORMAL_RUN;
		}
	}
	
	public void reset() {
		posY = LAND_POSY;
	}
	
	
	public void upScore() {
		score += 20;
		if(score>highscore)
            highscore=score;  
            
		
		}
	
	
}

