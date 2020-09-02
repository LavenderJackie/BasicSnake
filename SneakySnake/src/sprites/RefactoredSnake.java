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
	
	private int[] apple;
	private boolean noInput = true;
	
	public boolean move() {
		
		if(up) {
			headY -= 1;
			xSet.add(headX);
			ySet.add(headY + 1);
		}
		else if(down) {
			headY += 1;
			xSet.add(headX);
			ySet.add(headY - 1);
		}
		else if(left) {
			headX -= 1;
			xSet.add(headX + 1);
			ySet.add(headY);
		}
		else if(right) {
			headX += 1;
			xSet.add(headX - 1);
			ySet.add(headY);
		}
		
		if(xSet.size() >= size) {
			xSet.remove(0);
			ySet.remove(0);
		}
		
		if(headX == apple[0] && headY == apple[1]) {
			size += Constants.lengthIncrease;
			return true;
		}
		return false;
	}
	
	//method not working
	public boolean inTail(boolean app) {
		boolean ret = false;
		int[] point;
		if(app)
			point = apple;
		else
			point = head();
		for(int i = 0; i < xSet.size(); i++) {
			ret = (xSet.get(i) == point[0] && ySet.get(i) == point[1]) ? true : ret;
//			if(b && ret)
//				System.out.println("{" + xSet.get(i) + "," + ySet.get(i) + "} vs {" + point[0] + "," + point[1] + "}");
			if(ret)
				break;
		}
		if(ret)
			System.out.println("in Tail");
		return ret;
	}
	
	public int[] head() {
		
		int[] h = {headX, headY};
		return h;
	}
	
	public void setApple(int[] point) {
		
		apple = point;
	}
	
	public void setNoInput(boolean t) {
		
		noInput = t;
	}
	
	public boolean noInput() {

		return noInput;
	}
	
	public boolean crash() {
		
		boolean ret = headX >= Constants.boardSize || headX < 0 || headY >= Constants.boardSize || headY < 0;
		ret = inTail(false) ? true : ret;
		return ret;
	}
	
	public void paint(Graphics2D g) {
		
		g.setColor(Color.GREEN);
		g.fillRect(headX * (Constants.cellSize + Constants.bufferSize), headY * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		for(int i = 0; i < xSet.size(); i++) {
			g.fillRect(xSet.get(i) * (Constants.cellSize + Constants.bufferSize), ySet.get(i) * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
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
				noInput = false;
				lastKey = e.getKeyCode();
			}
		}
	}
}
