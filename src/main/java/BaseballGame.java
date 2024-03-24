import java.util.Random;

public class BaseballGame {
	String answer = "123";
	BaseballGameController bgc;
	int baseballCount = 3;
	public BaseballGame(BaseballGameController controller) {
		this.bgc = controller;
		this.answer = createRandomNumber();
		System.out.println(answer);
	}
	public boolean mainLoop() {
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
		return askAgain();
	}

	private boolean askAgain() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String usrAns;
		while (true) {
			usrAns = bgc.readNum(1);

			if (usrAns == null || !(usrAns.equals("1") || usrAns.equals("2"))) {
				System.out.println("입력 형식 에러, 다시 입력해주세요");
				continue;
			}
			break;
		}
		return usrAns.equals("1");
	}

	private String createRandomNumber() {
		Random random = new Random();
		StringBuilder ret = new StringBuilder();
		random.setSeed(System.currentTimeMillis());

		for (int i = 0; i < 3; i++) {
			ret.append(random.nextInt(10));
		}
		return ret.toString();
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
			return;
		}
		System.out.println();
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
			if (num.charAt(i) != answer.charAt(i) && isNumberContains(num, answer.charAt((i)))) {
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
