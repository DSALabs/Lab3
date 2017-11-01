package knights_tour;

public interface KnightsTour {
  
	//Position has not been visited by knight
	public static final int UNVISITED=-1;
	 
	// Start the tour at a specified position
	public void startTour(int startingRow,int startingCol);
	
	//Start at a random position
	public void startTour();
	
	//return row index
	public int getCurrentRow();

	// return column index
	public int getCurrentCol();

	// array of possible moves
	
	int[][] getPossibleMoves();

	// make next move
	public int[] makeMove();

	//Select the next move
	public int[] makeMove(int[] move);

	//order of visited squares
	public int[][] getBoardState();
	
	//order of visited squares
	public String getBoardDisplay();
	
}
