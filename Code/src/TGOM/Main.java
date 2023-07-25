package TGOM;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main  {
	
	private JFrame TGOM;

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.getTGOM().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		setTGOM(new JFrame());
		getTGOM().getContentPane().setBackground(new Color(100, 149, 237));
		getTGOM().setBackground(Color.WHITE);
		getTGOM().setTitle("The Game Of Minion");
		getTGOM().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\LogMin.jpg"));
		getTGOM().setBounds(300, 80, 800, 600);
		getTGOM().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("");
		label.setBounds(141, 218, 230, 260);
		Image img=new ImageIcon(this.getClass().getResource("/Front1.png")).getImage();
		getTGOM().getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img));
		getTGOM().getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("The Game Of Minion");
		lblNewLabel.setBounds(169, 100, 459, 61);
		lblNewLabel.setFont(new Font("BankGothic Md BT", Font.BOLD, 40));
		getTGOM().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryName EnName=new EntryName();
				getTGOM().setVisible(false);
				EnName.getEnNameframe().setVisible(true);
			}
		});
		btnNewButton.setBounds(471, 249, 179, 33);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setFont(new Font("BankGothic Lt BT", Font.BOLD, 18));
		btnNewButton.setBackground(SystemColor.desktop);
		getTGOM().getContentPane().add(btnNewButton);
		
		JButton btnScore = new JButton("High Score");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HighScore hs=new HighScore();
				getTGOM().setVisible(false);
				hs.getHighframe().setVisible(true);
			}
		});
		btnScore.setBounds(471, 295, 179, 33);
		btnScore.setForeground(SystemColor.window);
		btnScore.setFont(new Font("BankGothic Lt BT", Font.BOLD, 18));
		btnScore.setBackground(SystemColor.desktop);
		getTGOM().getContentPane().add(btnScore);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help hp=new Help();
				getTGOM().setVisible(false);
				hp.getHpframe().setVisible(true);
				
			}
		});
		btnHelp.setBounds(471, 339, 179, 33);
		btnHelp.setForeground(SystemColor.window);
		btnHelp.setFont(new Font("BankGothic Lt BT", Font.BOLD, 18));
		btnHelp.setBackground(SystemColor.desktop);
		getTGOM().getContentPane().add(btnHelp);
		
		JButton btnExit = new JButton("Credits");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits c=new Credits();
				TGOM.setVisible(false);
				c.getCframe().setVisible(true);
			}
		});
		btnExit.setBounds(471, 383, 179, 33);
		btnExit.setForeground(SystemColor.window);
		btnExit.setFont(new Font("BankGothic Lt BT", Font.BOLD, 18));
		btnExit.setBackground(SystemColor.desktop);
		getTGOM().getContentPane().add(btnExit);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(424, 249, 37, 33);
		Image imgPlay=new ImageIcon(this.getClass().getResource("/Play.png")).getImage();
		label_1.setIcon(new ImageIcon(imgPlay));
		getTGOM().getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(424, 295, 30, 33);
		Image imgTrophy=new ImageIcon(this.getClass().getResource("/Trophy-icon.png")).getImage();
		label_2.setIcon(new ImageIcon(imgTrophy));
		getTGOM().getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(422, 339, 39, 33);
		Image imgQues=new ImageIcon(this.getClass().getResource("/Question2.png")).getImage();
		label_3.setIcon(new ImageIcon(imgQues));
		getTGOM().getContentPane().add(label_3);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit_1.setBounds(471, 427, 179, 33);
		btnExit_1.setForeground(Color.WHITE);
		btnExit_1.setFont(new Font("BankGothic Lt BT", Font.BOLD, 18));
		btnExit_1.setBackground(Color.BLACK);
		getTGOM().getContentPane().add(btnExit_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(422, 427, 39, 33);
		Image imgSetting=new ImageIcon(this.getClass().getResource("/Settings1.png")).getImage();
		label_4.setIcon(new ImageIcon(imgSetting));
		getTGOM().getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(422, 383, 39, 33);
		Image imgCredits=new ImageIcon(this.getClass().getResource("/Credits.png")).getImage();
		label_5.setIcon(new ImageIcon(imgCredits));
		getTGOM().getContentPane().add(label_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(65, 82, 94, 97);
		Image imgfront=new ImageIcon(this.getClass().getResource("/FrontS.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imgfront));
		TGOM.getContentPane().add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(642, 82, 94, 97);
		Image imgfront2=new ImageIcon(this.getClass().getResource("/FrontS.png")).getImage();
		label_6.setIcon(new ImageIcon(imgfront2));
		TGOM.getContentPane().add(label_6);
		
	}
	public JFrame getMain() {
		return getTGOM();
	}

	public void setMain(JFrame m) {
		setTGOM(m);
	}

	public JFrame getTGOM() {
		return TGOM;
	}

	public void setTGOM(JFrame tGOM) {
		TGOM = tGOM;
	}
}
