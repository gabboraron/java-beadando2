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
		if(dir == UP ){
			move(getPosition().getRow()-1, getPosition().getColumn());
		}
		
		if(dir == DOWN ){
			move(getPosition().getRow()+1, getPosition().getColumn());
		}
		
		if(dir == RIGHT ){
			move(getPosition().getRow(), getPosition().getColumn()+1);
		}
		
		if(dir == LEFT ){
			move(getPosition().getRow(), getPosition().getColumn()-1);
		}
	}
	
	private move(int row, int column)
	throws CollisionException {
		Position currentPos;
		try{
			currentPos = new Position(row, column);
			
			if(tail.isAt(currentPos)){
				throw CollisionException();							//farok
			}
		} catch (InvalidIndexException e){
			throw CollisionException();								//pálya széle
		}
	
		tail = getPosition();										//mozgassuk a kígyót
		moveTo(currentPos);
	}
}