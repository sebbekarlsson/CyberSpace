package cyber.main.entities;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import cyber.main.Entity;
import cyber.main.Main;
import cyber.main.TextureBank;
import cyber.main.Util;

public class Cloud extends Entity {
	Random random = new Random();
	public Cloud(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.CLOUD);
	}

	@Override
	public void tick() {
		if(z > Main.getCurrentScene().camera.z){
			Main.getCurrentScene().destroy(this);
		}
		
		if(random.nextInt(32) == 0){
			addForce(new Vector3f(random.nextFloat()*Util.chooseInt(1, -1), random.nextFloat()*Util.chooseInt(1, -1), random.nextFloat()*Util.chooseInt(1, -1)));
		}
		
	}

	@Override
	public void draw() {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTranslatef(x, y, z);
		GL11.glScalef(16, 16, 16);
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
