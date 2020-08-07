package player;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class RobotPlayer implements Player, Serializable {

	private static int posX = 20;
	private static int posY = 640;
	private static boolean goingLeft = false;

	private static BufferedImage[] robot = new BufferedImage[2];
	private static boolean robotLoaded = false;

	@Override
	public BufferedImage[] getPlayerImg() {
		if (robotLoaded == false) {
			try {
				robot[0] = ImageIO.read(getClass().getClassLoader().getResource("Left Player.png"));
				robot[1] = ImageIO.read(getClass().getClassLoader().getResource("Right Player.png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robotLoaded = true;
		}

		return robot;
	}

	public static boolean isGoingLeft() {
		return goingLeft;
	}

	public static void setGoingLeft(boolean goingLeft) {
		RobotPlayer.goingLeft = goingLeft;
	}

	public static int getPosX() {
		return posX;
	}

	public static void setPosX(int posX) {
		RobotPlayer.posX = posX;
	}

	public static int getPosY() {
		return posY;
	}

	public static void setPosY(int posY) {
		RobotPlayer.posY = posY;
	}

}
