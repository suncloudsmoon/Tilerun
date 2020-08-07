package mainmenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.Main;
import sun.Sun;
import sun.YellowSun;

public class Start implements MouseListener {

	public static JFrame frame;
	private static JLabel backgroundImg;
	private static JLabel playButton;
	
	private static Sun yellowSun = new YellowSun();

	public Start() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		
		playButton = new JLabel();
		playButton.setBounds(300, 300, 300, 150);
		playButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Play Button.png")));
		playButton.addMouseListener(this);
		frame.getContentPane().add(playButton);

		backgroundImg = new JLabel();
		backgroundImg.setBounds(0, 0, 900, 800);
		backgroundImg.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Main Menu.png")));
		frame.getContentPane().add(backgroundImg);

		// Finalizing stuff...
		frame.setTitle("Welcome to Tilerun");
		frame.setIconImage(yellowSun.getSunImg());
		frame.setSize(900, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true); // for now
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		backgroundImg.setEnabled(false);
		playButton.setEnabled(false);
		
		// Finalizing the transition...
		frame.getContentPane().remove(backgroundImg);
		frame.getContentPane().remove(playButton);
		frame.revalidate();
		frame.repaint();
		new Main();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
