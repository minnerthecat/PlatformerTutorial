package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;
/*
 * Class that controls drawing the game within the window.
 */

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private Game game;
	
	public GamePanel(Game game) {
		this.game = game;
		mouseInputs = new MouseInputs(this);
		KeyboardInputs keyboardInputs = new KeyboardInputs(this);
		
		setPanelSize();
		
		addKeyListener(keyboardInputs);
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("Size: " + GAME_WIDTH + " x " + GAME_HEIGHT);
	}
	
	public void updateGame() {

	}
	
	// Override paintComponent from JComponent superclass
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	
	public Game getGame() {
		return game;
	}
}
