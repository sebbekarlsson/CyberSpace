package cyber.main;

import java.util.ArrayList;

import org.lwjgl.util.Color;

public abstract class Scene {
	public ArrayList<Instance> instances = new ArrayList<Instance>();
	public Color backgroundColor = new Color(0,0,0);
	public boolean init = false;
	public Camera camera = new Camera();
	
	public abstract void init();
	
	public void update(){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			instance.update();
		}
		tick();
		draw();
	}
	
	public void instantiate(Instance instance){
		instance.onInstantiate();
		instances.add(instance);
	}
	
	public void destroy(Instance instance){
		instance.onDestroy();
		instances.remove(instance);
	}
	
	public abstract void tick();
	public abstract void draw();
}
