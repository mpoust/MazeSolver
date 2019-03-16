import java.awt.Point;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Queue data structure used to solve the maze with a breadth first algorithm.
 */

public class Queue<MazePoint> {
	
	private 	MazePoint[] 	data; 
	private 	int 			f = 0; 
	private 	int 			size = 0;
	private 	boolean[][] 	visited;
	
	@SuppressWarnings("unchecked")
	public Queue(MazePoint[][] m){
		data = (MazePoint[]) new Object[1000];
		visited = new boolean[m.length][m[0].length];
	}
	
	public int size(){ return size; }
	
	public boolean isEmpty(){ return (size == 0); }
	
	public void enqueue(MazePoint p) throws IllegalStateException{
		if(size == data.length)
			throw new IllegalStateException("Queue is Full");
		int available = (f + size) % data.length;
		data[available] = p;
		size++;
		int x = (int) ((Point) p).getX();
		int y = (int) ((Point) p).getY();
		visited[x][y] = true;
	}
	
	public MazePoint first(){
		if(isEmpty())
			return null;
		return data[f];
	}
	
	public MazePoint dequeue(){
		if(isEmpty())
			return null;
		MazePoint answer = data[f];
		f = (f + 1) % data.length;
		size--;
		return answer;
	}
	
	public boolean getVisited(MazePoint p){
		int x = (int) ((Point) p).getX();
		int y = (int) ((Point) p).getY();
		return visited[x][y];
	}
}
