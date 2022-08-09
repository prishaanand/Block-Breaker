import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

	// attribute  
	private int x;
	private int y;
	private int w; // position and width
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
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

	private int vx = 5;
	private int vy = 3; // velocities

	public void paint(Graphics g) {
		g.fillOval(x, y, w, w);
	}

	public Ball(){
		x = 250;
		y = 600;
		w = 20;
		vx = 5;
		vy = 3;
	}
	
	public Ball(int newX, int newY) {
		x = newX;
		y = newY;
		w = 5;
		vx = 5;
		vy = 3;
	}

	public void move() {
		x += vx;
		y += vy;
		
		//left and right borders!
		if(x<0 || x>570){
			vx *= -1;//reverse
		}
		
		//top and bottom borders!
		if(y<0 || y > 660){
			vy *= -1;
		}
		
		if(y > 660) {
			//fix so that when it hits the bottom, 
			//the game ends
			System.exit(0);
			
		}
		
	}
	
	/* check if this object has collided with a paddle*/
	public boolean collided(Paddle p){
		
		Rectangle b = new Rectangle(x,y,w,w); 
		Rectangle pad = new Rectangle(p.getX(), p.getY(), p.getW(), p.getH());
		//System.out.println(b+" paddle: "+pad);
		return b.intersects(pad);
		
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

}