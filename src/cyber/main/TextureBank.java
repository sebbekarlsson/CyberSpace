package cyber.main;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {
	
	public static Texture TEST = loadTexture("png","graphics/shiip.png");
	public static Texture ANDROSS = loadTexture("png", "graphics/wickberg.png");
	
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
