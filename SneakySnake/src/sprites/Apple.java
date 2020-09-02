package sprites;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Constants;

public class Apple extends JPanel{
	
	//where the hell is this apple
	private int x, y;
	private int[] lasts = {Constants.appleStart_x, Constants.appleStart_y};
	
	private int degrees = 0;
	
	public Apple() {
		reset();
	}
	
	public void reset() {
		x = Constants.appleStart_x;
		y = Constants.appleStart_y;
		
		lasts = new int[] {Constants.appleStart_x, Constants.appleStart_y};
	}
	
	//now its movin and shakin across the board
	public void move() {
		while(lasts[0] == x && lasts[1] == y) {
			x = (int) (Math.random() * Constants.boardSize);
			y = (int) (Math.random() * Constants.boardSize);
		}
		lasts[0] = x;
		lasts[1] = y;
	}
	
	//make this apple show up
	public void paint(Graphics2D g) {
//		g.rotate(Math.toRadians(degrees += 10),x * (Constants.cellSize + Constants.bufferSize) + Constants.cellSize/2, y * (Constants.cellSize + Constants.bufferSize) + Constants.cellSize/2);
		g.setColor(Color.RED);
		g.fillRect(x * (Constants.cellSize + Constants.bufferSize), y * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
//		g.rotate(-Math.toRadians(degrees),x * (Constants.cellSize + Constants.bufferSize) + Constants.cellSize/2, y * (Constants.cellSize + Constants.bufferSize) + Constants.cellSize/2);
	}
	
	//now other components can figure where in the world the apple is
	public int[] getPoint() {
		int[] p = {x, y};
		return p;
	}
}
