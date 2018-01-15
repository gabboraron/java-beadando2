package snake;

import snake.util.*;

public class Apple implements Tile{
	final Position position;
	public Apple(Position pos){
		this.position = pos;
	}
	
	public Position getPosition(){
		return this.position;
	}
	
	public void print(PositionMap<Character> map){
		map.put(position, 'o');
	}
}