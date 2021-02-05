import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	GameObject(int a, int b, int c, int d, int o) {
		this.x = a;
		this.y = b;
		this.width = c;
		this.height = d;
		this.origin = o;
		collisionBox = new Rectangle(a, b, c, d);
	}
	int origin;
	int move = 0;
	boolean onTable = true;

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
}
