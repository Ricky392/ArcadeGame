import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Arcade {
	//Attributi
		JFrame frame;
		
		JPanel pnlNorth; //Pannello Arcade.
		JPanel pnlCenter; //Pannello Giochi.
		JPanel pnlCenterNorth; //Pannello Gioco 1 (PONG).
		JPanel pnlCenterSouth; //Pannello Gioco 2 (TETRIS).
		JPanel pnlWest; //Pannello Timer.
		JPanel pnlSouth; //Pannello Creatori,
		
		JLabel lblArcade; //Etichetta Arcade.
		JLabel lblPong; //Etichetta Gioco 1 (PONG).
		JLabel lblTetris; //Etichetta Tetris (TETRIS).
		JLabel lblNGiocatore1; //Etichetta Nome Primo Giocatore Gioco 1 (PONG).
		JLabel lblNGiocatore2; //Etichetta Nome Secondo Giocatore Gioco 1 (PONG).
		JLabel lblNGiocatore; //Etichetta Nome Giocatore Gioco 2 (TETRIS).
		JLabel lblCreatori; //Etichetta Creatori Arcade.
		
		JButton btnPong; //Bottone Gioco 1 (PONG).
		JButton btnTetris; //Bottone Gioco 2 (TETRIS).
		
		JTextField txtNGiocatore1; //Campo del Nome Giocatore 1 (PONG).
		JTextField txtNGiocatore2; //Campo del Nome Giocatore 2 (PONG).
		JTextField txtNGiocatore; //Campo del Nome Giocatore (TETRIS).
		
		//Costruttore
		Arcade(){
			//Creazione Frame.
			frame = new JFrame("Arcade");
			//Imposta Dimensione Frame.
			frame.setSize(500,500);
			//Imposta Colore Frame.
			Color prova = new Color(0,128,255);
			frame.setBackground(prova);
			//Imposta Posizione del Frame.
			frame.setLocation(100,100);
			
			//Creazione Pannelli.
			pnlNorth = new JPanel();
			pnlCenter = new JPanel();
			pnlCenterNorth = new JPanel();
			pnlCenterSouth = new JPanel();
			pnlWest = new JPanel();
			pnlSouth = new JPanel();
			
			//Creazione Etichette.
			lblArcade = new JLabel("ARCADE");
			lblArcade.setFont(new Font("ALGERIAN", Font.PLAIN, 50));
			lblPong = new JLabel("GIOCO 1", JLabel.LEFT);
			lblPong.setFont(new Font("IMPACT", Font.PLAIN, 20));
			lblTetris = new JLabel("GIOCO 2", JLabel.LEFT);
			lblTetris.setFont(new Font("IMPACT", Font.PLAIN, 20));
			lblNGiocatore1 = new JLabel("Nome Giocatore 1:", JLabel.CENTER);
			lblNGiocatore1.setFont(new Font("IMPACT",Font.PLAIN, 15));
			lblNGiocatore2 = new JLabel("Nome Giocatore 2:", JLabel.CENTER);
			lblNGiocatore2.setFont(new Font("IMPACT",Font.PLAIN, 15));
			lblNGiocatore = new JLabel("Nome Giocatore:", JLabel.CENTER);
			lblNGiocatore.setFont(new Font("IMPACT",Font.PLAIN, 15));
			lblCreatori = new JLabel("Creato da: Giannelli, Parisi, Soardi, Zambrano", JLabel.CENTER);
			lblCreatori.setFont(new Font("SANSSERIF BLOD",Font.PLAIN,20));
			
			//Creazione Bottoni.
			btnPong = new JButton("Pong");
			btnPong.setFont(new Font("Algerian", Font.PLAIN, 30));
			btnTetris = new JButton("Tetris");
			btnTetris.setFont(new Font("Algerian", Font.PLAIN, 30));
			//btnTetris.setBackground(bg);
			
			//Creazione Campi di Testo.
			txtNGiocatore1 = new JTextField();
			txtNGiocatore2 = new JTextField();
			txtNGiocatore = new JTextField();
			
			//Creazione Layout.
			frame.setLayout(new BorderLayout());
			
			//Posizionamento Pannelli nel Layout.
			frame.add(pnlNorth,BorderLayout.NORTH);
			frame.add(pnlCenter,BorderLayout.CENTER);
			frame.add(pnlWest,BorderLayout.WEST);
			frame.add(pnlSouth,BorderLayout.SOUTH);
			
			//Aggiunta Etichetta Arcade.
			pnlNorth.add(lblArcade);
			
			//Disposizione Pannello Giochi.
			pnlCenter.setLayout(new GridLayout(2,1));
			
			//Aggiunta Pannello Gioco 1 (PONG).
			pnlCenter.add(pnlCenterNorth);
			//Disposizione Pannello Gioco 1 (PONG).
			pnlCenterNorth.setLayout(new GridLayout(2,3));
			//Aggiunta Etichette e Campi Gioco 1 (PONG).
			pnlCenterNorth.add(lblPong);
			pnlCenterNorth.add(lblNGiocatore1);
			pnlCenterNorth.add(txtNGiocatore2);
			pnlCenterNorth.add(btnPong);
			pnlCenterNorth.add(lblNGiocatore2);
			pnlCenterNorth.add(txtNGiocatore1);
			
			//Aggiunta Pannello Gioco 2 (TETRIS).
			pnlCenter.add(pnlCenterSouth);
			//Disposizione Pannello Gioco 2 (TETRIS).
			pnlCenterSouth.setLayout(new GridLayout(2,3));
			//Aggiunta Etichette e Campi Gioco 2 (TETRIS).
			pnlCenterSouth.add(lblTetris);
			pnlCenterSouth.add(lblNGiocatore);
			pnlCenterSouth.add(btnTetris);
			pnlCenterSouth.add(txtNGiocatore);
			
			//Aggiunta Etichetta Creatori Arcade
			pnlSouth.add(lblCreatori);
			
			//Costruttore Classe Tetris
			/*btnTetris.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					Tetris game= new Tetris();
					game.start();
				}
			});
			*/
			//Rende visibile l'Interfaccia.
			frame.setVisible(true);
			
			//Chiude l'Interfaccia.
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//Metodi
		/*class Clic implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String caption = e.getActionCommand();
				
				//Ascoltatore Gioco 1
				if(caption.equals("Gioco 1"){
					
				}
				
				//Ascoltatore Gioco 2
				if(caption.equals("Gioco 2"){
					
				}
			}
		}*/
		
		//Main
		public static void main(String[] arg){
			//Creazione dei Bottoni inerente al Sistema Operativo
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//Creazione Classe Arcade.
			Arcade a = new Arcade();
		}
}