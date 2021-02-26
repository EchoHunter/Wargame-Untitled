import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameManager extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
	public static BufferedImage image;
	public static BufferedImage DamagedStone;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer frameDraw;
	int currentImage = 0;
	Random rand = new Random();
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font lowerFont = new Font("Arial", Font.PLAIN, 25);
	ArrayList<Button> b = new ArrayList<Button>();
	hero h = new hero(50,50,50,50,50);

	GameManager() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void drawOpeningState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, GameRunner.w, GameRunner.h);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Working Title", 55, 70);

		g.setFont(lowerFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start the game", 55, 400);
		g.setColor(Color.YELLOW);
		g.setFont(lowerFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press Space to see instructions", 55, 650);
	}

	void drawGameState(Graphics g) {
		loadImage("BackgroundButGood.jpg");
		if (gotImage) {
			Generate(g);

		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, GameRunner.w, GameRunner.h);
		}
		h.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.w, GameRunner.h);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("FAILURE", 55, 70);

		g.setFont(lowerFont);
		g.setColor(Color.RED);
		g.drawString("Press ENTER to return to the menu", 55, 400);

	}

	void updateOpeningState() {

	}



	void updateGameState() {
		h.update();
	}

	void updateEndState() {

	}

	final int MENU = 1;
	final int GAME = 2;
	final int END = 3;

	int enterTimes = 0;
	int currentState = MENU;

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END) {
				currentState = MENU;
			}

			else if (currentState == MENU) {
				if (enterTimes == 0) {
					JOptionPane.showMessageDialog(null, "Are you sure? If you fail you must start again");
					enterTimes++;
				}
				if (enterTimes == 1) {
					currentState++;
					startGame();
					enterTimes = 0;
				}
			}

			else if (currentState == GAME) {
				currentState++;
				endGame();
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
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

	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawOpeningState(g);
		} else if (currentState == GAME) {
			drawGameState(g);

		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateOpeningState();
		}

		if (currentState == GAME) {
			updateGameState();
		}
		if (currentState == END) {
			updateEndState();
		}
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
int mouseX = 0;
int mouseY = 0;
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		checkButton();
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				DamagedStone = ImageIO.read(this.getClass().getResourceAsStream("damagedStones.jpg"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

void checkButton() {
	if((mouseX > h.x)&&(mouseX < h.x+h.width)) {
		if((mouseY > h.y)&&(mouseY< h.y +h.height)){
			System.out.println("clicked");
			h.x = mouseX + (h.width / 2);
			h.y = mouseY + (h.height / 2);
			repaint();
		}
	}
}
	void Generate(Graphics g) {
		
		g.drawImage(image, 0, 0, 1500, 1000, null);
		h.draw(g);
	}
}
