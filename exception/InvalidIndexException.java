package snake.exception;

public class InvalidIndexException  extends RuntimeException {
	public InvalidIndexException() {
		//System.out.println("Invalid Index Exception!");
	}
	
	public InvalidIndexException(String message){
        super(message);
    }
	
	public InvalidIndexException(Throwable cause) {
        super(cause);
    }
	
	public InvalidIndexException(String message, Throwable cause) {
        super(message, cause);
    }
 }