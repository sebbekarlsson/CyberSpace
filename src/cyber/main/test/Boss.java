package cyber.main.test;

import org.lwjgl.opengl.GL11;

import cyber.main.Entity;
import cyber.main.Main;
import cyber.main.TextureBank;

public class Boss extends Entity {
	public float rot = 0f;
	public Boss(float x, float y, float z) {
		super(x, y, z);
		sprite.textures.add(TextureBank.ANDROSS);
	}

	@Override
	public void tick() {
		if(z > Main.getCurrentScene().camera.z){
			Main.getCurrentScene().destroy(this);
		}
		rot += 10f;
	}

	@Override
	public void draw() {
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(rot, 1, 0, 0);
		GL11.glRotatef(rot, 0, 1, 0);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
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
