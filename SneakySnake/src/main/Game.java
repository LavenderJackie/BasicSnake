package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
	
	public Game() {
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
	public void move() {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake");
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(Constants.boardSize * 10, Constants.boardSize * 10));
		frame.add(game);
		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
