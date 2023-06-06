package incontri;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 
public class PrimaryFrame extends JFrame{
	private JFrame login;
	private JFrame signin;
	private JButton crea;
	private JButton accedi;
	private JPanel panel;
	private JPanel panel2;

	private JButton ann;

	private ActionListener clist;
	private ActionListener alist;
	
	Connection con;
	public PrimaryFrame(Connection connessione) {
		con=connessione; 
		
		class OkayButton implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createSignin();
			}
		}
		Icon i = new ImageIcon("cuore.gif");
		JLabel icon= new JLabel(i);
		icon.setLayout(new GridBagLayout());
		
		
		
		clist= new OkayButton();
		
		crea= new JButton("ACCEDI AL TUO ACCOUNT");
		crea.addActionListener(clist);
		
		setLayout(new BorderLayout());
		JPanel panel= new JPanel();
		panel.add(crea);
		
		add(panel, BorderLayout.SOUTH);
		add(icon, BorderLayout.CENTER);
		setSize(250,100);
		
	
			
		 
	}
	
	public void createSignin() {

		signin= new SignIn(con);
		signin.setSize(600,500);
		signin.setLocation(600,200);
		signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signin.setVisible(true);
		
		ImageIcon image= new ImageIcon("sito.png");		
		signin.setIconImage(image.getImage());
		
	}
	
}
