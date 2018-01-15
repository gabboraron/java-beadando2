package snake.parts;

import java.util.*;
import java.lang.*;
import snake.Snake;
import snake.Game;
import snake.Apple;
import snake.util.*;
import snake.exception.*;

public class SnakeHead extends SnakeTail implements Snake{
	private final Game game;
	private SnakeTail tail;
	
	public SnakeHead(Position position, Position positionOfTail, Game game){
		super(position);
		this.game = game;
		this.tail = new SnakeTail(positionOfTail);
	}
	
	public void move(Direction dir, int times)
	throws CollisionException {
		if(times > 0){
			for(int i = 0; i<times; ++i){
				move(dir);
			}
		}
	}
	
	public void move(Direction dir)
	throws CollisionException {
		if(dir == Direction.UP ){
			move(getPosition().getRow()-1, getPosition().getColumn());
		}
		
		if(dir == Direction.DOWN ){
			move(getPosition().getRow()+1, getPosition().getColumn());
		}
		
		if(dir == Direction.RIGHT ){
			move(getPosition().getRow(), getPosition().getColumn()+1);
		}
		
		if(dir == Direction.LEFT ){
			move(getPosition().getRow(), getPosition().getColumn()-1);
		}
	}
	
	private void move(int row, int column)
	throws CollisionException {
		Position currentPos;
		try{
			currentPos = new Position(row, column);
			
			if(tail.isAt(currentPos)){
				throw new CollisionException();												//farok
			}
		} catch (InvalidIndexException e){
			throw new CollisionException();													//pálya széle
		}
	
		
		if((currentPos.equals(game.getApple().getPosition())) && (game.getApple() != null)){
			SnakeTailPart tailPart = new SnakeTailPart(currentPos, tail);
			tail = tailPart;
			game.ateApple();																//alma evés
		} else {			
			tail = new SnakeTail(getPosition());											//mozgassuk a kígyót
		}
		moveTo(currentPos);
	}
	
	public void print(PositionMap<Character> map){
		map.put(getPosition(), '@');
		tail.print(map);
	}
}