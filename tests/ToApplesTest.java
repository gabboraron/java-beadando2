import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.*;

//import snake.util.*;
//import snake.parts.*;
//import snake.exception.*;
import snake.Game;
import snake.Apple;

public class ToApplesTest {
	
	@Test (expected = RuntimeException.class)
	public void nullTest(){
		//List<Apple> tmp = new Game.toApples(null);
		Game.toApples(null);
	}
	
	@Test
	public void emptyList(){
		ArrayList<String> myEmptylist = new ArrayList<String>();
		List<Apple> testList = Game.toApples(myEmptylist);
		assertTrue(testList.isEmpty());
	}
}