package snake;

import snake.util.*;

public interface Tile{
	public Position getPosition();
	
	public void print(PositionMap<Character> map);
}