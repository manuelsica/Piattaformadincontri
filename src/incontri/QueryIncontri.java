package incontri;
import java.sql.*; 
import javax.swing.*; 
import java.util.*; 
import java.text.*; 


public class QueryIncontri {
	Statement st= null; 
	ResultSet rs= null; 
	Connection con; 
	
	public QueryIncontri(Connection connessione) {
		con=connessione;
	}
	
	private String query;
	public void queryUno(int id, JTextArea area) {
		//SELEZIONARE GLI UTENTI DI UNA DATO MATCH E DATA 
		try {	
			query= "SELECT nome, cognome, datamatch FROM match_ AS m, profilo AS p, fa AS f WHERE p.telefono=f.profilo AND m.id= ? AND m.id=f.match_"; 
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setInt(1, id);
			
			rs= ps.executeQuery(); 
			while(rs.next()) {
				String nome=rs.getString("nome"); 
				String cognome=rs.getString("cognome");
				java.sql.Date data=rs.getDate("datamatch"); 
				java.util.Date dateUtil= new java.util.Date(data.getTime()); 
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
				final String date = dateFormat.format(dateUtil); 
				area.append("Nome: " + nome +", cognome: " + cognome + ", data: " + date + "\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA" + e); 
		}
	}


	public void queryDue(int codiceinterazione, JTextArea area) {
		//LEGGERE L'ID DI UN MATCH LEGATO AD UN'INTERAZIONE
		try {
			query="SELECT s.match_ FROM  interazione as i, sblocca AS s WHERE i.codiceinterazione= ? AND s.interazione=i.codiceinterazione "; 
			PreparedStatement ps=con.prepareStatement(query); 
			ps.setInt(1, codiceinterazione);
			rs= ps.executeQuery();
			while(rs.next()) {
				int match=rs.getInt("s.match_"); 
				area.append("ID del match: " + match + ".\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryTre(long telefono, String email, String nome, String cognome, String genere, String date, String password, String orientamento, JTextArea area) {
		//INSERIMENTO PROFILO 
		try {
			query="INSERT INTO profilo(telefono, email, nome, cognome, password, genere, dataiscrizione, orientamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?) "; 
			PreparedStatement ps= con.prepareStatement(query); 
			java.sql.Date data=java.sql.Date.valueOf(date);
			ps.setLong(1,telefono);
			ps.setString(2, email); 
			ps.setString(3, nome); 
			ps.setString(4, cognome); 
			ps.setString(6, genere);
			ps.setDate(7, data); 
			ps.setString(5, password);
			ps.setString(8, orientamento);
			
			ps.execute();
			area.append("Operazione svolta con successo.\n"); 
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}

	
	public void queryQuattro(JTextArea area) {
		try {
		//SBLOCCO DI UN MATCH DA UN PROFILO CHE SI è ISCRITTO ALLA PIATTAFORMA IL 16.07.2020
			query= "SELECT m.id FROM match_ AS m, profilo AS p, fa AS f WHERE dataiscrizione=20200716 AND f.profilo=p.telefono AND m.id=f.match_ "; 
			Statement st= con.createStatement();
			rs=st.executeQuery(query); 

			while(rs.next()) {
				int match=rs.getInt("m.id"); 
				area.append("ID del match sbloccato: " + match + ".\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	 
	public void queryCinque(long telefono, JTextArea area) {
		//SELEZIONARE IL MOTIVO D'ISCRIZIONE DI UN UTENTE ALLA PIATTAFORMA
		try {
			query= "SELECT b.motivo FROM profilo AS p, bio AS b WHERE b.profilo=p.telefono AND p.telefono= ?"; 
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setLong(1, telefono);
			
			rs= ps.executeQuery(); 
			while(rs.next()) {
				String motivo=rs.getString("b.motivo"); 
				area.append("Motivo per cui si è iscritto: " + motivo + ".\n" );
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void querySei(long telefono, JTextArea area) {
		//visualizzare data sottoscrizione di un utente premium
		try {
			query= "SELECT datasottoscrizione FROM premium AS pm, profilo AS p WHERE pm.profilo=p.telefono AND p.telefono= ?"; 
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setLong(1, telefono);
			
			rs= ps.executeQuery(); 
			while(rs.next()) {
				java.sql.Date data=rs.getDate("datasottoscrizione"); 
				java.util.Date utilDate = new java.util.Date(data.getTime());
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String stringDate = dateFormat.format(utilDate);
				area.append("Data di sottoscrizione al servizio premium: " + stringDate + ".\n" ); 
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void querySette(long telefono, JTextArea area) {
		//selezionare il rate d'interesse e il numero di posto in classifica di un dato profilo premium
		try {
			query= "SELECT ratedinteresse, numero_posto FROM premium AS pm, profilo AS p, classifica as c, mi_piace as mp WHERE c.premium=mp.classifica and pm.profilo=mp.premium AND pm.profilo=p.telefono AND p.telefono= ?"; 
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setLong(1, telefono);
			
			rs= ps.executeQuery(); 
			while(rs.next()) {
				int ratedinteresse=rs.getInt("ratedinteresse");
				int n_posto=rs.getInt("numero_posto"); 
				area.append("Rate d'interesse: " + ratedinteresse + " e posto in classifica: " + n_posto + ".\n" );
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryOtto(JTextArea area) {
		try {
		//ETERO IN ORDINE DECRESCENTE
			query= "SELECT nome, cognome FROM profilo WHERE orientamento='etero' ORDER BY nome DESC"; 
			st= con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next()) {
				String nome=rs.getString("nome");
				String cognome=rs.getString("cognome");
				area.append("Nome: " + nome + "Cognome: " + cognome + ".\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryNove(JTextArea area) {
		//numero di match di tutti gli utenti
		try {
			query="SELECT nome, cognome, count(*) as c FROM profilo AS p WHERE EXISTS(SELECT * FROM fa, con WHERE fa.profilo=p.telefono OR con.profilo=p.telefono) GROUP BY p.telefono"; 
			Statement ps= con.createStatement(); 	
			rs= ps.executeQuery(query); 
			
			while(rs.next()) {
				String nome= rs.getString("nome");
				String cognome= rs.getString("cognome");
				int max=rs.getInt("c"); 
				area.append("Numero di match di"+ nome + " " + cognome +": "+max+ ".\n" );
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA: "+ e); 
		}
	}
	
	public void queryDieci(String password, long telefono, JTextArea area) {
		//modifica password di un profilo
		try {
			query="UPDATE profilo SET password= ? WHERE telefono= ? ";
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setString(1, password);
			ps.setLong(2, telefono);
			
			ps.execute();
			area.append("Operazione svolta con successo.\n"); 
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryUndici(long telefono, JTextArea area) {
		//SELEZIONA UN LIKE LASCIATO DA UN PROFILO CON L'EMAIL CHE COMINCIA CON L 
		try {
			query="Insert into mi_piace(profilo, premium, classifica,data_mi_piace,ratedinteresse) values(3465473334, ?, ?, 20220301, 50) ";  
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, telefono);
			ps.setLong(2, telefono);
			ps.execute();
			area.append("Operazione effettuata con successo. \n");
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryDodici(JTextArea area) {
		//selezionare utenti con gli stessi professione e donna 
		try {
			query="SELECT DISTINCT  nome, cognome FROM profilo AS p, bio AS b WHERE EXISTS( SELECT * FROM bio AS b1  WHERE b.professione=b1.professione) AND p.genere= 'Donna' GROUP BY b.professione  ";
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			while(rs.next()) {
				String nome=rs.getString("nome"); 
				String cognome=rs.getString("cognome");
				area.append("Nome: " + nome +" Cognome: " + cognome + ".\n");
			}
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryTredici(JTextArea area) {
		try {
		//selezionare tutti gli id match con data oltre il 15-5-2020
			query="SELECT id FROM match_ WHERE datamatch>2020515"; 
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
	
			while(rs.next()) {
				int match=rs.getInt("id"); 
				area.append("ID del match: " + match + ".\n");
			}

		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
		
	}
	
	public void queryQuattordici(JTextArea area) {
		try {
		//password ed email di tutti gli utenti normali
			query="SELECT MD5(password) AS password, email FROM profilo AS p, normale AS n WHERE n.profilo=p.telefono"; 
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			
			while(rs.next()) {
				String password=rs.getString("password"); 
				String email=rs.getString("email");
				area.append("Password: " + password + "e e-mail:" + email + ".\n");
			}
		
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
		
	}
	
	public void queryQuindici(String date, JTextArea area) {
		//CODICE INTERAZIONE ATTRAVERSO UNA DATA 
		try {
			query="SELECT codiceinterazione FROM match_ as m, interazione as i, sblocca as s WHERE datamatch= ? AND i.codiceinterazione=s.interazione AND m.id=s.match_";
			java.sql.Date data=java.sql.Date.valueOf(date);
			PreparedStatement ps= con.prepareStatement(query) ;
			ps.setDate(1,data);
			rs=ps.executeQuery(); 
			
			while(rs.next()) {
				int codice=rs.getInt("codiceinterazione"); 
				area.append("Codice interazione: " + codice + ".\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void querySedici(JTextArea area) {
		//selezionare il titolare di tutti i pagamenti che non ahnno circuito VISA
		try {
			query="SELECT p1.titolare FROM pagamento as p1 WHERE 'VISA' NOT IN(SELECT p2.circuito FROM pagamento as p2 WHERE p1.numero_carta = p2.numero_carta)";
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			 
			while(rs.next()) {
				String titolare=rs.getString("titolare"); 
				area.append("Titolare: " + titolare + ".\n");
			}
		 
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryDiciassette(JTextArea area) {
		//selezionare il testo di un'interazione sbloccata da un match non in data 25-12-2019
		try {
			query="SELECT testo_interazione FROM interazione as i, sblocca as s WHERE NOT EXISTs( SELECT * FROM match_ as m WHERE m.datamatch=2019-25-12) AND s.interazione=i.codiceinterazione" 
					;
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			
			while(rs.next()) {
				String testo=rs.getString("testo_interazione"); 
				area.append("Testo: " + testo + "\n");
			}
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryDiciotto(JTextArea area) {
		//i profili premium  ordinati per cognome che hanno avuto un posto nella classifica
		try {
			query="SELECT nome, cognome FROM profilo AS p, premium AS pm, classifica AS c WHERE c.premium=pm.profilo AND pm.profilo=p.telefono ORDER BY p.cognome ";
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			
			while(rs.next()) {
				String nome=rs.getString("nome"); 
				String cognome=rs.getString("cognome");
				area.append("Nome: " + nome +" Cognome: " + cognome + ".\n");
			}
						
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryDiciannove(long telefono, JTextArea area) {
		//lista dei like di un utente premium
		try {
			query="SELECT count(*) AS co FROM mi_piace as mp, premium AS pm WHERE pm.profilo= ? AND pm.profilo=mp.premium GROUP BY pm.profilo"
					;
			PreparedStatement ps= con.prepareStatement(query); 
			ps.setLong(1, telefono);
			
			rs= ps.executeQuery(); 
			while(rs.next()) {
				int count=rs.getInt("co"); 
				area.append("Numero di like: " + count + ".\n");
			}
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryVenti(JTextArea area) {
		//utenti maschili raggruppati per tipo di orientamento che hanno postato almeno una foto 
		try {
			query="SELECT nome, cognome FROM profilo AS p WHERE p.genere='Uomo' AND EXISTS(SELECT * FROM foto as f WHERE f.profilo=p.telefono) GROUP BY p.orientamento";
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			 
			while(rs.next()) {
				String nome=rs.getString("nome"); 
				String cognome=rs.getString("cognome");
				area.append("Nome: " + nome +" Cognome: " + cognome + ".\n");
			}
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryVentuno(JTextArea area) {
		try {
			query="SELECT motivo, count(*) as c FROM bio as b GROUP BY motivo";
			st= con.createStatement(); 
			rs=st.executeQuery(query); 
			 
			while(rs.next()) {
				String nome=rs.getString("motivo"); 
				int cognome=rs.getInt("c");
				area.append("Motivo: " + nome +" e persone: " + cognome + ".\n");
			}
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
	
	public void queryVentidue(long telefono, JTextArea area) {
		try {
			query="SELECT DISTINCT p.nome, p.cognome FROM con, fa, profilo as p WHERE p.telefono= ? and con.profilo=p.telefono and p.telefono NOT IN(SELECT p1.telefono FROM profilo as p1, match_ as m WHERE fa.profilo=p1.telefono and con.match_=fa.match_ and m.id=fa.match_)";
			PreparedStatement ps= con.prepareStatement(query); 
			
			ps.setLong(1, telefono); 
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nome=rs.getString("p.nome"); 
				String cognome=rs.getString("p.cognome");
				area.append("Nome: " + nome +" Cognome: " + cognome + ".\n");
			}
			
		}catch(SQLException e) {
			System.out.println("PROBLEMA"+ e); 
		}
	}
}