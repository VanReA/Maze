
public class MouseIntoTheMaze {
	
	public static void main (String[] args) {
	
		Maze maze = new Maze();
//		maze.setEndRow(10);
//		maze.setEndColumn(6);
		System.out.println("The Maze [" + maze.getTheMaze()[0].length + ":" + maze.getTheMaze().length +"]");
		maze.printMaze();
		if (maze.solve(5, 3)){
			System.out.println ("Maze solved!");
			if(maze.getCheeseBr()>1){
				System.out.println("The mouse found " + maze.getCheeseBr() + " cheeses");
			} else {
				System.out.println("The mouse found " + maze.getCheeseBr() + " cheese");
			}
		} else {
			System.out.println ("No solution.");
		}
		maze.printMaze();

	}
}