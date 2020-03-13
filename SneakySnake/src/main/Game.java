package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sprites.*;


public class Game extends JPanel{
	
	//components in this game
	public Snake snake;
	public Apple apple;
	
	//boolean that is used to prevent the turn around death thing (should the snake move in the main move method)
	public boolean noInput = true;
	
	public Game() {
		//style preference... i like my dark mode games
		setBackground(Color.DARK_GRAY);
		
		//initializing the game components
		apple = new Apple();
		snake = new Snake(this);
		
		//getting keyboard inputs and generally looking nasty
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
		
		//very important...keyboard stuff wont work without this
		setFocusable(true);
	}
	
	//make everything appear all pretty
	public void paint(Graphics g) {
		//clear the last paint and recast a variable
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//make the components show up
		apple.paint(g2);
		snake.paint(g2);
	}
	
	//updates the positions of game components
	public void move() {
		snake.move();
	}
	
	//what happens when you die/fail/lose
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	//where everything happens
	//also YEET the exceptions
	public static void main(String[] args) throws InterruptedException{
		//initial declarations
		JFrame frame = new JFrame("Snake");
		Game game = new Game();
		
		//setting the frame size and combining the things
		game.setPreferredSize(new Dimension(Constants.boardSize * Constants.cellSize + Constants.bufferSize * (Constants.boardSize - 1), Constants.boardSize * Constants.cellSize + Constants.bufferSize * (Constants.boardSize - 1)));
		frame.getContentPane().add(game);
		frame.pack();
		
		//basic frame stuff such as making it show up
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//core loop
		while(true) {
			//HERE IS WHERE THAT VERY IMPORTANT BOOLEAN FROM BEFORE IS USED
			if(game.noInput) {
				game.move();
			}
			game.noInput = true;
			game.repaint();
			//why we need to yeet in the method head
			Thread.sleep(Constants.tick);
		}
	}
}
