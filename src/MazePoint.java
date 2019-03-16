import java.awt.Point;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * This MazePoint class extends the Point class adding an extra variable for whether or not
 * a given point in the maze is blocked or open. 
 */

public class MazePoint extends Point {
	
	private boolean blocked;
	
	public MazePoint(){
		super(-1,-1);
		blocked = false;
	}
	
	public MazePoint(int x, int y, boolean b){
		super(x,y);
		blocked = b;
	}
	
	public void setBlocked(boolean b){ blocked = b; }

	public boolean getBlocked(){ return blocked; }
	
	//Compare two points based off of their X and Y values - used to test if a point is the finish
	public boolean compare(MazePoint m){
		if(this.getX() == m.getX() && this.getY() == m.getY())
			return true;
		return false;
	}
}//Point
