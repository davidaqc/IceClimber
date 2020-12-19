package juego;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class ProcesoServer extends Thread{
	
	public ProcesoServer(String msg) {
		super(msg);
	}
	
	public void run() {
		
        try {
            AppGameContainer app = new AppGameContainer(new Principal());
            app.setDisplayMode(520, 480, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException slick) {
            slick.printStackTrace();
        }
        
	}

}
