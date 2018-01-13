package snake.exception;

public class CollisionException  extends Exception {
	public CollisionException() {
	//	System.out.println("Collision Exception!");
	//	return ;
	}
	
	public CollisionException(String message){
        super(message);
	//	return ;
    }
	
	public CollisionException(Throwable cause) {
        super(cause);
    }
	
	public CollisionException(String message, Throwable cause) {
        super(message, cause);
    }
 }