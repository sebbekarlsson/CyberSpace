package cyber.main;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;


public class Sprite {
	public ArrayList<Texture> textures = new ArrayList<Texture>();
	public int textureIndex = 0;
	
	public Texture getCurrent(){
		return textures.get(textureIndex);
	}
	
	public void draw(){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		Texture t = getCurrent();
		t.bind();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(0, 0, 0);
			
			GL11.glTexCoord2f(t.getWidth(), 0);
			GL11.glVertex3f(t.getWidth(), 0, 0);
			
			GL11.glTexCoord2f(t.getWidth(), t.getHeight());
			GL11.glVertex3f(t.getWidth(), t.getHeight(), 0);
			
			GL11.glTexCoord2f(0, t.getHeight());
			GL11.glVertex3f(0, t.getWidth(), 0);
			
			
		GL11.glEnd();
	}
	
	public void drawCenter(){
		Texture t = getCurrent();
		t.bind();
		GL11.glColor3f(1, 1, 1);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(-t.getWidth()/2, -t.getHeight()/2, 0);
			
			GL11.glTexCoord2f(t.getWidth(), 0);
			GL11.glVertex3f(t.getWidth()/2, -t.getHeight()/2, 0);
			
			GL11.glTexCoord2f(t.getWidth(), t.getHeight());
			GL11.glVertex3f(t.getWidth()/2, t.getHeight()/2, 0);
			
			GL11.glTexCoord2f(0, t.getHeight());
			GL11.glVertex3f(-t.getWidth()/2, t.getHeight()/2, 0);
			
			
		GL11.glEnd();
	}
}
