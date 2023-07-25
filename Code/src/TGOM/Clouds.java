package TGOM;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import TGOM.GameWindow;
import TGOM.Resource;

public class Clouds {
	private List<ImageCloud> listCloud;
	private BufferedImage cloud;
	
	private MainCharacter mainCharacter;
	
	public Clouds(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		cloud = Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Cloud.png");
		listCloud = new ArrayList<ImageCloud>();
		
		ImageCloud imageCloud=new ImageCloud();
		imageCloud.posX=0;
		imageCloud.posY=30;
		listCloud.add(imageCloud);
		
		imageCloud=new ImageCloud();
		imageCloud.posX=150;
		imageCloud.posY=40;
		listCloud.add(imageCloud);
		
		imageCloud=new ImageCloud();
		imageCloud.posX=300;
		imageCloud.posY=50;
		listCloud.add(imageCloud);
		
		imageCloud=new ImageCloud();
		imageCloud.posX=450;
		imageCloud.posY=20;
		listCloud.add(imageCloud);
		
		imageCloud=new ImageCloud();
		imageCloud.posX=600;
		imageCloud.posY=60;
		listCloud.add(imageCloud);
		
		imageCloud=new ImageCloud();
		imageCloud.posX=750;
		imageCloud.posY=50;
		listCloud.add(imageCloud);
	}
	
	public void update()
	{
		Iterator<ImageCloud> itr= listCloud.iterator();
		ImageCloud firstElement= itr.next();
		firstElement.posX-= mainCharacter.getSpeedX()/2;
		while(itr.hasNext()) 
		{
			ImageCloud element= itr.next();
			element.posX-= mainCharacter.getSpeedX()/2;
		}
		if(firstElement.posX<-cloud.getWidth())
		{
			listCloud.remove(firstElement);
			firstElement.posX = GameWindow.SCREEN_WIDTH;
			listCloud.add(firstElement);
		}
	}
	
	public void draw(Graphics g) {
		for(ImageCloud imgLand : listCloud) {
			g.drawImage(cloud, (int) imgLand.posX, imgLand.posY, null);
		}
	}
	
	public class ImageCloud {
		float posX;
		int posY;
	}
}
