import java.util.Scanner;

public class BaseballGameController {
	private Scanner sc;
	public BaseballGameController(Scanner scan) {
		this.sc = scan;
	}

	public int readNum(int num) {
		int val = readNum();
		int valLen;
		if (val < 0) {
			return -1;
		}
		valLen = Integer.toString(val).length();
		if (valLen == num) {
			return val;
		}
		return -1;
	}

	private int readNum() {
		int val;
		try {
			val = sc.nextInt();
		} catch (Exception e) {
			val = -1;
		}
		return val;
	}
}
