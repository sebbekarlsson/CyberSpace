package cyber.main.entities;

import org.lwjgl.opengl.GL11;

import cyber.main.Entity;

public abstract class AirPlane extends Entity {
	float zrot = 0f;
	float zrotfriction = 0.8f;
	
	public AirPlane(float x, float y, float z) {
		super(x, y, z);
	}
	
	public void update(){
		
		if(zrot > 0){
			if(zrot - zrotfriction < 0){
				zrot = 0;
			}else{
				zrot -= zrotfriction;
			}
		}
		
		if(zrot < 0){
			if(zrot + zrotfriction > 0){
				zrot = 0;
			}else{
				zrot += zrotfriction;
			}
		}
		
		updatePhysics();
		tick();
		draw();
	}
	
	public void drawPlane(){
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(zrot, 0, 0, 1);
		sprite.drawCenter();
		
		GL11.glPopMatrix();
	}

}
