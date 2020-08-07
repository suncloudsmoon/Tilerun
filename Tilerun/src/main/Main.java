package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import mainmenu.Start;

public class Main implements WindowListener {

	private static Update update = new Update();

	public Main() {
		// Initializing stuff...
		new File("C:\\Tilerun\\Untitled Tilerun World #1").mkdirs();
		startAction();
		update.move();
		Start.frame.add(update);
		Start.frame.setTitle("Tilerun");
		Start.frame.addWindowListener(this);
		Start.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Start.frame.setVisible(true);

	}

	public void startAction() {
		ActionListener start = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update.repaint();

			}

		};
		Timer repeatIt = new Timer(40, start);
		repeatIt.start();
	}

	public static void main(String[] args) {
		new Start();

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		int option = JOptionPane.showConfirmDialog(null,
				"Untitled Tilerun World #1 has unsaved changes!\nDo you want to save them?", "Unsaved Changes",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

		if (option == 0) {
			System.exit(0);
		} else if (option == 1) {
			System.exit(0);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
