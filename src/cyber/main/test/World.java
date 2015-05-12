package cyber.main.test;

import java.util.Random;

import org.lwjgl.util.Color;

import cyber.main.Scene;
import cyber.main.Util;

public class World extends Scene {

	Random random = new Random();

	@Override
	public void init() {
		instantiate(new TestPlayer(0,-1f,-5f));
	}

	@Override
	public void tick() {
		for(int i = 0; i < 32; i++){
			Star star = new Star(camera.x+(random.nextFloat()*64)*Util.chooseInt(1,-1), camera.y+(random.nextFloat()*64)*Util.chooseInt(1,-1), camera.z-((random.nextFloat()*100)));
			star.color = new Color(255, 255, 255);
			instantiate(star);
		}

		for(int i = 0; i < 16; i++){
			if(random.nextInt(20) == 0){
				Boss andross = new Boss(camera.x+(random.nextFloat()*16)*Util.chooseInt(1,-1), camera.y+(random.nextFloat()*16)*Util.chooseInt(1,-1), camera.z-((random.nextFloat()*100)));
				instantiate(andross);
			}
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
