package cyber.main;

import org.lwjgl.util.vector.Vector3f;

public abstract class Entity extends Instance {

	public float dx, dy, dz = 0f;
	public float friction = 0.04f;
	
	public Entity(float x, float y, float z) {
		super(x, y, z);
		
	}
	
	public void update(){
		updatePhysics();
		tick();
		draw();
	}
	
	
	
	public void updatePhysics(){
		x += dx;
		y += dy;
		z += dz;

		dx = applyFriction(dx);
        dy = applyFriction(dy);
        dz = applyFriction(dz);
	}
	
	 public float applyFriction(float axis){
	      if(axis > 0){
	          if(axis - friction < 0){
	              return 0;
	          }else{
	              return axis - friction;
	          }
	      }
	      if(axis < 0){
	          if(axis + friction > 0){
	              return 0;
	          }else{
	              return axis + friction;
	          }
	      }
	      return 0f;
	    }
	
	public void addForce(Vector3f vector){
		dx += vector.getX();
		dy += vector.getY();
		dz += vector.getZ();
	}
	

}