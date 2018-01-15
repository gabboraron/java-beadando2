package snake.parts;

import snake.util.*;
import snake.Tile;

public class SnakeTail implements Tile{
	Position position;
	
	public  SnakeTail(Position pos){
		this.position = pos;
	}
	
	public Position getPosition(){
		return position;
	}
	
	protected void moveTo(Position pos){
		this.position = pos;
	}
	
	protected boolean isAt(Position pos){
		return this.position.isSame(pos);
	}
	
	public void print(PositionMap<Character> map){
		map.put(position, '~');
	}
}