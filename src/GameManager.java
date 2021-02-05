import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameManager extends JPanel implements KeyListener, ActionListener {
	Timer frameDraw;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	 Font lowerFont = new Font("Arial", Font.PLAIN, 25);
	
	 GameManager(){
		 frameDraw = new Timer(50/3, this);
		 frameDraw.start();
	 }
	 
	 void drawOpeningState(Graphics g) {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, GameRunner.w, GameRunner.h); 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Working Title", 55,70 );
		 
		 g.setFont(lowerFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press ENTER to find a game", 55, 400 );
		 g.setColor(Color.YELLOW);
		 g.drawString("Press CTRL to host a game", 55, 500 );
		 g.setFont(lowerFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press Space to see instructions", 55, 650 );
	}
	void drawLobbyState(Graphics g) {
		g.setColor(Color.green);
		 g.fillRect(0, 0, GameRunner.w, GameRunner.h); 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Find new lobby", 575,250 );
	}
	void drawGameState(Graphics g) {
		
	}
	void drawEndState(Graphics g) {
		
	}
	
	
	void updateOpeningState() {
		
	}
	void updateLobbyState() {
		
	}
	void updateGameState() {
	
	}
	void updateEndState() {
	
	}
	
	final int MENU = 1;
	final int LOBBY = 2;
	final int GAME = 3;
	final int END = 4;
	int currentState = MENU;
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			
			if(currentState == END) {
				currentState = MENU;
			}
			
			else if(currentState == MENU) {
				currentState++;
				startGame();
			}
			else if(currentState == LOBBY) {
				currentState++;
			}
			else if (currentState == GAME) {
				currentState++;
				endGame();
			}
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==MENU) {
				JOptionPane.showMessageDialog(null, "TBD Info");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void startGame() {
		
	}
	void endGame() {
		
	}
	public void paintComponent(Graphics g){
		
		
		if(currentState == MENU){
		    drawOpeningState(g);
		}else if (currentState == LOBBY) {
			drawLobbyState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateOpeningState();
		}
		if(currentState == LOBBY){
		    updateLobbyState();
		}
		if(currentState == GAME){
		    updateGameState();
		}
		if(currentState == END){
		    updateEndState();
		}
	
	repaint();
	
	}
	
}
