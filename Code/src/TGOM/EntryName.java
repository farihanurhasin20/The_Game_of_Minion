package TGOM;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EntryName extends Main {

	public static final String EntryName = null;
	private JFrame EnNameframe;
	
	private JTextField uname;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryName window = new EntryName();
					window.getEnNameframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EntryName() {
		initialize();
	}

	private void initialize() {
		setEnNameframe(new JFrame());
		getEnNameframe().getContentPane().setBackground(new Color(30, 144, 255));
		EnNameframe.getContentPane().setLayout(null);
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name");
		lblEnterYourName.setFont(new Font("BankGothic Md BT", Font.BOLD, 26));
		lblEnterYourName.setBounds(264, 179, 271, 58);
		EnNameframe.getContentPane().add(lblEnterYourName);
		
		uname = new JTextField();
		uname.setToolTipText("Enter Your Name");
		uname.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		uname.setBounds(264, 246, 272, 20);
		EnNameframe.getContentPane().add(uname);
		uname.setColumns(10);
		
		
		JButton btnEnter = new JButton("OK");
		btnEnter.setFont(new Font("BankGothic Md BT", Font.BOLD, 18));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String path = "C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt";
				      FileWriter myWriter = new FileWriter("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt",true);
				      
				      myWriter.write(uname.getText()+"      ");
				      myWriter.close();
				      
				    } 
				catch (IOException ep) {
				      System.out.println("ERROR 404!");
				      ep.printStackTrace();
				    }
				
				
				String wname = uname.getText().toString();
				Welcome wel=new Welcome(wname);
				EnNameframe.setVisible(false);
				wel.getwelframe().setVisible(true);
				
			}
		});
		btnEnter.setForeground(SystemColor.textText);
		btnEnter.setBackground(Color.WHITE);
		btnEnter.setBounds(340, 287, 111, 23);
		EnNameframe.getContentPane().add(btnEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main=new Main();
				EnNameframe.setVisible(false);
				main.getMain().setVisible(true);
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("BankGothic Md BT", Font.BOLD, 18));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(663, 521, 111, 29);
		EnNameframe.getContentPane().add(btnBack);
		
		
		getEnNameframe().setIconImage(Toolkit.getDefaultToolkit().getImage("/LogMin.jpg"));
		getEnNameframe().setTitle("The Game Of Minion");
		getEnNameframe().setBounds(300, 80, 800, 600);
		getEnNameframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getEnNameframe() {
		return EnNameframe;
	}

	public void setEnNameframe(JFrame enNameframe) {
		EnNameframe = enNameframe;
	}
}

