package part2;

public class T292NimGame {

	public static void main(String[] args) {
		System.out.println(new T292NimGame().canWinNim(4));
	}

	public boolean canWinNim(int n) {
		if ((n & 1) == 0 && ((n >> 1) & 1) == 0) {
			return false;
		}
		return true;
	}

	public boolean canWinNim1(int n) {
		return n % 4 != 0;
	}

}
