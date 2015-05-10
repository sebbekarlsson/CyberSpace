package cyber.main;

import org.lwjgl.util.Color;



public class Object {
	public float x,y,z = 0f;
	public Color color = new Color(1,1,1);
	
	public Object(float x, float y, float z, Color color){
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = color;
	}
}
