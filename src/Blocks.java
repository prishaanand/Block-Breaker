  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks {
	private int w,h;
	private Color c;
	protected int x;
	protected int y;
	private boolean col = false;
	
	
	public Blocks(int newX, int newY) {
		w = 105;
		h = 25;
		x = newX;
		y = newY;
		
		int r = (int)(Math.random()*150);
		int b = (int)(Math.random()*150);
		int g = (int)(Math.random()*(106)+100);
		c = new Color(r, b, g);
			
	}

	public boolean collided(Ball b) {
		Rectangle ball = new Rectangle(b.getX(), b.getY(), b.getW(), b.getW());
		Rectangle block = new Rectangle(x,y,w,h);
		return ball.intersects(block);
	}

	public void paint(Graphics g) {	
		
		g.setColor(c);
		g.fillRect(x, y, w, h);
	
		
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
	
	public boolean isCol() {
		return col;
	}

	public void setCol(boolean col) {
		this.col = col;
	}
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
}