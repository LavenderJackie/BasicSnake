package main;

import javax.swing.*;

import sprites.*;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel{
	
	public Snake snake;
	public Apple apple;
	
	public Game() {
		setBackground(Color.DARK_GRAY);
		
		apple = new Apple();
		snake = new Snake(this);
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		apple.paint(g2);
		snake.paint(g2);
	}
	
	public void move() {
		snake.move();
	}
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Snake");
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(Constants.boardSize * Constants.cellSize, Constants.boardSize * Constants.cellSize));
		frame.getContentPane().add(game);
		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(Constants.tick);
		}
	}
}
