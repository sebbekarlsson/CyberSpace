package cyber.main.test;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import cyber.main.Entity;
import cyber.main.Main;

public class Star extends Entity {
	public Color color = new Color(255,255,255);
	
	public Star(float x, float y, float z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(z > Main.getCurrentScene().camera.z){
			Main.getCurrentScene().destroy(this);
		}
		
	}

	@Override
	public void draw() {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glColor3f(color.getRed()/255, color.getGreen()/255, color.getBlue()/255);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glVertex2f(0, 0);
		GL11.glEnd();
		GL11.glPopMatrix();
		
	}

	@Override
	public void onInstantiate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

}
