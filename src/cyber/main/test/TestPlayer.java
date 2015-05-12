package cyber.main.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import cyber.main.Camera;
import cyber.main.Entity;
import cyber.main.Main;
import cyber.main.TextureBank;
import cyber.main.Util;

public class TestPlayer extends Entity {
	float r = 0f;
	float rfriction = 0.8f;
	float rr = 110f;
	float speed = 0.1f;
	public TestPlayer(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.TEST);
		friction = 0.01f;
	}

	@Override
	public void tick() {
		Camera camera = Main.getCurrentScene().camera;
		if(r > 0){
			if(r - rfriction < 0){
				r = 0;
			}else{
				r -= rfriction;
			}
		}
		
		if(r < 0){
			if(r + rfriction > 0){
				r = 0;
			}else{
				r += rfriction;
			}
		}
		
		if(camera.fov > 45.0f){
			if(camera.fov - rfriction < 0){
				camera.fov = 45.0f;
			}else{
				camera.fov -= rfriction;
			}
		}
		
		if(camera.fov < 45.0f){
			if(camera.fov + rfriction > 0){
				camera.fov = 45.0f;
			}else{
				camera.fov += rfriction;
			}
		}
		

		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			addForce(new Vector3f(-0.015f,0,0));
			r += 2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			addForce(new Vector3f(0.015f,0,0));
			r -= 2f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			addForce(new Vector3f(0,-0.015f,0));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			addForce(new Vector3f(0,0.015f,0));
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			addForce(new Vector3f(0,0,-0.1f));
			camera.fov += 1f;
		}
		
		z -= speed;
		
		Main.getCurrentScene().camera.z = z+4f;
		Main.getCurrentScene().camera.y = y+1f;
		//Main.getCurrentScene().camera.x = x;

	}

	@Override
	public void draw() {
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(rr, 1, 0, 0);
		GL11.glRotatef(r, 0, 1, 0);
		sprite.drawCenter();
		
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
