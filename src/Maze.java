
public class Maze {
	
	private String[][] theMaze = {
			{" "," "," ","#","#","S","S","S","#"," "," "," "," "},
			{" ","#"," ","S"," ","#","S","#"," "," ","#","#"," "},
			{"#","#","#","#"," ","#","#","#"," ","#"," ","#","#"},
			{" "," "," ","#"," "," "," ","#"," ","#"," "," "," "},
			{" ","#"," ","#","#","#","#"," "," "," ","#","#"," "},
			{" ","#"," "," "," "," "," "," ","#"," "," "," "," "},
			{" ","#","#","#","#","#","#","#","#","#","#","#","#"},
			{" "," "," "," "," "," "," "," "," "," "," "," "," "},
			{"#","#","#","S","#"," "," "," "," "," "," "," "," "},
			{" "," ","#"," ","#","#","#","#","#"," ","#","#","#"},
			{" "," ","#"," "," ","S"," "," ","S"," "," "," "," "},
			{" "," ","#","#","#","#","#","#","#","#","#","#"," "},
			{" "," "," "," "," "," "," "," "," "," "," ","#"," "},
			};
	private int cheeseBr = 0;
	private int endRow = theMaze.length-1;
	private int endColumn = theMaze[0].length-1;
	
	
	public void printMaze(){
		System.out.println();

		for(int row=0; row < theMaze.length; row++){
			System.out.print(row + "\t|");
			for(int column=0; column < theMaze[row].length; column++){
				System.out.print(theMaze[row][column]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
	}
	
	
	public boolean solve(int row, int column){

		boolean done = false;
		
		if(validPath(row, column)){
			
			theMaze[row][column] = "X";
			if(row == getEndRow() && column == getEndColumn()){
				theMaze[row][column] = "E";
				done = true;
				return done;
			} else {
				done = solve(row+1, column);
				if(!done){
					done = solve(row, column+1);
					}
				if(!done){
					done = solve(row-1, column);
				}
				if(!done){
					done = solve(row, column-1);
				}
			}
			if(done){
				theMaze[row][column] = " ";
			}
		}
		return done;
	}

	private boolean validPath(int row, int column){
		
		boolean result = false;
		if (row >= 0 && row < theMaze.length && column >= 0 && column < theMaze[0].length){
			if(theMaze[row][column] == "S"){
				setCheeseBr(getCheeseBr() + 1);
				theMaze[row][column] = " ";
				result = true;
			} else {
				if(theMaze[row][column] == " " ){
					result = true;
				}
			}
		}
		return result;
	}
	
	
	//Getters and Setters
	public String[][] getTheMaze() {
		return theMaze;
	}

	public void setTheMaze(String[][] theMaze) {
		this.theMaze = theMaze;
	}

	public int getCheeseBr() {
		return cheeseBr;
	}

	public void setCheeseBr(int cheeseBr) {
		this.cheeseBr = cheeseBr;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public int getEndColumn() {
		return endColumn;
	}


	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}
}