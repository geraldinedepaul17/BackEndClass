package week5;

import java.lang.System.Logger;

public class AppLogger {

	public static void main(String[] args) {

		InterfaceLogger logger1 = new AsteriskLogger();
		InterfaceLogger logger2 = new SpacedLogger();

		logger1.log("Hello");
		logger1.error("Hello");
		logger2.error("ERROR");
		logger2.log("Hello");

	}
}