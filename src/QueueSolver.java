
/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Used the queue created to solve the maze.
 */

public class QueueSolver {
	private Queue<MazePoint> 	queue;
	private MazePoint[][] 		maze;
	private boolean 			finished = false;
	private int 				d = 0;
	private int[][] 			distance;
	
	public QueueSolver(Queue<MazePoint> q, MazePoint[][] m){
		queue = q;
		maze = m;
		distance = new int[m.length][m[0].length];
	}
	
	public void solve(MazePoint finish){
		
		MazePoint location = queue.dequeue();
		int x = (int) location.getX();
		int y = (int) location.getY();
		System.out.println("**DEQUEUE X: " + x + " Y: " + y);
		distance[x][y] = d;
		d++;
		MazePoint north = maze[x-1][y];
		MazePoint south = maze[x+1][y];
		MazePoint east  = maze[x][y+1];
		MazePoint west  = maze[x][y-1];
		if(location.compare(finish)){
			System.out.println("QUEUE FOUND FINISH");
			finished = true;
		}
		else{
			if(!north.getBlocked() && !queue.getVisited(north)){
				queue.enqueue(north);
				System.out.println("ENQUEUE NORTH");
				distance[x-1][y] = d;
			}
			if(!south.getBlocked() && !queue.getVisited(south)){
				queue.enqueue(south);
				System.out.println("ENQUEUE SOUTH");
				distance[x+1][y] = d;
			}
			if(!east.getBlocked() && !queue.getVisited(east)){
				queue.enqueue(east);
				System.out.println("ENQUEUE EAST");
				distance[x][y+1] = d;
			}
			if(!west.getBlocked() && !queue.getVisited(west)){
				queue.enqueue(west);
				System.out.println("ENQUEUE WEST");
				distance[x][y-1] = d;
			}
			d++;
		}
		
	}
	
	public boolean finished(){
		return finished;
	}
	
	/* //Counting the distance to solve the maze
	public int countDistance(MazePoint p){
		int x = (int) p.getX();
		int y = (int) p.getY();
		MazePoint location = p;
		int counter = distance[x][y];
		System.out.println(counter + " steps from start to finish");
		while(counter != 0){
			if(distance[x-1][y] == (counter - 1)){
				//counter = 
			}
		}
		
	}*/
}
