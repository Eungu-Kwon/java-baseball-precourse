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

	private int getStrike(int num) {
		String numStr = Integer.toString(num);
		int ret = 0;
		for (int i = 0; i < 3; ++i) {
			if (numStr.charAt(i) == answer.charAt(i)) {
				ret++;
			}
		}
		return ret;
	}
}
