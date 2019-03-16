import java.awt.Point;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Stack data structure to be used in solving the maze with a depth first algorithm.
 */

@SuppressWarnings("hiding")
public class Stack<MazePoint> {
	
	private 	MazePoint[] 	data; 
	private 	int 			t = -1; 	
	private 	boolean[][] 	visited;

	@SuppressWarnings("unchecked")
	public Stack(MazePoint[][] m){
		visited = new boolean[m.length][m[0].length];
		data = (MazePoint[]) new Object[1000];
	}
	
	public boolean getVisited(MazePoint p){
		int x = (int) ((Point) p).getX();
		int y = (int) ((Point) p).getY();
		return visited[x][y];
	}
	
	public int size(){ return (t + 1); }
	
	public boolean isEmpty(){ return (t == -1); }
	
	public void push(MazePoint p) throws IllegalStateException{
		if(size() == data.length)
			throw new IllegalStateException("Stack is Full");
		data[++t] = p; 
		int x = (int) ((Point) p).getX();
		int y = (int) ((Point) p).getY(); 
		visited[x][y] = true; //setting point pushed to stack as visited
	}
	
	public MazePoint pop(){
		if(isEmpty())
			return null;
		MazePoint answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	public MazePoint top(){
		if(isEmpty())
			return null;
		return data[t];
	}
}














