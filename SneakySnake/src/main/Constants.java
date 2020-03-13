package main;

public class Constants {
	//general constants such as timing and board sizing
	public static final int boardSize = 32;
	public static final int cellSize = 15;
	public static final int bufferSize = 1;
	public static final int tick = 80;
	
	//snakey constants
	public static final int headStart_x = boardSize/4;
	public static final int headStart_y = boardSize/2;
	public static final int lengthIncrease = 3;
	
	//apple constants
	public static final int appleStart_x = (3*boardSize)/4;
	public static final int appleStart_y = boardSize/2;
}
