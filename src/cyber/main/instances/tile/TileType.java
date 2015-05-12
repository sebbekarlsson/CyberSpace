package cyber.main.instances.tile;

import org.newdawn.slick.opengl.Texture;

import cyber.main.TextureBank;

public enum TileType {
	
	WATER(TextureBank.TILE_WATER, false);
	
	public Texture texture;
	public boolean solid;
	
	TileType(Texture texture, boolean solid){
		this.texture = texture;
		this.solid = solid;
	}
	
	
}
