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
		if(xSet.size() >= size + 1) {
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
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.GREEN);
		for(int i = 0; i < xSet.size(); i++) {
			g.fillRect(xSet.get(i) * Constants.cellSize, ySet.get(i) * Constants.cellSize, Constants.cellSize, Constants.cellSize);
		}
	}
	
	//how to get keyboard inputs
	//using WASD controls
	public void keyPressed(KeyEvent e) {
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
	}
}
