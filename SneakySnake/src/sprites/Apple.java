package sprites;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Constants;

public class Apple extends JPanel{
	
	//where the hell is this apple
	private int x, y;
	
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
		g.setColor(Color.RED);
		g.fillRect(x * (Constants.cellSize + Constants.bufferSize), y * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
	}
	
	//now other components can figure where in the world the apple is
	public int[] getPoint() {
		int[] p = {x, y};
		return p;
	}
}
