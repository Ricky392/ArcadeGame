package bin;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class Arcade{
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
		btnTetris = new JButton("Tetris");

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

		//Rende visibile l'Interfaccia.
		frame.setVisible(true);

		//Assegno actionlistener ai pulsanti
		//btnTetris.addActionListener(new Clic());
		//btnPong.addActionListener(new Clic());

		//Chiude l'Interfaccia.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Metodi
	class Clic implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String caption = e.getActionCommand();

			//imporante capire cosa c'è dentro caption

			//System.out.println("stringa: "+caption);
			//Ascoltatore Gioco 1
			if(caption.equals("Tetris")){
				//System.out.println("Premuto gioco 1, Tetris");
			}

			//Ascoltatore Gioco 2
			if(caption.equals("Pong")){
				//System.out.println("Premuto gioco 2");
			}
		}
	}

	//Main
	public static void main(String[] args){
		//Creazione dei Bottoni inerente al Sistema Operativo
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Creazione Classe Arcade.
		System.out.println("Prova");
		Arcade a = new Arcade();
	}
}
