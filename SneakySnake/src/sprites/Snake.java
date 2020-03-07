package sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.*;

public class Snake extends JPanel{
	
	private Game game;
	
	ArrayList<Integer> xSet = new ArrayList<Integer>(), ySet = new ArrayList<Integer>();
	
	private int size = 3;
	
	private boolean up = false, down = false, left = false, right = true;
	
	public Snake(Game g) {
		game = g;
		xSet.add(Constants.headStart_x);
		ySet.add(Constants.headStart_y);
	}
	
	public void move() {
		for(int i = 0; i < xSet.size(); i++) {
			if(up) {
				ySet.set(i, ySet.get(i) - 1);
			}
			else if(down) {
				ySet.set(i, ySet.get(i) + 1);
			}
			else if(left) {
				xSet.set(i, xSet.get(i) - 1);
			}
			else if(right) {
				xSet.set(i, xSet.get(i) + 1);
			}
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
				up = true;
				down = false;
				left = false;
				right = false;
				break;
			case KeyEvent.VK_A:
				up = false;
				down = false;
				left = true;
				right = false;
				break;
			case KeyEvent.VK_S:
				up = false;
				down = true;
				left = false;
				right = false;
				break;
			case KeyEvent.VK_D:
				up = false;
				down = false;
				left = false;
				right = true;
				break;
		}
	}
}
