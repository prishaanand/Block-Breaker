public class movingBlocks extends Blocks{
	private int vx;
	
	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public movingBlocks(int newX,int newY, int newVX) {
		super(newX,newY);
		vx = newVX;
	}
	
	public void moveBlock() {
		x+=vx;
		if(x == 600) {
			x = -100;
		}
	}
}
