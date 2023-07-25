package TGOM;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Credits extends Main {

	private JFrame cframe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits window = new Credits();
					window.getCframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Credits() {
		initialize();
	}

	private void initialize() {
		setCframe(new JFrame());
		getCframe().setTitle("The Game Of Minion");
		getCframe().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\minion.jpg"));
		getCframe().setBounds(300, 80, 800, 600);
		getCframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getCframe() {
		return cframe;
	}

	public void setCframe(JFrame cframe) {
		this.cframe = cframe;
		cframe.getContentPane().setBackground(new Color(0, 191, 255));
		cframe.getContentPane().setLayout(null);
		
		JLabel lblKaziR = new JLabel("Kazi Ramisa Rifa");
		lblKaziR.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblKaziR.setBounds(307, 115, 191, 25);
		cframe.getContentPane().add(lblKaziR);
		
		JLabel label = new JLabel("1911019642");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label.setBounds(307, 151, 191, 25);
		cframe.getContentPane().add(label);
		
		JLabel lblFarihaNurHasin = new JLabel("Fariha Nur Hasin");
		lblFarihaNurHasin.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblFarihaNurHasin.setBounds(307, 223, 202, 25);
		cframe.getContentPane().add(lblFarihaNurHasin);
		
		JLabel label_3 = new JLabel("1912148642");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label_3.setBounds(307, 259, 191, 25);
		cframe.getContentPane().add(label_3);
		
		JLabel lblFaridaYeasminMim = new JLabel("Farida Yeasmin Mim");
		lblFaridaYeasminMim.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		lblFaridaYeasminMim.setBounds(294, 331, 220, 25);
		cframe.getContentPane().add(lblFaridaYeasminMim);
		
		JLabel label_6 = new JLabel("1911653642");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		label_6.setBounds(307, 367, 191, 25);
		cframe.getContentPane().add(label_6);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main();
				cframe.setVisible(false);
				m.getTGOM().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("BankGothic Md BT", Font.BOLD, 16));
		btnNewButton.setBounds(685, 527, 89, 23);
		cframe.getContentPane().add(btnNewButton);
	}

}
