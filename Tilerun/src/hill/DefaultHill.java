package hill;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DefaultHill {

	public BufferedImage getHillImg() {
		BufferedImage hill = null;
		try {
			hill = ImageIO.read(getClass().getClassLoader().getResource("Hill.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hill;
	}
}
