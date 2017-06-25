package exception;

public class JobNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "Error: the job you are searching for does not exist. Please try again with different"
				+ "search parameters.";
	}
}