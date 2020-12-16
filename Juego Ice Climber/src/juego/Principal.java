package juego;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Clase Principal del juego.
 * @author David A Quesada C
 *
 */
public class Principal extends StateBasedGame {
	
    public Principal() {
    	// Titulo de la ventana
        super("Ice Climber");
    }
    
	/**
	 * Inicializar la lista de estados del juego
	 */
    public void initStatesList(GameContainer container) throws SlickException {
    	addState(new Menu());
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		cliente.conectar();
		
		
        try {
            AppGameContainer app = new AppGameContainer(new Principal());
            app.setDisplayMode(640, 480, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException slick) {
            slick.printStackTrace();
        }
        
        
	}

}
