package cyber.main;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

public class Main {
	public static int WIDTH = 640;
	public static int HEIGHT = 640 / 16 * 9;
	public static int SCALE = 2;
	public static ArrayList<Object> points = new ArrayList<Object>();
	public static Random random = new Random();
	
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
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
		
		Camera camera = new Camera();
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		GLU.gluPerspective((float)45.0f,((float)(Display.getWidth())) / ((float)(Display.getHeight())), 0.001f, 1000f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glLoadIdentity();


		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT );
			GL11.glLoadIdentity();
			GL11.glClearColor(0, 0, 0, 1);
			
			for(int i = 0; i < 255; i++)
			points.add(new Object(camera.x-(random.nextFloat()*32)*Util.chooseInt(1,-1), camera.y-(random.nextFloat()*32)*Util.chooseInt(1,-1), camera.z-(random.nextFloat()*100), new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255))));

			
			//if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
				camera.z -= 1f;
			//}
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
				camera.z += 0.3f;
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
				camera.x -= 0.1f;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
				camera.x += 0.1f;
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
				camera.y += 0.1f;
			}
			
			
			
			
			GL11.glPushMatrix();
			GL11.glTranslatef(-camera.x, -camera.y, -camera.z);
			GL11.glColor3f(1, 0, 0);
			GL11.glBegin(GL11.GL_POINTS);
			
			
			for(int i = 0; i < points.size(); i++){
				Object point = points.get(i);
				
				
				GL11.glColor3f((float)point.color.getRed()/255, (float)point.color.getGreen()/255, (float)point.color.getBlue()/255);

				GL11.glVertex3f((float)point.x, (float)point.y, (float)point.z);
				
				if(point.z > camera.z){
					points.remove(point);
				}
				
			}
			
			GL11.glEnd();
			
			GL11.glPopMatrix();
			
			
			
			
			Display.sync(60);
			Display.update();
		}
	}
}
