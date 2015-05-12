package cyber.main;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {
	
	public static Texture AIRPLANE_PLAYER = loadTexture("png","graphics/airplane.png");
	public static Texture ANDROSS = loadTexture("png", "graphics/grass.png");
	public static Texture TILE_WATER = loadTexture("png", "graphics/water.png");
	
	public static Texture loadTexture(String type, String path){
		Texture t = null;
		try {
			t = TextureLoader.getTexture(type, new FileInputStream(path));
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
