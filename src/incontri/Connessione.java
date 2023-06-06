package incontri; 
import java.sql.*;
import javax.swing.*; 
import incontri.PrimaryFrame;

public class Connessione {
		public static void main(String[] args) throws Exception{
			Connection con;
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/incontri"; 
			con= DriverManager.getConnection(url, "root", "123stella"); 
			System.out.println("OK");
			Interfaccia(con); 
			}catch(ClassNotFoundException e1){
				System.out.println("Driver not found"); 
				System.out.println(e1); 
			}catch(Exception e){
				System.out.println("Failed connection"); 
				System.out.println(e); 				
			}
		}	
		
		public static void Interfaccia(Connection con){
			JFrame frame= new PrimaryFrame(con);
			frame.setTitle("PIATTAFORMA DI INCONTRI");
			frame.setLocation(550,300);
			frame.setSize(400,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			frame.setVisible(true);
			
			ImageIcon image= new ImageIcon("sito.png");		
			frame.setIconImage(image.getImage());
			
		}
		/*
		 public static void closeAll() {
			 con.close(): 
			 ps.close(); 
			 rs.close();
		 }*/
	}
