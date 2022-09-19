/**
 * 
 */
package projects.exception;

/**
 * @author gerriciancanelli
 *
 */
@SuppressWarnings("serial")
public class DbException extends RuntimeException {

	/**
	 * 
	 */
	// following deleted due to not on homework solution: 
	//public DbException() {
		 
	//}
	// end of deleting

	/**
	 * @param message
	 */
	public DbException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public DbException(Throwable cause) {
		super(cause);
	
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DbException(String message, Throwable cause) {
		super(message, cause);
		
	}


}