import java.util.Random;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * Generator class will generate a maze based from given length, width, and density values. The blocked walls
 * are randomly created according to the provided density value (0-1). Generate method returns a 2D Array of
 * MazePoints representing the maze.
 */

public class Generator {
	
	private MazePoint[][] maze; 
	private MazePoint 	  start = new MazePoint(2, 2, false); //Maze start at (2,2) unblocked
	private MazePoint 	  finish; 							  //Maze end determined by maze size
	
	/* -- Random values for creating blocked cells -- */
	int 	randX;	//random x position
	int 	randY;	//random y position
	int 	randL;	//random length for walls
	boolean randDir;//random direction to create walls: false = vertical  true = horizontal
	Random	r = new Random();

	public Generator(int l, int w){
		maze = new MazePoint[l][w];
	}
	
	//Generates and returns a maze with random blocked cells
	public MazePoint[][] generate(){
		
		//Populate maze with MazePoints with corresponding x/y values and blocked value of false
		for(int i = 0; i < maze.length; i++)	
			for(int j = 0; j < maze[0].length; j++)
				maze[i][j] = new MazePoint(i, j, false);
			
		/* -- Block Edges of Maze -- */
		//LEFT - RIGHT
		for(int i = 0; i < maze.length; i++){
			maze[i][0].setBlocked(true); 				//LEFT
			maze[i][maze[0].length-1].setBlocked(true); //RIGHT
		}
		
		//TOP - BOTTOM
		for(int i = 0; i < maze[0].length; i++){
			maze[0][i].setBlocked(true); 				//TOP
			maze[maze.length-1][i].setBlocked(true);	//BOTTOM
		}
		
		//Create random blocked walls
		for(int i = 0; i < 25; i++){		//NOTE: NEED TO IMPLEMENT DENSITY HERE
			randX = r.nextInt(maze.length - 4);
			randY = r.nextInt(maze[0].length - 4);
			randDir = r.nextBoolean();
			if(randDir){ 
				randL = (r.nextInt(maze.length) - randX);
				for(int j = 0; j < randL; j++){
					maze[randX++][randY].setBlocked(true);
				}
			}
			else{
				randL = r.nextInt(maze[0].length - randY);
				for(int j = 0; j < randL; j++){
					maze[randX][randY++].setBlocked(true);
				}
			}
		}
		
		//Set start and finish to unblocked in the event they got blocked randomly
		start.setBlocked(false); 
		finish = maze[maze.length-2][maze[0].length-2]; //Determine finish location
		finish.setBlocked(false);
	
		return maze;
	}
	
	public MazePoint getStart(){ return start; }
	
	public MazePoint getFinish(){ return finish; }
}
