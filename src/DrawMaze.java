import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Visually creates the maze in a GUI. Currently the solving is only text based and isn't displayed through the GUI.
 */

public class DrawMaze extends JPanel {
	final private int SquareSize = 15;
	final private int BoardSize = 14;
	private MazePoint[][] maze;
	
	//for drawing stack method
	private Stack<MazePoint> stack;
	private Queue<MazePoint> queue;
	
	public DrawMaze(MazePoint[][] m, Stack<MazePoint> s, Queue<MazePoint> q){
		maze = m;
		stack = s;
		queue = q;
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[0].length; j++){
				if(maze[i][j].getBlocked()){
					g.setColor(Color.BLACK);
					g.fillRect(j*SquareSize, i*SquareSize, BoardSize, BoardSize);
				}
				else{
					g.setColor(Color.WHITE);
					g.fillRect(j*SquareSize, i*SquareSize, BoardSize, BoardSize);
				}
			}
		}
		
		//coloring the start and finish
		//start
		int x = 2;
		int y = 2;
		g.setColor(Color.GREEN);
		g.fillRect(y*SquareSize, x*SquareSize, BoardSize, BoardSize);
		//finish
		x = maze.length-3;
		y = maze[0].length-3;
		g.setColor(Color.RED);
		g.fillRect(y*SquareSize, x*SquareSize, BoardSize, BoardSize);
		
		while(!stack.isEmpty()){
			MazePoint temp = stack.pop();
			int i = (int) temp.getX();
			int j = (int) temp.getY();
			g.setColor(Color.BLUE);
			//g.fillOval(j*SquareSize, i*SquareSize, BoardSize, BoardSize);
			
		}
		
		while(!queue.isEmpty()){
			MazePoint temp = queue.dequeue();
			int i = (int) temp.getX();
			int j = (int) temp.getY();
			g.setColor(Color.CYAN);
			g.fillOval(j*SquareSize, i*SquareSize, BoardSize, BoardSize);
		}
	}
}
