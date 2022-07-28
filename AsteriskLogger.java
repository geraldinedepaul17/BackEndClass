package week5;

public class AsteriskLogger implements InterfaceLogger {

	@Override
	public void log(String log) {
		System.out.println("***" + log + "***");
	}

	@Override
	public void error(String error) {
		for (int i = 0; i < error.length() + 13; i++) {
			System.out.print("*");

		}
		System.out.println();

		System.out.println("***Error: " + error + "***");

		for (int i = 0; i < error.length() + 13; i++) {
			System.out.print("*");

		}
	}

}
