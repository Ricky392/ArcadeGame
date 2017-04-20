package bin;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;

public class Pong extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;

	//Attributi
	//Posizioni di X e Y della palla

	private int pallaX = 10;
	private int pallaY = 100;

	//Posizione di X e Y del giocatore 1
	private int giocatore1X = 10;
	private int giocatore1Y = 100;

	//Posizione di X e Y del giocatore 2
	private int giocatore2X = 230;
	private int giocatore2Y = 100;

	private Thread hilo;

	private int destra = 5;
	private int sinistra = -5;
	private int su = 5;
	private int giu = -5;
	private int larghezza;
	private int altezza;

	//Punteggio
	private int contPlay1 = -1;
	private int contPlay2 = -1;

	private boolean player1FlagArr;
	private boolean player1FlagAba;
	private boolean player2FlagArr;
	private boolean player2FlagAba;
	private boolean gioco = false;
	private boolean gameOver;

	public Pong(){
		gioco=true;
		System.out.println("Inizio Pong");
		Thread hilo = new Thread(this);
		hilo.start();
	}

	// Draw ball and ships
	public void paintComponent(Graphics gc){
		setOpaque(false);
		super.paintComponent(gc);

		//Disegno della palla
		gc.setColor(Color.black);
		gc.fillOval(pallaX, pallaY, 8,8);

		//Disegno delle barre
		gc.fillRect(giocatore1X, giocatore1Y, 10, 25);
		gc.fillRect(giocatore1X, giocatore1Y, 10, 25);

		gc.fillRect(giocatore2X, giocatore2Y, 10, 25);
		gc.fillRect(giocatore2X, giocatore2Y, 10, 25);

		//Draw scores
		gc.drawString("CASA: "+contPlay1, 25, 10);
		gc.drawString("TRASFERTA: "+contPlay2, 150, 10);

		if(gameOver)
			gc.drawString("GAME OVER", 100, 125);
	}

	// Positions on X and Y for the ball
	public void dibujarPelota (int nx, int ny){
		pallaX= nx;
		pallaY= ny;
		this.larghezza=this.getWidth();
		this.altezza=this.getHeight();
		repaint();
	}


	// Move player 1
	public void moverPlayer1(){
		if(player1FlagArr == true && giocatore1Y >= 0)
			giocatore1Y += giu;
		if(player1FlagAba == true && giocatore1Y <= (this.getHeight()-25))
			giocatore1Y += su;
		dibujarPlayer1(giocatore1X, giocatore1Y);
	}

	// Move player 2
	public void moverPlayer2(){
		if(player2FlagArr == true && giocatore2Y >= 0)
			giocatore2Y += giu;
		if (player2FlagAba == true && giocatore2Y <= (this.getHeight()-25))
		giocatore2Y += su;
		dibujarPlayer2(giocatore2X, giocatore2Y);
	}

	// Position on Y for the player 1
	public void dibujarPlayer1(int x, int y){
		this.giocatore1X = x;
		this.giocatore1Y = y;
		repaint();
	}

	// Position on Y for the player 2
	public void dibujarPlayer2(int x, int y){
		this.giocatore2X = x;
		this.giocatore2Y = y;
		repaint();
	}

	public void run(){
	// TODO Auto-generated method stub
	JFrame frame = new JFrame("Pong");
	frame.setSize(250,250);
	frame.setVisible(true);
	frame.setLocation(100,100);
	frame.add(this);
	System.out.println("inizio tread pong");

	boolean izqDer=false;
	boolean arrAba=false;

	frame.addKeyListener(new KeyListener(){
		public void keyTyped(KeyEvent e){}
		// Here we receive from the game container class the key pressed
		public void keyPressed(KeyEvent evt){
			switch(evt.getKeyCode()){

			// Move ship 1
			case KeyEvent.VK_W :
			player1FlagArr = true;
			moverPlayer1();
			break;
			case KeyEvent.VK_S :
			player1FlagAba = true;
			moverPlayer1();
			break;

			// Move ship 2
			case KeyEvent.VK_UP:
			player2FlagArr=true;
			moverPlayer2();
			break;
			case KeyEvent.VK_DOWN:
			player2FlagAba=true;
			moverPlayer2();
			break;
			}
		}

		// Here we receive from the game container class the key released
		public void keyReleased(KeyEvent evt)
		{
		switch(evt.getKeyCode())
		{
		// Mover Nave1
		case KeyEvent.VK_W :
		player1FlagArr = false;
		break;
		case KeyEvent.VK_S :
		player1FlagAba = false;
		break;

		// Mover nave 2
		case KeyEvent.VK_UP:
		player2FlagArr=false;
		break;
		case KeyEvent.VK_DOWN:
		player2FlagAba=false;
		break;
		}
	}
	});

	while(true){
		if(gioco){
			//La palla va da sinistra verso destra
			if (izqDer){
				pallaX += destra;
				if (pallaX >= (larghezza - 8))
					izqDer= false;
		}
		else{
			//a sinistra
		pallaX += sinistra;
		if(pallaX <= 0)
			izqDer = true;
		}


		//La palla si muove dall'alto verso il basso
		if(arrAba){
			//su
			pallaY += su;
			if (pallaY >= (altezza - 8))
				arrAba= false;
		}
		else{
			//gi�
			pallaY += giu;
			if (pallaY <= 0)
				arrAba = true;
		}
		dibujarPelota(pallaX, pallaY);

	//Ritardo
	try{
		Thread.sleep(50);
	}
	catch(InterruptedException ex){}

	// The score of the player 1 increase
	if(pallaX >= (larghezza - 8))
		contPlay1++;

	// The score of the player 2 increase
	if(pallaX == 0)
		contPlay2++;

	// Game over. Here you can change 6 to any value
	// When the score reach to the value, the game will end
	if(contPlay1 == 6 || contPlay2 == 6){
		gioco = false;
		gameOver = true;
	}

	// The ball stroke with the player 1
	if(pallaX == giocatore1X+10 && pallaY >= giocatore1Y && pallaY <= (giocatore1Y+25))
		izqDer=true;

	// The ball stroke with the player 2
	if(pallaX == (giocatore2X-5) && pallaY >= giocatore2Y && pallaY <= (giocatore2Y+25))
		izqDer=false;
	}
	}
	}

	/*public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			Pong p = new Pong();
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p.setVisible(true);
		}
		});
	}*/
}
