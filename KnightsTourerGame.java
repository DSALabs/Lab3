package knights_tour;

import java.util.*;
import java.util.Random;

public class KnightsTourerGame implements KnightsTour {

	protected int[][] _potential;
	protected int[][] _board;
	protected int _row;
	protected int _col;
	protected int _iteration;

	//Specify size of board here
	public static int BOARD_ROWS = 6;
	public static int BOARD_COLS = 6;
	
	Scanner input = new Scanner(System.in);
	// possible moves
	public static int[][] KNIGHT_RANGE = {
		{-2, -1},
		{-2, 1},
		{2, -1},
		{2, 1},
		{-1, -2},
		{-1, 2},
		{1, -2},
		{1, 2}
	};
	
	//create new game
	public KnightsTourerGame() {
		cleanBoard();
	}
	
	//Determine possible moves from position
	protected int[][] getStaticMoves(int row, int col) {
		int[][] possibleMoves = new int[8][2];
		int[] candidate;
		int possible = 0;
		for (int[] move: KNIGHT_RANGE) {
			candidate = peekMove(move, row, col);
			if (isValidPosition(candidate)) {
				possibleMoves[possible++] = move;
			}
		}
		int[][] actualMoves = new int[possible][2];
		for (int i = 0; i < possible; i++) {
			actualMoves[i] = possibleMoves[i];
		}
		return actualMoves;
	}
	
	//Preview position after move 
	protected int[] peekMove(int[] move) {
		return peekMove(move, _row, _col);
	}
	
	//Preview position after move
	protected int[] peekMove(int[] move, int row, int col) {
		return new int[] {
			row + move[0],
			col + move[1]
		};
	}
	
	//New Board
	protected void cleanBoard() {
		// reset potential matrix and board
		_potential = new int[8][8];
		_board = new int[8][8];
		for (int i = 0; i < _board.length; i++) {
			for (int j = 0; j < _board[i].length; j++) {
				// set position to potential
				_potential[i][j] = getStaticMoves(i, j).length;
				// set position to unvisited
				_board[i][j] = UNVISITED;
			}
		}
	}
	
	// Determine whether position is in bounds
	protected boolean isValidPosition(int[] position) {
		return ((position[0] >= 0) && (position[0] < BOARD_ROWS)) && ((position[1] >= 0) && (position[1] < BOARD_COLS));
	}
	

	protected void updatePosition() {
		// increment move number
		_board[_row][_col] = ++_iteration;
		int[] candidate;
		for (int[] move: KNIGHT_RANGE) {
			candidate = peekMove(move);
			if (isValidPosition(candidate)) {
				// reduce potential of each adjacent tile by one
				_potential[candidate[0]][candidate[1]]--;
			}
		}
	}

	//finding move history
	protected int getSquare(int[] position) {
		return _board[position[0]][position[1]];
	}
	
	//Retrieve Game move potential
	protected int getPotential(int[] position) {
		return _potential[position[0]][position[1]];
	}

	//best next move
	protected int[] getBestMove() {
		int[] bestmove = new int[2];
		int[] candidate;
		int potential;
		double length;
		// maximize best values
		int bestpotential = Integer.MAX_VALUE;
		double bestlength = Integer.MAX_VALUE;

		for (int[] move: getPossibleMoves()) {
			candidate = peekMove(move);
			potential = getPotential(candidate);
			length = Math.hypot(Math.min(BOARD_ROWS - 1 - candidate[0], candidate[0]), Math.min(BOARD_COLS - 1 - candidate[1], candidate[1]));
			if (potential < bestpotential) {
				// set new best move
				bestlength = length;
				bestpotential = potential;
				bestmove = move;
			}
			else if (potential == bestpotential) {
				// if same potential, find position closest to edge of board
				if (length < bestlength) {
					bestlength = length;
					bestpotential = potential;
					bestmove = move;
				}
			}
		}
		return bestmove;
	}
	
	//Get move count
	int getIteration() {
		return _iteration;
	}

	@Override
	public void startTour(int startingRow, int startingCol) {
		_row = startingRow;
		_col = startingCol;
		_iteration = 0;
		cleanBoard();
		updatePosition();
	}

	@Override
	public void startTour() {
		Random r = new Random();
		startTour(r.nextInt(BOARD_ROWS), r.nextInt(BOARD_COLS));
	}

	@Override
	public int getCurrentRow() {
		return _row;
	}

	@Override
	public int getCurrentCol() {
		return _col;
	}

	@Override
	public int[][] getPossibleMoves() {
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		int[] candidate;
		for (int[] row: KNIGHT_RANGE) {
			candidate = peekMove(row);
			// if position is on board and unvisited
			if (isValidPosition(candidate) && (getSquare(candidate) == UNVISITED)) {
				possibleMoves.add(row);
			}
		}
		return possibleMoves.toArray(new int[][] {});
	}
	
	@Override
	public int[] makeMove() {
		if (getPossibleMoves().length > 0) {
			return makeMove(getBestMove());
		}
		else {
			return null;
		}
	}

	@Override
	public int[] makeMove(int[] move) {
		_row += move[0];
		_col += move[1];

		updatePosition();

		return new int[] {
			_row,
			_col
		};
	}

	@Override
	public int[][] getBoardState() {
		return _board;
	}
	
	//Get matrix
	public int[][] getGameState() {
		return _potential;
	}

	@Override
	public String getBoardDisplay() {
		return stringify(_board);
	}
	
	//map game to multiline string
	public String getGameDisplay() {
		return stringify(_potential);
	}
	
	//map matrix to multiline string
	private String stringify(int[][] map) {
		String output = "";
		for (int[] row: map) {
			output += row[0];
			for (int j = 1; j < row.length; j++) {
				output += "\t" + row[j];
			}
			output += "\n";
		}
		return output;
	}
}
