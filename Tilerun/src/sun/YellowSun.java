package sun;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class YellowSun implements Sun {
	private static BufferedImage sun;
	private static boolean sunImgRenderNeeded = true;
	
	public BufferedImage getSunImg() {
		if (sunImgRenderNeeded) {
			try {
				sun = ImageIO.read(getClass().getClassLoader().getResource("Sun.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sunImgRenderNeeded = false;
		}

		return sun;
	}

}
