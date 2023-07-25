package TGOM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HighScore extends Main {

	private JFrame highframe;
	private JTextField dname;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HighScore window = new HighScore();
					window.getHighframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HighScore() {
		initialize();
	}

	private void initialize() {
		highframe = new JFrame();
		highframe.setTitle("The Game Of Minion");
		highframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\Img\\LogMin.jpg"));
		highframe.getContentPane().setBackground(new Color(0, 206, 209));
		highframe.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(284, 93, 99, 37);
		lblName.setFont(new Font("BankGothic Md BT", Font.BOLD, 23));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		highframe.getContentPane().add(lblName);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(437, 93, 93, 37);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("BankGothic Md BT", Font.BOLD, 23));
		highframe.getContentPane().add(lblScore);
		
		dname = new JTextField();
		dname.setToolTipText("Enter Name");
		dname.setBounds(309, 465, 170, 20);
		highframe.getContentPane().add(dname);
		dname.setColumns(10);
		
		JLabel lblDeleteUserName = new JLabel("Delete User Name");
		lblDeleteUserName.setForeground(SystemColor.desktop);
		lblDeleteUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteUserName.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		lblDeleteUserName.setBounds(322, 440, 141, 14);
		highframe.getContentPane().add(lblDeleteUserName);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = dname.getText().toString();
				
				try {
					
					File f1= new File("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt"); 
					File f2= new File("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User1.txt");
					FileReader fr = new FileReader(f1);
					FileWriter fw = new FileWriter(f2,true);
		            BufferedReader br = new BufferedReader(fr);
		            BufferedWriter bw=new BufferedWriter(fw);
		            String line, fuser, fsc;
		            
		            
		            while ((line = br.readLine()) != null) {
		            	
		                fuser = line.split("      ")[0];
		                fsc = line.split(" ")[1];
		                if (fuser.equals(name)) {
		                        
		                }
		                else
		                {	
		                fw.write(line+"\n");
					    }
		                
		            }
		            fr.close();
		            fw.close();
		            f1.delete();
		            File rf =new File("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt");
		            f2.renameTo(rf);
				}
				catch (Exception ep) {
		            ep.printStackTrace();
		        }
				Main main=new Main();
				highframe.setVisible(false);
				main.getMain().setVisible(true);
			}
			
		});
		btnDone.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		btnDone.setBorderPainted(false);
		btnDone.setForeground(Color.WHITE);
		btnDone.setBackground(Color.BLACK);
		btnDone.setBounds(345, 496, 89, 23);
		highframe.getContentPane().add(btnDone);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main=new Main();
				highframe.setVisible(false);
				main.getMain().setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(685, 527, 89, 23);
		highframe.getContentPane().add(btnBack);
		highframe.setTitle("The Game Of Minion");
		highframe.setBounds(300, 80, 800, 600);
		getHighframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try  
		{  
		File file=new File("C:\\Users\\user\\eclipse-workspace\\The Game Of Minion\\User.txt");    
		FileReader fr=new FileReader(file);   
		BufferedReader br=new BufferedReader(fr);  
		StringBuffer sb=new StringBuffer();    
		   String line;
		   int x=300;
		   int y=0;
		while((line=br.readLine())!=null)  
		{  
			
			JLabel lblNewLabel = new JLabel(line+"\n");
			lblNewLabel.setBounds(x, y, 531, 336);
			
			lblNewLabel.setFont(new Font("BankGothic Md BT", Font.BOLD, 24));
			y+=40;
			
			
			highframe.getContentPane().add(lblNewLabel);
		}  
		fr.close();
		}
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
		
	}

	public JFrame getHighframe() {
		return highframe;
	}

	public void setHighframe(JFrame highframe) {
		this.highframe = highframe;
	}
}
