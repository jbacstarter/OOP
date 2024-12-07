package Helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Draw {

	public static BufferedImage getLogo() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(logo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}



	private static URL logo = Draw.class.getResource("/Resources/appLogo.png");

}
