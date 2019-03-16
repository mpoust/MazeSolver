
/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Uses the stack created to solve the maze. Searches locations in the order of N, S, E, W. 
 * 
 */

public class StackSolver {
	private 	Stack<MazePoint> 	stack;
	private 	MazePoint[][]		maze;
	private 	boolean 			finished = false;
	
	public StackSolver(Stack<MazePoint> s, MazePoint[][] m){
		stack = s;
		maze = m;
	}
	
	public boolean canMove(MazePoint finish){
		MazePoint p = stack.top();
		int x = (int) p.getX();
		int y = (int) p.getY();
		MazePoint north = maze[x-1][y];
		MazePoint south = maze[x+1][y];
		MazePoint east  = maze[x][y+1];
		MazePoint west  = maze[x][y-1];
		if(!north.getBlocked() && !stack.getVisited(north)){
			stack.push(north);
			System.out.println("Moving NORTH!");
			if(north.compare(finish)){
				System.out.println("STACK FOUND FINISH");
				finished = true;
				return true;
			}
			canMove(finish);
			return true;
		}
		else if(!south.getBlocked() && !stack.getVisited(south)){
			stack.push(south);
			System.out.println("Moving SOUTH!");
			if(south.compare(finish)){
				System.out.println("STACK FOUND FINISH");
				finished = true;
				return true;
			}
			canMove(finish);
			return true;
		}
		else if(!east.getBlocked() && !stack.getVisited(east)){
			stack.push(east);
			System.out.println("Moving EAST!");
			if(east.compare(finish)){
				System.out.println("STACK FOUND FINISH");
				finished = true;
				return true;
			}
			canMove(finish);
			return true;
		}
		else if(!west.getBlocked() && !stack.getVisited(west)){
			stack.push(west);
			System.out.println("Moving WEST!");
			if(west.compare(finish)){
				System.out.println("STACK FOUND FINISH");
				finished = true;
				return true;
			}
			canMove(finish);
			return true;
		}
		else{
			stack.pop();
			System.out.println("POPPING STACK");
			//canMove();
			return false;
		}
	}
	
	public boolean finished(){ return finished; }
}
