package bin;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Pong extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;

	//Attributi
	//Posizioni di X e Y della palla
	int pallaX = 10;
	int pallaY = 100;

	//Posizione di X e Y del giocatore 1
	int giocatore1X = 10;
	int giocatore1Y = 100;

	//Posizione di X e Y del giocatore 2
	int giocatore2X = 230;
	int giocatore2Y = 100;

	Thread hilo;

	int destra = 5;
	int sinistra = -5;
	int su = 5;
	int giu = -5;
	int larghezza;
	int altezza;

	//Punteggio
	int contPlay1 = -1;
	int contPlay2 = -1;

	boolean player1FlagArr;
	boolean player1FlagAba;
	boolean player2FlagArr;
	boolean player2FlagAba;
	boolean gioco;
	boolean gameOver;

	public Pong(){
		gioco=true;
		hilo=new Thread(this);
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

	// Here we receive from the game container class the key pressed
	public void keyPressed(KeyEvent evt){
		switch(evt.getKeyCode()){

		// Move ship 1
		case KeyEvent.VK_W :
		player1FlagArr = true;
		break;
		case KeyEvent.VK_S :
		player1FlagAba = true;
		break;

		// Move ship 2
		case KeyEvent.VK_UP:
		player2FlagArr=true;
		break;
		case KeyEvent.VK_DOWN:
		player2FlagAba=true;
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
	boolean izqDer=false;
	boolean arrAba=false;

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

	// Move player 1
	moverPlayer1();

	// Move player 2
	moverPlayer2();

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

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			Main thisClass = new Main();
			thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			thisClass.setVisible(true);
		}
		});
	}
}
