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
    	//addState(new Menu());
    	addState(new Juego());
    }
    
    
    /** main 
     * Crea los hilos del cliente y del servidor, para correr el juego y la recepcion y envio de mensajes hacia el servidor en paralelo
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
				
        Thread hilo_cliente = new ProcesoCliente("proceso cliente");
        Thread hilo_server = new ProcesoServer("proceso server");
        
        hilo_cliente.start();
        hilo_server.start();
        
        
	}

}
