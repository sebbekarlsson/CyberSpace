package cyber.main.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import cyber.main.Entity;
import cyber.main.TextureBank;

public class TestPlayer extends Entity {
	float r = 0f;
	float rfriction = 0.8f;
	public TestPlayer(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.TEST);
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
			addForce(new Vector3f(-0.02f,0,0));
			r += 2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			addForce(new Vector3f(0.02f,0,0));
			r -= 2f;
		}

	}

	@Override
	public void draw() {
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(110, 1, 0, 0);
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
