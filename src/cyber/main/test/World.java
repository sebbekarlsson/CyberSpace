package cyber.main.test;

import cyber.main.Scene;

public class World extends Scene {

	@Override
	public void init() {
		instantiate(new TestPlayer(0,-1f,-5f));
		
	}

}
