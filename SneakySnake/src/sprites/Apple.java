package sprites;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Constants;

public class Apple extends JPanel{
	
	//where the hell is this apple
	private int x, y;
	private int lastX, lastY;
	
	private int degrees = 0;
	
	public Apple() {
		x = Constants.appleStart_x;
		y = Constants.appleStart_y;
	}
	
	//now its movin and shakin across the board
	public void move() {
		x = (int) (Math.random() * Constants.boardSize);
		y = (int) (Math.random() * Constants.boardSize);
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
	
	public int[] getLasts() {
		int[] p = {lastX, lastY};
		return p;
	}
	
	public void setLasts(int[] point) {
		lastX = point[0];
		lastY = point[1];
	}
}
