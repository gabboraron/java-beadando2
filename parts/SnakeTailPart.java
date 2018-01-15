package snake.parts;

import snake.util.*;
import snake.Tile;

public class SnakeTailPart extends SnakeTail{
	final SnakeTail next;
	
	public SnakeTailPart(Position position, SnakeTail next){
		super(position);
		if(next == null){
			throw new IllegalArgumentException();
		}
		this.next = next;
	}
	
	@Override
	protected void moveTo(Position pos){
		next.moveTo(getPosition());
		super.moveTo(pos);
	}
	
	@Override
	protected boolean isAt(Position pos){
		if(getPosition().equals(pos)){
			return true;
		}
		return next.isAt(pos);
	}
	
	@Override
	public void print(PositionMap<Character> map){
		map.put(getPosition(),'#');
		next.print(map);
	}
	
}