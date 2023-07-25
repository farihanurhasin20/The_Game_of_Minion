package TGOM;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import TGOM.Resource;

public class EnemiesManager {
	
	private BufferedImage Snow;
	private BufferedImage Castle;
	private Random rand;
	
	private List<Enemy> enemies;
	private MainCharacter mainCharacter;
	
	public EnemiesManager(MainCharacter mainCharacter) {
		rand = new Random();
		Snow = Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Snow.png");
		Castle = Resource.getResouceImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Castle.png");
		enemies = new ArrayList<Enemy>();
		this.mainCharacter = mainCharacter;
		enemies.add(createEnemy());
	}
	
	public void update() {
		for(Enemy e : enemies) {
			e.update();
		}
		Enemy enemy = enemies.get(0);
		if(enemy.isOutOfScreen()) {
			mainCharacter.upScore();
			enemies.clear();
			enemies.add(createEnemy());
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	public Enemy createEnemy() {
		
		int type=rand.nextInt(2);
		if(type==0) {
			return new Object(mainCharacter,800,Snow.getWidth(),Snow.getHeight(),Snow);
		} 
		else {
			return new Object(mainCharacter,800,Castle.getWidth(),Castle.getHeight(),Castle);
		}
	}
	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (mainCharacter.getBound().intersects(e.getBound())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(createEnemy());
	}
	
}

