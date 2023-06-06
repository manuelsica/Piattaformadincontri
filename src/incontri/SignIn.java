package incontri;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Locale;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class SignIn extends JFrame {
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton ten;
	private JButton eleven;
	private JButton twelve;
	private JButton thirteen;
	private JButton fourteen;
	private JButton fifteen;
	private JButton sixteen;
	private JButton seventeen;
	private JButton eighteen;
	private JButton nineteen;
	private JButton twenty;
	private JButton twentyone;
	private JButton twentytwo;
	private ActionListener button1;
	private ActionListener button2;
	private ActionListener button3;
	private ActionListener button4;
	private ActionListener button5;
	private ActionListener button6;
	private ActionListener button7;
	private ActionListener button8;
	private ActionListener button9;
	private ActionListener button10;
	private ActionListener button11;
	private ActionListener button12;
	private ActionListener button13;
	private ActionListener button14;
	private ActionListener button15;
	private ActionListener button16;
	private ActionListener button17;
	private ActionListener button18;
	private ActionListener button19;
	private ActionListener button20;
	private ActionListener button22;
	private ActionListener button21;
	private JFrame input;
	private JTextArea area;
	private JTextField a;
	private JLabel txt;
	private JPanel panel;
	private ActionListener lst;
	private JFrame id;
	private JFrame pas;
	private JTextField a1;
	private JTextField a2;
	private JTextField a3;
	private JTextField a4;
	private JTextField a5;
	private JTextField a6;
	private JTextField a7;
	private JTextField a8;
	private JLabel txt1;
	private JLabel txt2;
	private JLabel txt3;
	private JLabel txt4;
	private JLabel txt5;
	private JLabel txt6;
	private JLabel txt7;
	private JLabel txt8;
	private JFrame tab;
	private JFrame cdl;
	private JFrame dat;
	private JFrame in11;
	private QueryIncontri qr;
	private JFrame vgm;
	private JFrame dat2;

	Connection con;
	
	public SignIn(Connection cn) {
		con=cn;
		qr=new QueryIncontri(con);
		
		
	JPanel dx= new JPanel();
	JPanel sx = new JPanel();
	area= new JTextArea();

	
		class Button1 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP1: Selezionare gli utenti di un dato match e data\n");
				id= new Id();
				id.setSize(600,200);
				id.setTitle("OPERAZIONE 1");
				id.setLocation(400,100);
				id.setVisible(true);
				
				ImageIcon image= new ImageIcon("sito.png");		
				id.setIconImage(image.getImage());
				
			}
		}
		
		class Button2 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP2: Leggere l'ID di un match da un'iterazione\n");
				vgm= new Vgm();
				vgm.setSize(400,200);
				vgm.setTitle("OPERAZIONE 2");
				vgm.setLocation(400,100);
				vgm.setVisible(true);
				
				ImageIcon image= new ImageIcon("sito.png");		
				vgm.setIconImage(image.getImage());
			}
		}

		class Button3 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP3: Creazione di un nuovo profilo\n");
				tab= new Table();
				tab.setSize(400,350);
				tab.setTitle("OPERAZIONE 3");
				tab.setLocation(400,100);
				tab.setVisible(true);
				
				ImageIcon image= new ImageIcon("sito.png");		
				tab.setIconImage(image.getImage());
			}
		}

		class Button4 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP4: Sbloccamento di un match da un profilo che si e' iscritto alla piattafroma il 16/7/2020");
				qr.queryQuattro(area);

			}
		}

		class Button5 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP5: Selezionare il motivo di iscrizione di un utente alla piattaforma\n");
				input= new InputTelefono1();
				input.setSize(400,200);
				input.setTitle("OPERAZIONE 5");
				input.setLocation(400,100);
				input.setVisible(true);
				
				ImageIcon image= new ImageIcon("sito.png");		
				input.setIconImage(image.getImage());
			}
		}

		class Button6 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP6: Visualizzare data sottoscrizione di un utente premium\n");
				input= new InputTelefono6();
				input.setSize(400,200);
				input.setTitle("OPERAZIONE 6");
				input.setLocation(400,100);
				input.setVisible(true);
	
				
				ImageIcon image= new ImageIcon("sito.png");		
				input.setIconImage(image.getImage());
			}
		}

		class Button7 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP7: Selezionare rate d'interesse e numero di posto in classifica di un profilo utente\n");
				input= new InputTelefono7();
				input.setSize(400,200);
				input.setTitle("OPERAZIONE 7");
				input.setLocation(400,100);
				input.setVisible(true);
				
				
				ImageIcon image= new ImageIcon("sito.png");		
				input.setIconImage(image.getImage());
			}
		}

		class Button8 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP8: Profili raggruppati per nome in senso decrescente che hanno orientamento 'Eterosessuale' \n");
				qr.queryOtto(area);
			}
		}

		class Button9 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP9: Lettura dei numeri di match di tutti gli utenti della piattaforma\n");
				qr.queryNove(area);
			}
		}

		class Button10 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP10: Modifica password di un profilo\n");
				pas= new Pas();
				pas.setSize(400,400);
				pas.setTitle("OPERAZIONE 10");
				pas.setLocation(400,100);
				pas.setVisible(true);
				
				
				ImageIcon image= new ImageIcon("sito.png");		
				pas.setIconImage(image.getImage());
				
			}
		}

		class Button11 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP11: Inserimento di un like lasciato da un profilo con una e-mail che inizia con 'L'\n");
				in11= new InputTelefono11();
				in11.setSize(400,400);
				in11.setTitle("OPERAZIONE 11");
				in11.setLocation(400,100);
				in11.setVisible(true);
				
				
				ImageIcon image= new ImageIcon("sito.png");		
				in11.setIconImage(image.getImage());
			}
		}

		class Button12 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP12: Selezionare utenti con stessi interessi e che hanno impostato il loro genere a 'Donna'\n");
				qr.queryDodici(area);
			}
		}

		class Button13 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP13: Selezionare tutti gli ID match con data oltre il 15/03/2020\n");
				qr.queryTredici(area);
			}
		}

		class Button14 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP14: Password ed e-mail di tutti gli utenti normali\n");
				qr.queryQuattordici(area);
			}
		}

		class Button15 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP15: Trovare codice interazione di una particolare data\n");
				dat2= new Dat2();
				dat2.setSize(400,200);
				dat2.setTitle("OPERAZIONE 15");
				dat2.setLocation(400,100);
				dat2.setVisible(true);
				
				
				ImageIcon image= new ImageIcon("sito.png");		
				dat2.setIconImage(image.getImage());
			}
		}

		class Button16 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP16: Selezionare il titolare di utti i pagamenti che non hanno circuito VISA\n");
				qr.querySedici(area);
			}
		}

		class Button17 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP17: Selezionare il testo di un'interazione sbloccata da un match NON in data 25/12/2019\n");
				qr.queryDiciassette(area);
			}
		}

		class Button18 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP18: Profili premium ordinati per cognome \n");
				qr.queryDiciotto(area);
			}
		}

		class Button19 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP19: Numero dei like ricevuti da un utente premium\n");
				input= new InputTelefono19();
				input.setSize(400,200);
				input.setTitle("OPERAZIONE 19");
				input.setLocation(400,100);
				input.setVisible(true);
				
				ImageIcon image= new ImageIcon("sito.png");		
				input.setIconImage(image.getImage());
			}
		}

		class Button20 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP20: Utenti di genere maschile raggruppati per orientamento e che hanno almeno 4 foto\n");
				qr.queryVenti(area);
			}
		}
		
		class Button21 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP21: Numero di utenti con stesse motivazioni");
				qr.queryVentuno(area);
			}
		}
		
		class Button22 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("OP22: Profilo che non hanno effettuato un match con un dato profilo\n");
				dat2= new InputTelefono22();
				dat2.setSize(400,200);
				dat2.setTitle("OPERAZIONE 22");
				dat2.setLocation(400,100);
				dat2.setVisible(true);
				
				
				ImageIcon image= new ImageIcon("sito.png");		
				dat2.setIconImage(image.getImage());
			}
		}
	
		
	button1= new Button1();
	button2= new Button2();
	button3= new Button3();
	button4= new Button4();
	button5= new Button5();
	button6= new Button6();
	button7= new Button7();
	button8= new Button8();
	button9= new Button9();
	button10= new Button10();
	button11= new Button11();
	button12= new Button12();
	button13= new Button13();
	button14= new Button14();
	button15= new Button15();
	button16= new Button16();
	button17= new Button17();
	button18= new Button18();
	button19= new Button19();
	button20= new Button20();
	button21= new Button21();
	button22= new Button22();
	
	one= new JButton("Operazione 1");
	one.addActionListener(button1);
	two= new JButton("Operazione 2");
	two.addActionListener(button2);
	three= new JButton("Operazione 3");
	three.addActionListener(button3);
	four= new JButton("Operazione 4");
	four.addActionListener(button4);
	five= new JButton("Operazione 5");
	five.addActionListener(button5);
	six= new JButton("Operazione 6");
	six.addActionListener(button6);
	seven= new JButton("Operazione 7");
	seven.addActionListener(button7);
	eight= new JButton("Operazione 8");
	eight.addActionListener(button8);
	nine= new JButton("Operazione 9");
	nine.addActionListener(button9);
	ten= new JButton("Operazione 10");
	ten.addActionListener(button10);
	eleven= new JButton("Operazione 11");
	eleven.addActionListener(button11);
	twelve= new JButton("Operazione 12");
	twelve.addActionListener(button12);
	thirteen= new JButton("Operazione 13");
	thirteen.addActionListener(button13);
	fourteen= new JButton("Operazione 14");
	fourteen.addActionListener(button14);
	fifteen= new JButton("Operazione 15");
	fifteen.addActionListener(button15);
	sixteen= new JButton("Operazione 16");
	sixteen.addActionListener(button16);
	seventeen= new JButton("Operazione 17");
	seventeen.addActionListener(button17);
	eighteen= new JButton("Operazione 18");
	eighteen.addActionListener(button18);
	nineteen= new JButton("Operazione 19");
	nineteen.addActionListener(button19);
	twenty= new JButton("Operazione 20");
	twenty.addActionListener(button20);
	twentyone= new JButton("Operazione 21");
	twentyone.addActionListener(button21);
	twentytwo= new JButton("Operazione 22");
	twentytwo.addActionListener(button22);
	
	sx.add(one);
	sx.add(two);
	sx.add(three);
	sx.add(four);
	sx.add(five);
	sx.add(six);
	sx.add(seven);
	sx.add(eight);
	sx.add(nine);
	sx.add(ten);
	
	sx.add(eleven);
	dx.add(twelve);
	dx.add(thirteen);
	dx.add(fourteen);
	dx.add(fifteen);
	dx.add(sixteen);
	dx.add(seventeen);
	dx.add(eighteen);
	dx.add(nineteen);
	dx.add(twenty);
	dx.add(twentyone);
	dx.add(twentytwo);
	
	
	setLayout(new BorderLayout());	
	sx.setLayout(new GridLayout(11,1));
	dx.setLayout(new GridLayout(11,1));
	add(dx, BorderLayout.EAST);
	add(sx, BorderLayout.WEST);
	add(area, BorderLayout.CENTER);
	
	

	}
	
	public class Id extends JFrame {
		public Id() {
			qr=new QueryIncontri(con);
			a = new JTextField(10);
			txt = new JLabel("ID Match: ");
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					int id=Integer.parseInt(a.getText());
					qr.queryUno(id, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			

			add(panel);

			
		}
	}
public class InputTelefono11 extends JFrame {
		
		public InputTelefono11() {
			qr=new QueryIncontri(con);
			a = new JTextField(20);
			txt = new JLabel("Telefono: ");
			txt.getText();
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					long tel=Long.parseLong(a.getText());
					qr.queryUndici(tel, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			
			add(panel);
			
		}
	}

public class InputTelefono7 extends JFrame {
		
		public InputTelefono7() {
			qr=new QueryIncontri(con);
			a = new JTextField(20);
			txt = new JLabel("Telefono: ");
			txt.getText();
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					long tel=Long.parseLong(a.getText());
					qr.querySette(tel, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			
			add(panel);
			
		}
	}
	
	public class Table extends JFrame{
		public Table() {
			qr=new QueryIncontri(con);
			a1 = new JTextField(10);
			a2 = new JTextField(10);
			a3 = new JTextField(10);
			a4 = new JTextField(10);
			a5 = new JTextField(10);
			a6 = new JTextField(10);
			a7 = new JTextField(10);
			a8 = new JTextField(10);
			
			txt1 = new JLabel("Telefono: ");
			txt2 = new JLabel("E-Mail: ");
			txt3 = new JLabel("Nome: ");
			txt4 = new JLabel("Cognome: ");
			txt5 = new JLabel("Genere: ");
			txt6 = new JLabel("Data: ");
			txt7 = new JLabel("Password: ");
			txt8 = new JLabel("Orientamento: ");
			
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					long tel=Long.parseLong(a1.getText());
					String mail= a2.getText();
					String nome=a3.getText();
					String cognome= a4.getText();
					String genere= a5.getText();
					String data = a6.getText();
					String pass= a7.getText();
					String orientamento= a8.getText();
					qr.queryTre(tel, mail, nome, cognome, genere, data, pass, orientamento, area);
					setVisible(false);
				}
			}
			lst= new Lst();		
			
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.setLayout(new BorderLayout());
			JPanel text= new JPanel();
			JPanel ss= new JPanel();
			text.setLayout(new GridLayout(9,1));
			ss.setLayout(new GridLayout(9,1));
			
			
			text.add(txt1);
			ss.add(a1);
			text.add(txt2);
			ss.add(a2);
			text.add(txt3);
			ss.add(a3);
			text.add(txt4);
			ss.add(a4);			
			text.add(txt5);
			ss.add(a5);			
			text.add(txt6);
			ss.add(a6);
			text.add(txt7);
			ss.add(a7);
			text.add(txt8);
			ss.add(a8);
			ss.add(but);
			
			panel.add(text, BorderLayout.WEST);
			panel.add(ss, BorderLayout.CENTER);
			
			JPanel pan= new JPanel();
			pan.add(panel);
			
			add(pan);
			
		}
	}
public class InputTelefono22 extends JFrame {
		
		public InputTelefono22() {
			qr=new QueryIncontri(con);
			a = new JTextField(20);
			txt = new JLabel("Telefono: ");
			txt.getText();
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					long tel=Long.parseLong(a.getText());
					qr.queryVentidue(tel, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			
			add(panel);
			
		}
	}
public class InputTelefono19 extends JFrame {
	
	public InputTelefono19() {
		qr=new QueryIncontri(con);
		a = new JTextField(20);
		txt = new JLabel("Telefono: ");
		txt.getText();
		
		class Lst implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				long tel=Long.parseLong(a.getText());
				qr.queryDiciannove(tel, area);
				setVisible(false);
			}
		}
		lst= new Lst();
		
		JButton but= new JButton("Avanti");
		but.addActionListener(lst);
		
		
		panel= new JPanel();
		panel.add(txt);
		panel.add(a);
		panel.add(but);
		
		add(panel);
		
	}
}
	
	public class Cdl extends JFrame{
		public Cdl() {
			qr=new QueryIncontri(con);
			a1 = new JTextField(10);
			a2 = new JTextField(10);
			a3 = new JTextField(10);
			
			txt1 = new JLabel("ID Match: ");
			txt2 = new JLabel("Data: ");
			txt3 = new JLabel("Numero Di Match: ");		
			
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					int id=Integer.parseInt(a1.getText());
					String data=a2.getText();
					int num= Integer.parseInt(a3.getText());
					qr.queryOtto(area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.setLayout(new BorderLayout());
			
			JPanel p= new JPanel();
			JPanel t= new JPanel();
			
			p.setLayout(new GridLayout(4,1));
			t.setLayout(new GridLayout(4,1));
			p.add(txt1);
			t.add(a1);
			p.add(txt2);
			t.add(a2);
			p.add(txt3);
			t.add(a3);
			t.add(but);
			
			panel.add(p, BorderLayout.WEST);
			panel.add(t, BorderLayout.CENTER);
			JPanel pan= new JPanel();
			pan.add(panel);
			
			
			add(pan);
			
			
			
		}
	}
	public class Pas extends JFrame{
		public Pas() {
			qr=new QueryIncontri(con);
			a1 = new JTextField(10);
			a2 = new JTextField(10);
			txt1 = new JLabel("Password: ");
			txt2 = new JLabel("Telefono: ");
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					String pass=a1.getText();
					long tel=Long.parseLong(a2.getText());
					qr.queryDieci(pass, tel, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.setLayout(new BorderLayout());
			
			JPanel p= new JPanel();
			JPanel t= new JPanel();
			
			p.setLayout(new GridLayout(3,1));
			t.setLayout(new GridLayout(3,1));
			p.add(txt1);
			t.add(a1);
			p.add(txt2);
			t.add(a2);
			t.add(but);
			
			panel.add(p, BorderLayout.WEST);
			panel.add(t, BorderLayout.CENTER);	
			
			JPanel pan= new JPanel();
			pan.add(panel);
			
			add(pan);
			
		}
		
	}
	
	public class Dat extends JFrame{
		public Dat() {
			qr=new QueryIncontri(con);
			a1 = new JTextField(10);
			txt1 = new JLabel("Data: ");
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					String data =a1.getText();
					qr.queryQuindici(data, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			

			panel.add(txt1);
			panel.add(a1);
			panel.add(but);
		    add(panel);
			
		}
	}
public class Vgm extends JFrame {
		
		public Vgm() {
			qr=new QueryIncontri(con);
			a = new JTextField(20);
			txt = new JLabel("Codice Interazione: ");
			txt.getText();
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					int cd=Integer.parseInt(a.getText());
					qr.queryDue(cd, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			
			add(panel);
			
		}
	}
	public class InputTelefono1 extends JFrame {
	
	public InputTelefono1() {
		qr=new QueryIncontri(con);
		a = new JTextField(20);
		txt = new JLabel("Telefono: ");
		txt.getText();
		
		class Lst implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				long tel=Long.parseLong(a.getText());
				qr.queryCinque(tel, area);
				setVisible(false);
			}
		}
		lst= new Lst();
		
		JButton but= new JButton("Avanti");
		but.addActionListener(lst);
		
		
		panel= new JPanel();
		panel.add(txt);
		panel.add(a);
		panel.add(but);
		
		add(panel);
		
	}
}
public class InputTelefono6 extends JFrame {
		
		public InputTelefono6() {
			qr=new QueryIncontri(con);
			a = new JTextField(20);
			txt = new JLabel("Telefono: ");
			txt.getText();
			
			class Lst implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					long tel=Long.parseLong(a.getText());
					qr.querySei(tel, area);
					setVisible(false);
				}
			}
			lst= new Lst();
			
			JButton but= new JButton("Avanti");
			but.addActionListener(lst);
			
			
			panel= new JPanel();
			panel.add(txt);
			panel.add(a);
			panel.add(but);
			
			add(panel);
			
		}
	}
public class Dat2 extends JFrame{
	public Dat2() {
		qr=new QueryIncontri(con);
		a1 = new JTextField(10);
		txt1 = new JLabel("Data: ");
		
		class Lst implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String data =a1.getText();
				qr.queryQuindici(data,area);
				setVisible(false);
			}
		}
		lst= new Lst();
		
		JButton but= new JButton("Avanti");
		but.addActionListener(lst);
		
		
		panel= new JPanel();
		

		panel.add(txt1);
		panel.add(a1);
		panel.add(but);
	    add(panel);
		
	}
}

}