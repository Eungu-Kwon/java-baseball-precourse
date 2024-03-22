public class BaseballGame {
	String answer = "000";
	public void mainloop() {
		while (true) {
			// read number

			// check result

			// print result

			// if end then break
			break;
		}
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
