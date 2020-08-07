package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import hill.DefaultHill;
import sun.Sun;
import sun.YellowSun;

public class Background {

	private static BufferedImage background;
	private static boolean backgroundImgRenderNeeded = true;

	protected static DefaultHill hill = new DefaultHill();
	protected static Sun yellowSun = new YellowSun();

	public void backgroundRender(Graphics g) {
		if (backgroundImgRenderNeeded) {
			background = new BufferedImage(900, 800, BufferedImage.TYPE_INT_RGB);
			backgroundImgRenderNeeded = false;
		}
		g = background.createGraphics();
		g.drawImage(getBackgroundColorImg(), 0, 0, null);
		
		g.drawImage(yellowSun.getSunImg(), 20, 20, null);
		g.drawImage(getDirtGrassImg(), 0, 730, null);
		

	}
	
	private BufferedImage getBackgroundColorImg() {
		BufferedImage backgroundColor = null;
		try {
			backgroundColor = ImageIO.read(getClass().getClassLoader().getResource("Background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return backgroundColor;
	}
	
	private BufferedImage getDirtGrassImg() {
		BufferedImage dirtGrass = null;
		try {
			dirtGrass = ImageIO.read(getClass().getClassLoader().getResource("Dirt & Grass.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dirtGrass;
	}

	public BufferedImage getBackgroundImg() {
		return background;
	}

}
