package TGOM;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends Main {

	private JFrame hpframe;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
					window.getHpframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Help() {
		initialize();
	}

	private void initialize() {
		setHpframe(new JFrame());
		getHpframe().setTitle("The Game Of Minion");
		getHpframe().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\minion.jpg"));
		getHpframe().setBounds(300, 80, 800, 600);
		getHpframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getHpframe() {
		return hpframe;
	}

	public void setHpframe(JFrame hpframe) {
		this.hpframe = hpframe;
		hpframe.getContentPane().setBackground(new Color(64, 224, 208));
		hpframe.getContentPane().setLayout(null);
		
		JLabel lblUseSpaceBar = new JLabel("Use \"Space\" To Avoid Snow Man");
		lblUseSpaceBar.setFont(new Font("BankGothic Md BT", Font.BOLD, 23));
		lblUseSpaceBar.setBounds(199, 172, 414, 14);
		hpframe.getContentPane().add(lblUseSpaceBar);
		
		JLabel lblUsedoubleSpace = new JLabel("Use \"Double Space\" To Avoid Castle");
		lblUsedoubleSpace.setFont(new Font("BankGothic Md BT", Font.BOLD, 23));
		lblUsedoubleSpace.setBounds(173, 295, 473, 14);
		hpframe.getContentPane().add(lblUsedoubleSpace);
		
		JLabel label = new JLabel("");
		label.setBounds(367, 210, 67, 58);
		Image imgPlay=new ImageIcon(this.getClass().getResource("/SnowHP.png")).getImage();
		label.setIcon(new ImageIcon(imgPlay));
		hpframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(341, 329, 118, 94);
		Image imgPlay2=new ImageIcon(this.getClass().getResource("/CastleHP.png")).getImage();
		label_1.setIcon(new ImageIcon(imgPlay2));
		hpframe.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				hpframe.setVisible(false);
				m.getTGOM().setVisible(true);
			}
		});
		btnBack.setBackground(new Color(0, 0, 0));
		btnBack.setFont(new Font("BankGothic Md BT", Font.BOLD, 16));
		btnBack.setBounds(354, 516, 89, 23);
		hpframe.getContentPane().add(btnBack);
	}
}
