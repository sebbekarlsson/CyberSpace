package cyber.main.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import cyber.main.TextureBank;

public class Player extends AirPlane {
	
	public Player(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.AIRPLANE_PLAYER);
		friction = 0.01f;
	}

	@Override
	public void tick() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			addForce(new Vector3f(-0.015f,0,0));
			zrot += 2f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			addForce(new Vector3f(0.015f,0,0));
			zrot -= 2f;
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
		drawPlane();
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
