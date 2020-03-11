package sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.*;

public class Snake extends JPanel{
	
	private Game game;
	
	private int headX = Constants.headStart_x, headY = Constants.headStart_y;
	private ArrayList<Integer> xSet = new ArrayList<Integer>(), ySet = new ArrayList<Integer>();
	
	private int size = 3;
	
	private boolean up = false, down = false, left = false, right = true;
	
	public Snake(Game g) {
		game = g;
	}
	
	public void move() {
		xSet.add(headX);
		ySet.add(headY);
		if(xSet.size() >= size) {
			xSet.remove(0);
			ySet.remove(0);
		}
		
		if(up) {
			headY -= 1;
		}
		else if(down) {
			headY += 1;
		}
		else if(left) {
			headX -= 1;
		}
		else if(right) {
			headX += 1;
		}
		if(headX == game.apple.getPoint()[0] && headY == game.apple.getPoint()[1]) {
			size++;
			game.apple.move();
			while(inTail(game.apple.getPoint())) {
				game.apple.move();
			}
		}
		if(crash()) {
			game.gameOver();
		}
	}
	
	public boolean inTail(int[] apple) {
		boolean ret = false;
		ret = headX == game.apple.getPoint()[0] && headY == game.apple.getPoint()[1] ? true : ret;
		for(int i = 0; i < xSet.size(); i++) {
			ret = xSet.get(i) == game.apple.getPoint()[0] && ySet.get(i) == game.apple.getPoint()[1] ? true : ret;
		}
		return ret;
	}
	
	public boolean crash() {
		boolean ret = headX >= Constants.boardSize || headX < 0 || headY >= Constants.boardSize || headY < 0;
		for(int i = 0; i < xSet.size(); i++) {
			ret = headX == xSet.get(i) && headY == ySet.get(i) ? true : ret;
		}
		return ret;
	}
	
	public void paint(Graphics2D g) {
		game.validIn = true;
		g.setColor(Color.GREEN);
		g.fillRect(headX * (Constants.cellSize + Constants.bufferSize), headY * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		for(int i = 0; i < xSet.size(); i++) {
			g.fillRect(xSet.get(i) * (Constants.cellSize + Constants.bufferSize), ySet.get(i) * (Constants.cellSize + Constants.bufferSize), Constants.cellSize, Constants.cellSize);
		}
	}
	
	//how to get keyboard inputs
	//using WASD controls
	public void keyPressed(KeyEvent e) {
//		if(game.validIn) {
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
			}
//			game.validIn = false;
//		}
	}
	
//	public void keyPressed(int e) {
//		switch(e) {
//			case KeyEvent.VK_W:
//				up = !down;
//				left = false;
//				right = false;
//				break;
//			case KeyEvent.VK_A:
//				left = !right;
//				up = false;
//				down = false;
//				break;
//			case KeyEvent.VK_S:
//				down = !up;
//				left = false;
//				right = false;
//				break;
//			case KeyEvent.VK_D:
//				right = !left;
//				up = false;
//				down = false;
//				break;
//		}
//	}
}
