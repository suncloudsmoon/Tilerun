package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import mainmenu.Start;
import player.Player;
import player.RobotPlayer;

public class Update extends JPanel {

	public static int x = 500;
	public static int y = 500;

	protected static boolean backgroundRenderNeeded = true;
	protected static Player player = new RobotPlayer();
	private static Background background = new Background();
	
	private Action goLeft;
	private Action goRight;
	private Action goUp;
	private Action goDown;
	private Action jump;

	public void update(Graphics g) {
		g.drawImage(background.getBackgroundImg(), 0, 0, null);
		
		if (!RobotPlayer.isGoingLeft()) {
			g.drawImage(player.getPlayerImg()[1], RobotPlayer.getPosX(), RobotPlayer.getPosY(), null);
		} else {
			g.drawImage(player.getPlayerImg()[0], RobotPlayer.getPosX(), RobotPlayer.getPosY(), null);
		}
		
		g.setColor(Color.cyan);
		g.drawString("X: " + RobotPlayer.getPosX() + " Y: " + RobotPlayer.getPosY(), 10, 10);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backgroundRenderNeeded) {
			background.backgroundRender(g);
			backgroundRenderNeeded = false;
		}
		update(g);
	}
	
	 public void move() {
		goLeft = new goLeft();
		goRight = new goRight();
		goUp = new goUp();
		goDown = new goDown();
		jump = new Jump();
		
		System.out.println("Root Pane created!");
		
		JRootPane rootPane = Start.frame.getRootPane();
		
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "goLeft");
		rootPane.getActionMap().put("goLeft", goLeft);
		
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "goRight");
		rootPane.getActionMap().put("goRight", goRight);
		
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "goUp");
		rootPane.getActionMap().put("goUp", goUp);
		
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "goDown");
		rootPane.getActionMap().put("goDown", goDown);
		
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "jump");
		rootPane.getActionMap().put("jump", jump);
	}
	
	public class Jump extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clicked on the space bar!");
			
		}
		
	}
	 
	 
	public class goLeft extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			RobotPlayer.setPosX(RobotPlayer.getPosX() - 2);
			RobotPlayer.setGoingLeft(true);
			
		}
		
	}
	
	public class goRight extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			RobotPlayer.setPosX(RobotPlayer.getPosX() + 2);
			RobotPlayer.setGoingLeft(false);
		}
		
	}
	
	public class goUp extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			RobotPlayer.setPosY(RobotPlayer.getPosY() - 2);
			
		}
		
	}
	
	public class goDown extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			RobotPlayer.setPosY(RobotPlayer.getPosY() + 2);
			
		}
		
	}

}
