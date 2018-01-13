package snake;

import snake.exception.*;
import snake.util.*;

public interface Snake extends Tile{
	public void move (Direction dir)
	throws CollisionException ;
	
	public void move (Direction dir, int times)
	throws CollisionException ;
}