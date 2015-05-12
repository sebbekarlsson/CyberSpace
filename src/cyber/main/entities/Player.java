package cyber.main.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import cyber.main.Entity;
import cyber.main.TextureBank;

public class Player extends Entity {
	float r = 0f;
	float rfriction = 0.8f;
	float rr = 110f;
	float speed = 0.1f;
	public Player(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.AIRPLANE_PLAYER);
		friction = 0.01f;
	}

	@Override
	public void tick() {
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
		}
		
		z -= 0.2f;

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
