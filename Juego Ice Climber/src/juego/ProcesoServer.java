package juego;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class ProcesoServer extends Thread{
	
	/** ProcesoServer
	 * Setea el titulo de la ventana
	 * @param msg
	 */
	public ProcesoServer(String msg) {
		super(msg);
	}
	
	/**
	 * Crea el container y los parametros de la ventana en donde se corre el juego
	 */
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
