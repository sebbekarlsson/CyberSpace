package cyber.main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import cyber.main.scenes.World;

public class Main {
	public static int WIDTH = 640;
	public static int HEIGHT = 640 / 16 * 9;
	public static int SCALE = 2;
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static Random random = new Random();
	
	public static ArrayList<Scene> scenes = new ArrayList<Scene>();
	public static int SCENEINDEX = 0;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		try {
			Display.setDisplayMode(new DisplayMode((int)FRAMESIZE.getWidth(), (int)FRAMESIZE.getHeight()));
			Display.setTitle("Cyber Space");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.5f);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		
	
		GL11.glLoadIdentity();

		scenes.add(new World());
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
			GL11.glLoadIdentity();
			
			Color color = getCurrentScene().backgroundColor;
			GL11.glClearColor((float)color.getRed()/255, (float)color.getGreen()/255, (float)color.getBlue()/255, 1);
			
			
			getCurrentScene().camera.update();
			
			GL11.glPushMatrix();
			
			GL11.glTranslatef(-getCurrentScene().camera.x, -getCurrentScene().camera.y, -getCurrentScene().camera.z);
			
			if(getCurrentScene().init == false){
				getCurrentScene().init();
				getCurrentScene().init = true;
			}
			
			getCurrentScene().update();
		
	
			GL11.glPopMatrix();
			
			
			
			
			Display.sync(60);
			Display.update();
		}
	}
	
	public static Scene getCurrentScene(){
		return scenes.get(SCENEINDEX);
	}
	
	public static World getCurrentWorld(){
		return (World) scenes.get(SCENEINDEX);
	}
	
}
