package cyber.main;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


public class Camera {
	public float x,y,z = 0f;
	public float fov = 90.0f;
	public float xrot = 20f;

	
	public void update(){
		tick();
		draw();
	}
	
	public void tick(){

	}
	
	public void draw(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		GLU.gluPerspective((float)fov,((float)(Display.getWidth())) / ((float)(Display.getHeight())), 0.001f, 1000f);
		//GL11.glRotatef(xrot, 1, 0, 0);
	}
}
