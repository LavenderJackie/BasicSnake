package sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import main.Constants;

public class RefactoredSnake {
	
	private int headX = Constants.headStart_x, headY = Constants.headStart_y;
	private ArrayList<Integer> xSet = new ArrayList<Integer>(), ySet = new ArrayList<Integer>();
	
	private int size = Constants.starterLength;
	private int lastKey = 0;
	
	private boolean up = false, down = false, left = false, right = true;
	
	public boolean move(int[] apple) {
		
	}
	
	public boolean inTail(int[] point) {
		
		boolean ret = headX == point[0] && headY == point[1];
		for(int i = 0; i < xSet.size(); i++) {
			ret = xSet.get(i) == point[0] && ySet.get(i) == point[1] ? true : ret;
		}
		return ret;
	}
	
	public int[] head() {
		
		int[] h = {headX, headY};
		return h;
	}
	
	public boolean crash() {
		
		boolean ret = headX >= Constants.boardSize || headX < 0 || headY >= Constants.boardSize || headY < 0;
		ret = inTail(head()) ? true : ret;
		return ret;
	}
	
	public void paint(Graphics2D g) {
		
		g.setColor(Color.GREEN);
		g.fillRect(headX * (Constants.cellSize + Constants.bufferSize), headY * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		for(int i = 0; i < xSet.size(); i++) {
			g.fillRect(xSet.get(i) * (Constants.cellSize + Constants.bufferSize), ySet.get(i) * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		}
	}
	
	public boolean keyPressed(KeyEvent e) {
		
		boolean validIn = true;
		if(lastKey != e.getKeyCode()) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_W:
					up = !down;
					left = false;
					right = false;
					break;
				case KeyEvent.VK_A:
					left = !right;
					up = false;
					down = false;
					break;
				case KeyEvent.VK_S:
					down = !up;
					left = false;
					right = false;
					break;
				case KeyEvent.VK_D:
					right = !left;
					up = false;
					down = false;
					break;
				default:
					validIn = false;
					break;
			}
			if(validIn) {
				move();
				lastKey = e.getKeyCode();
			}
			return validIn;
		}
	}
}
