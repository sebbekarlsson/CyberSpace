package cyber.main;

public abstract class Instance {
	public float x,y,z = 0f;
	public Sprite sprite = new Sprite();
	
	public Instance(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void update(){
		tick();
		draw();
	}
	
	public abstract void tick();
	public abstract void draw();
	public abstract void onInstantiate();
	public abstract void onDestroy();
}
