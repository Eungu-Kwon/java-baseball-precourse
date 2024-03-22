import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseballGameController bgc = new BaseballGameController(sc);
		while (true) {
			BaseballGame mg = new BaseballGame(bgc);
			mg.mainLoop();

			// read res from user to continue game
			// if end then break
			break;
		}
	}
}
