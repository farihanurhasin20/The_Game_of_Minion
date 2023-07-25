package TGOM;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome implements KeyListener {

	public String Welname;
	private JFrame welframe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome("NULL");
					window.welframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcome(String wname) {
		Welname=wname;
		initialize();
	}

	
	private void initialize() {
		welframe = new JFrame();
		welframe.getContentPane().setBackground(new Color(0, 191, 255));
		getwelframe().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\LogMin.jpg"));
		getwelframe().setTitle("The Game Of Minion");
		welframe.setBounds(300, 80, 800, 600);
		welframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welframe.getContentPane().setLayout(null);
		
		JLabel lblWe = new JLabel(Welname);
		lblWe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWe.setForeground(Color.WHITE);
		lblWe.setFont(new Font("BankGothic Md BT", Font.BOLD, 24));
		lblWe.setBounds(182, 201, 445, 45);
		welframe.getContentPane().add(lblWe);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("BankGothic Md BT", Font.BOLD, 30));
		lblWelcome.setBounds(327, 157, 151, 45);
		welframe.getContentPane().add(lblWelcome);
		
		JLabel lblPressEnterTo = new JLabel("Press The Button To Continue...");
		lblPressEnterTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressEnterTo.setForeground(Color.WHITE);
		lblPressEnterTo.setFont(new Font("BankGothic Md BT", Font.BOLD, 18));
		lblPressEnterTo.setBounds(216, 267, 383, 14);
		welframe.getContentPane().add(lblPressEnterTo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		Image imgPlay=new ImageIcon(this.getClass().getResource("/PlayWel.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgPlay));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow gw=new GameWindow();
				welframe.setVisible(false);
				gw.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		btnNewButton.setBounds(359, 292, 92, 73);
		welframe.getContentPane().add(btnNewButton);
	
	}
	

	public JFrame getwelframe() {
		return welframe;
	}

	public void setwelframe(JFrame welf) {
		welframe = welf;
	}

	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.exit(0);
		}
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
