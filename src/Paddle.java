import java.awt.Graphics;

public class Paddle {

	// attribute
	private int x;
	private int y;
		
	private int h;
	private int w; // position and width 
	private int vx; // velocities

	public void paint(Graphics g) {
		g.fillRect(x, y, w, h);
	}

	public Paddle(int newX, int newY) {
		x = newX;
		y = newY;
		vx = 10;
		w = 100;
		h = 10;
	}
	
	public void moveRight() {
		x += vx;
	}
	
	public void moveLeft() {
		x += -vx;
		
	}
	
	public void setVx(int newVx){
		vx = newVx;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

}