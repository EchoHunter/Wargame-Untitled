import java.awt.Rectangle;
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
		this.originx = o;
		collisionBox = new Rectangle(a, b, c, d);
	}
	int originx;
	int move = 0;
	boolean onTable = true;

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
}
