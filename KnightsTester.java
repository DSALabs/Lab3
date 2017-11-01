package knights_tour;

import java.util.Scanner;

public class KnightsTester {

	public static void main(String[] args) {

		KnightsTourerGame game = new KnightsTourerGame();

		Scanner scanner = new Scanner(System.in);

		int highscore = 0;

		while (scanner.hasNextLine()) {

			game.startTour();

			while (game.getPossibleMoves().length > 0) {
				game.makeMove();
				System.out.println(game.getBoardDisplay());
			}

			if (game.getIteration() >= highscore) {
				highscore = game.getIteration();
				System.out.println(highscore);
			}
			else {
				System.err.println("Not 64");
			}

			scanner.nextLine();
		}

	}

}