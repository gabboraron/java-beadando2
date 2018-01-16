package snake.tests;

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
import snake.util.*;

public class ToApplesTest {
	
	@Test (expected = RuntimeException.class)
	public void nullTest()
	throws Exception {
		//List<Apple> tmp = new Game.toApples(null);
		Game.toApples(null);
	}
	
	@Test
	public void emptyList()
	throws Exception {
		ArrayList<String> myEmptylist = new ArrayList<String>();
		List<Apple> testList = Game.toApples(myEmptylist);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void wrongFormat()
	throws Exception {
		ArrayList<String> myWronglist = new ArrayList<String>();
		myWronglist.add(" ");
		myWronglist.add(" 1 2");
		myWronglist.add(" 3 4 ");
		myWronglist.add("5 6 ");
		myWronglist.add("7  8");
		myWronglist.add(" 9  10 ");
		myWronglist.add("11 ");
		List<Apple> testList = Game.toApples(myWronglist);
		//System.out.println("****");
		//System.out.println("LIST SIZE: " + testList.size());
		//System.out.println("LIST ELEM: " + testList.get(0).getPosition().getRow() + "," + testList.get(0).getPosition().getColumn());
		//System.out.println("****");
		assertTrue(testList.size() == 1);
	}
	
	@Test
	public void notANumber()
	throws Exception {
		ArrayList<String> myWronglist = new ArrayList<String>();
		myWronglist.add("a b");
		myWronglist.add("aaaa bbbb");
		myWronglist.add("1 bbbb");
		myWronglist.add("aaaa 1");
		List<Apple> testList = Game.toApples(myWronglist);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void wrongNumber()
	throws Exception {
		ArrayList<String> myWronglist = new ArrayList<String>();
		myWronglist.add("-1 -2");		
		myWronglist.add("-3 -4");		
		myWronglist.add("-5 6");		
		myWronglist.add("7 -8");		
		myWronglist.add("9 11");		
		myWronglist.add("12 9");		
		List<Apple> testList = Game.toApples(myWronglist);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void limParameters()
	throws Exception {
		ArrayList<String> myWronglist = new ArrayList<String>();
		myWronglist.add("0 0");		
		myWronglist.add("0 1");		
		myWronglist.add("1 0");		
		myWronglist.add("0 9");		
		myWronglist.add("9 0");		
		myWronglist.add("10 0");		
		myWronglist.add("0 10");		
		myWronglist.add("1 1");		
		List<Apple> testList = Game.toApples(myWronglist);
		assertTrue(testList.size() == 1);
	}
	
	@Test
	public void goodOnce()
	throws Exception {
		ArrayList<String> myGoodlist = new ArrayList<String>();
		myGoodlist.add("1 1");		
		List<Apple> testList = Game.toApples(myGoodlist);
		assertTrue(testList.size() == 1);
	}
	
	@Test
	public void goodTwice()
	throws Exception {
		ArrayList<String> myGoodlist = new ArrayList<String>();
		myGoodlist.add("1 1");		
		myGoodlist.add("2 2");		
		List<Apple> testList = Game.toApples(myGoodlist);
		assertTrue(testList.size() == 2);
	}
	
	@Test
	public void goodMore()
	throws Exception {
		ArrayList<String> myGoodlist = new ArrayList<String>();
		myGoodlist.add("1 1");		
		myGoodlist.add("2 2");		
		myGoodlist.add("2 2");		
		myGoodlist.add("2 2");		
		List<Apple> testList = Game.toApples(myGoodlist);
		assertTrue(testList.size() == 4);
	}	
	
	@Test
	public void mixed()
	throws Exception {
		ArrayList<String> myMixedlist = new ArrayList<String>();
		myMixedlist.add("1 1");		
		myMixedlist.add("2 2");		
		myMixedlist.add("0 0");		
		myMixedlist.add("0 1");		
		myMixedlist.add("1 0");		
		myMixedlist.add("2 2");		
		myMixedlist.add("a b");		
		myMixedlist.add("aa bb");		
		myMixedlist.add("2 2");		
		List<Apple> testList = Game.toApples(myMixedlist);
		assertTrue(testList.size() == 4);
	}
}