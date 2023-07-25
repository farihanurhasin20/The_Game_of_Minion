package TGOM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import TGOM.Clouds;
import TGOM.EnemiesManager;

import TGOM.MainCharacter;
import TGOM.Resource;

public class GameScreen extends JPanel implements Runnable, KeyListener {

	private static final int START_GAME_STATE=0;
	private static final int GAME_PLAYING_STATE=1;
	private static final int GAME_OVER_STATE=2;
	
	
	private MainCharacter mainCharacter;
	private EnemiesManager enemiesManager;
	private Clouds clouds;
	private Thread thread;

	
	private boolean isKeyPressed;

	private int gameState = START_GAME_STATE;
	
	private Image backgroundImage;
	public GameScreen() {
		
		
		
		try {
			backgroundImage= ImageIO.read(new File("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\Back.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainCharacter = new MainCharacter();
		mainCharacter.setSpeedX(4);
		enemiesManager = new EnemiesManager(mainCharacter);
		clouds = new Clouds(mainCharacter);
	}

	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}

	public void gameUpdate() {
		if (gameState == GAME_PLAYING_STATE) {
			clouds.update();
			
			mainCharacter.update();
			enemiesManager.update();
			if (enemiesManager.isCollision()) {
				
				gameState = GAME_OVER_STATE;
				mainCharacter.dead(true);
			}
		}
	}

	public void paint(Graphics g) {
		
		super.paint(g);
	    g.drawImage(backgroundImage, 0, 0, null);

		switch(gameState) 
		{
		case START_GAME_STATE:
			mainCharacter.draw(g);
			break;
		case GAME_PLAYING_STATE:
		case GAME_OVER_STATE:
			clouds.draw(g);
			
			enemiesManager.draw(g);
			mainCharacter.draw(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("BankGothic Md BT",1,20));
			g.drawString("HIGH SCORE: " +mainCharacter.highscore, 540, 25);
			g.drawString("SCORE: " +mainCharacter.score, 540, 42);
			if (gameState==GAME_OVER_STATE) {
				
				mainCharacter.score=0;
				g.setFont(new Font("BankGothic Md BT",1,40));
				g.drawString("GAME OVER",248,200);
				g.setFont(new Font("BankGothic Md BT",1,30));
				g.drawString("Press Space To Continue",160,250);
				g.setFont(new Font("BankGothic Md BT",1,20));
				g.drawString("Press E To Exit Or Press B For Back Menu",142,300);
				
			}
			break;
		}
	}

	
	public void run() {

		int fps=100;
		long msPerFrame=1000*1000000/fps;
		long lastTime=0;
		long elapsed;
		int msSleep;
		int nanoSleep;
		long endProcessGame;
		long lag=0;

		while (true) {
			gameUpdate();
			repaint();
			endProcessGame=System.nanoTime();
			elapsed=(lastTime+msPerFrame-System.nanoTime());
			msSleep=(int)(elapsed/1000000);
			nanoSleep=(int)(elapsed%1000000);
			if (msSleep<=0) {
				lastTime = System.nanoTime();
				continue;
			}
			try {
				Thread.sleep(msSleep, nanoSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = System.nanoTime();
		}
	}

	
	public void keyPressed(KeyEvent e) {
		if (!isKeyPressed) {
			isKeyPressed = true;
			switch (gameState) {
			case START_GAME_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameState = GAME_PLAYING_STATE;
				}
				break;
			case GAME_PLAYING_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					mainCharacter.jump();
				}
				break;
			case GAME_OVER_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameState = GAME_PLAYING_STATE;
					resetGame();
				}
				else if (e.getKeyCode() == KeyEvent.VK_E) {
					try {
						  String path = "C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt";
					      FileWriter myWriter = new FileWriter("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt",true);
					      
					      myWriter.write(mainCharacter.highscore+" "+"\n");
					      myWriter.close();
					      
					      System.exit(0); 
					    } 
					
					catch (IOException ep) {
					      ep.printStackTrace();
					    }
					
				}
				else if (e.getKeyCode() == KeyEvent.VK_B) {
					try {
						  String path = "C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt";
					      FileWriter myWriter = new FileWriter("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt",true);
					      
					      myWriter.write(mainCharacter.highscore+" "+"\n");
					      myWriter.close();
					        Main main=new Main();
							setVisible(false);
							main.getMain().setVisible(true);
					      
					    } 
					
					catch (IOException ep) {
					      ep.printStackTrace();
					    }
					
				}
				break;

			}
		}
	}

	
	public void keyReleased(KeyEvent e) {
		isKeyPressed=false;
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void resetGame() {
		enemiesManager.reset();
		mainCharacter.dead(false);
		mainCharacter.reset();
	}

}