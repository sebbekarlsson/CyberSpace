package cyber.main.scenes;

import java.util.Random;

import org.lwjgl.util.Color;

import cyber.main.Scene;
import cyber.main.Util;
import cyber.main.entities.Cloud;
import cyber.main.entities.Player;


public class World extends Scene {

	Random random = new Random();
	private Player player = new Player(0,0,0);
	
	@Override
	public void init() {
		instantiate(player);
		backgroundColor = new Color(111,210,237);
	}

	@Override
	public void tick() {
		if(random.nextInt(10) == 0){
			instantiate(new Cloud((camera.x+random.nextFloat()*64)*Util.chooseInt(1, -1), camera.y-7f, camera.z-64f));
		}
		
		camera.z = player.z+3f;
		camera.y = player.y+2.5f;
	
	}

	@Override
	public void draw() {

	}
	
	public Player getPlayer(){
		return this.player;
	}

}
