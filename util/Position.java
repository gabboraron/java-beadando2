package snake.util;

import snake.exception.*;

public class Position{
	public static final int SIZE_OF_BOARD = 10;
	final int row;
	final int column;
	
	public Position(int rowIdx, int columnIdx){
		boolean good = false;
		if((rowIdx > 0) && (rowIdx < SIZE_OF_BOARD)){
			good = true;
		}
	
		if(good && ((columnIdx > 0) && (columnIdx < SIZE_OF_BOARD))){
			good = true;
		}else{
			good = false;
		}
		
		if(good){
			this.row = rowIdx;
			this.column = columnIdx;
		}else{
			throw new InvalidIndexException();
		}
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}
	
	public boolean isSame(Position that){
		if((that != null) && ((this.row == that.getRow()) && (this.column == that.getColumn()))){
			return true;
		}
		return false;
	}
	
	public boolean equals(Position that){
		return isSame(that);
	}
	
}