import javax.swing.JFrame;

/*
 * Michael Poust
 * mbp3@pct.edu
 * 10/22/2016
 * 
 * 
 */

public class Main {
	public static void main(String[] args) {

		Generator g = new Generator(25,25);
		
		MazePoint[][] m = g.generate(); //generates the maze
		
		for(int i = 0; i < m.length; i++){
			System.out.println();
			for(int j = 0; j < m[0].length; j++){
				if(m[i][j].getBlocked())
					System.out.print("#");
				else
					System.out.print("0");
			}
		}

		Stack<MazePoint> stack = new Stack<MazePoint>(m);
		StackSolver solverS = new StackSolver(stack, m);
		stack.push(g.getStart());
		while(!stack.isEmpty() && !solverS.finished()){
			solverS.canMove(g.getFinish());
			if(stack.isEmpty())
				System.out.println("STACK METHOD - NO PATH");
		}
		
		Queue<MazePoint> queue = new Queue<MazePoint>(m);
		QueueSolver solverQ = new QueueSolver(queue, m);
		queue.enqueue(g.getStart());
		while(!queue.isEmpty() && !solverQ.finished()){
			solverQ.solve(g.getFinish());
			if(queue.isEmpty())
				System.out.println("QUEUE METHOD - NO PATH");
		}
		
		
		DrawMaze draw = new DrawMaze(m, stack, queue);
		JFrame world = new JFrame();
		world.setSize(475,500);
		world.setTitle("Test");
		world.setContentPane(draw);
		world.setVisible(true);
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
