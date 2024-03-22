import java.util.Scanner;

public class BaseballGame {
	String answer = "123";
	Scanner sc;
	BaseballGameController bgc;
	int baseballCount = 3;
	public BaseballGame(BaseballGameController controller) {
		this.bgc = controller;
	}
	public void mainLoop() {
		while (true) {
			System.out.print("숫자를 입력해주세요: ");
			String playerBall = bgc.readNum(baseballCount);

			if (playerBall == null) {
				System.out.println("입력 형식 에러, 다시 입력해주세요");
				continue;
			}

			if (calcProcess(playerBall)) {
				break;
			}
		}
	}

	private boolean calcProcess(String playerBall) {
		int strike = getStrike(playerBall);
		int ball = getBall(playerBall);

		printResult(strike, ball);

		return checkGameEnd(strike);
	}

	private boolean checkGameEnd(int strike) {
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			return true;
		}
		return false;
	}

	private void printResult(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return;
		}
		if (strike > 0) {
			System.out.print(strike + "스트라이크 ");
		}
		if (ball > 0) {
			System.out.println(ball + "볼");
		}
	}

	private int getStrike(String num) {
		int ret = 0;
		for (int i = 0; i < 3; ++i) {
			if (num.charAt(i) == answer.charAt(i)) {
				ret++;
			}
		}
		return ret;
	}

	private int getBall(String num) {
		int ret = 0;
		for (int i = 0; i < 3; ++i) {
			if (num.charAt(i) != answer.charAt(i) && isNumberContains(answer, num.charAt((i)))) {
				ret++;
			}
		}
		return ret;
	}

	private boolean isNumberContains(String num, char ch) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == ch) {
				return true;
			}
		}
		return false;
	}
}
