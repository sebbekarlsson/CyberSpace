package cyber.main.instances.tile;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import cyber.main.Instance;
import cyber.main.Main;

public class GroundTile extends Instance {

	public TileType type;
	private float size = 4f;

	public GroundTile(float x, float y, float z, TileType type) {
		super(x, y, z);
		this.type = type;
	}

	@Override
	public void tick() {
		if(z > Main.getCurrentScene().camera.z){
			Main.getCurrentScene().destroy(this);
		}

	}

	@Override
	public void draw() {

		if(Main.getCurrentScene().camera.z - z < 100f){

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			Texture texture = type.texture;
			texture.bind();
			GL11.glTranslatef(x, y, z);

			GL11.glBegin(GL11.GL_QUADS);

			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(0, 0, 0);

			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(size, 0, 0);

			GL11.glTexCoord2f(1, 1);
			GL11.glVertex3f(size, 0, size);

			GL11.glTexCoord2f(0, 1);
			GL11.glVertex3f(0, 0, size);

			GL11.glEnd();

			GL11.glPopMatrix();

		}

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
