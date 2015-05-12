package cyber.main.test;

import java.util.Random;

import org.lwjgl.util.Color;
import org.lwjgl.util.glu.GLU;

import cyber.main.Scene;
import cyber.main.entities.Player;
import cyber.main.instances.tile.GroundTile;
import cyber.main.instances.tile.TileType;


public class World extends Scene {

	Random random = new Random();
	private Player player = new Player(0,0,0);
	
	@Override
	public void init() {
		instantiate(player);
		backgroundColor = new Color(111,210,237);
		
		float w_width = 4*9;
		float w_length = 4*64;
		
		for(int x = 0; x < w_width; x++){
			for(int y = 0; y < w_length; y++ ){
				GroundTile tile = new GroundTile((x*4)-(w_width*4)/2, -7f, (y*4)-(w_width*4), TileType.WATER);
				instantiate(tile);
			}
		}
	}

	@Override
	public void tick() {
		camera.z = player.z+4f;
		camera.y = player.y+1f;
	
	}

	@Override
	public void draw() {

	}
	
	public Player getPlayer(){
		return this.player;
	}

}
