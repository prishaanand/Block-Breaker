import java.applet.Applet;
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

public class Driver extends JPanel implements ActionListener, KeyListener {
	
	int table_width = 600; //width of the screen 
	int table_height = 700;//height of the screen 
	

	Ball ball2 = new Ball();
	Paddle p1 = new Paddle(200, 625);
	//Blocks block = new Blocks(100,100);
	Blocks blockArr[][] = new Blocks[5][7];
	movingBlocks firstBlock = new movingBlocks(0, 7, 5);
	movingBlocks secondBlock = new movingBlocks(400, 47, 10);
	movingBlocks thirdBlock = new movingBlocks(200, 87, 2);
	
	int score = 0;
	boolean redraw = true;
	
	
	//A Font object to represent a bigger text in paint 
	Font biggerFont = new Font ("Courier New", 1, 50);
	
	/*
	 * Paint all the graphics here.
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		p1.paint(g);
		ball2.paint(g);
		firstBlock.paint(g);
		secondBlock.paint(g);
		thirdBlock.paint(g);
		
		//paint blocks
		for(int r =0; r < blockArr.length; r++) {
			for(int c =0; c < blockArr[0].length; c++) {
				//only draw the blocks if they have not collided with the ball
				if(redraw == false) {
					blockArr[r][c].paint(g);
				}
						
			}
		}		
		g.setFont(biggerFont); //set it to bigger Font object
		
	}//end of paint method - put code above for anything dealing with drawing -
	
	
	public void update() {
		//update variables for game here
		//Assume this is run 60times per second 
		ball2.move();
		if(p1.getX()<=0) {
			//restricts paddle on left side
			p1.setX(0);
		}
		
		if(p1.getX() >= 485) {
			//restricts paddle on right side of screen
			p1.setX(485);
		}		
		
		if(ball2.collided(p1)){
			//set velocity (x) to its opposite
			//use setter and getter of the ball
			ball2.setVy(-ball2.getVy());
			
		}
		
		//fill 2d array of blocks
		int x = 7;
		int y = 115;
		
	
		//draw only when ball hasnt collided
		
		for(int r = 0; r < blockArr.length; r++) {
			for(int c =0; c < blockArr[0].length; c++) {
				if(redraw) {
					blockArr[r][c] = new Blocks(x, y);
				}
				y+=40;	
				
			}
			y = 115;
			x+=117;
		}
		
			
		//moving blocks
		firstBlock.moveBlock();
		secondBlock.moveBlock();
		thirdBlock.moveBlock();

		//check collision for 2d array
		for(int r =0; r < blockArr.length; r++) {
			for(int c =0; c < blockArr[0].length; c++) {
				if(blockArr[r][c].collided(ball2)) {
				
					redraw = false;
					blockArr[r][c].setX(800);
					ball2.setVy(-ball2.getVy());
					
				}
			}
		}
		
		/*
		 * ball to block collision works, but the 2D array only shows up after
		 * one block is hit by the ball 
		 */
		
		//check collision for moving blocks
		if(firstBlock.collided(ball2)) {
			firstBlock.setX(700);
			firstBlock.setVx(0);
			ball2.setVy(-ball2.getVy());
		}
		if(secondBlock.collided(ball2)) {
			secondBlock.setX(700);
			secondBlock.setVx(0);
			ball2.setVy(-ball2.getVy());
		}		
		if(thirdBlock.collided(ball2)) {
			thirdBlock.setX(700);
			thirdBlock.setVx(0);
			ball2.setVy(-ball2.getVy());
		}		
		
		
		
	}//end of update method - put code above for any updates on variable
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	public Driver(){
		
		//SETUP the JFRAME
		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(table_width,table_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);
		
		
		
		//SETUP TImer for animation purposes	
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}
	Timer t;

	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		
		int xPos = p1.getX();
		if(e.getKeyCode()==37){ //left arrow key was pressed
			p1.setX(xPos-=10);
			//p1.moveLeft();
			
		}
	
		//detect arrow down key pressed
		if(e.getKeyCode()==39){
			p1.setX(xPos+=10);
			//p1.moveRight();
			
		}		
		
	}

	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}