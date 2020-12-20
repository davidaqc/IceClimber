package juego;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Juego extends BasicGameState {
	
	/**
	 * Creacion de las variables para los objetos del juego
	 */
	ArrayList<Bloque> bloques;
	private Jugador jugador;
	private Ave ave;
	private Input entrada;
	private Image fondo;
	
	
	/**
	 * Elementos que necesita la funcion para mover el mapa cuando los personajes suben
	 */
	boolean subio_nivel = false;
	boolean done = false;
	int altura = 0;
	
	
    /**Init:
	 * Inicializa los objetos, tomando las imagenes y sus posiciones iniciales
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.fondo = new Image("res/imagenes/mapa_nivel_1.png");
		this.jugador = new Jugador("res/imagenes/popo.png", 450, 412);
		this.ave = new Ave("res/imagenes/popo.png", 0, 412);
		this.bloques = new ArrayList<Bloque>();	
		
		this.nivel1();
		this.entrada = container.getInput();
    }


    /**Render:
     * Función que es encargada de dibujar en pantallas la posición de los elementos del juego}
     */
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	this.fondo.draw(0.0f, (float) container.getHeight() - this.fondo.getHeight() + altura);
    	this.jugador.draw(); 	
    	this.ave.draw();
    	
    	
    	/**
    	 * Verifica la altura del jugador para desplazar el nivel hacia arriba 
    	 */
    	if(this.jugador.getArriba() == 176){
    		subio_nivel = true;
    		System.out.println("sas");
    		done = true;
    		altura += 93;
    		int redimensionar_bloques = this.bloques.size();
    		for (int i = 0; i < redimensionar_bloques; i++) {
    			Bloque bloque1 = new Bloque(this.bloques.get(i).getRuta_(), this.bloques.get(i).getIzquierdo(), this.bloques.get(i).getArriba() + 93);
    			this.bloques.add(bloque1);
    		}    		
    		for (int i = 0; i < redimensionar_bloques; i++) {
    			this.bloques.remove(0);
    		}
    		this.jugador.setNivel_piso(500);
    		this.jugador.setY(this.jugador.getArriba() + 93);
    	}
	
    	
		for (int i=0; i<this.bloques.size(); i++) {
			this.bloques.get(i).draw();
		}	
		
    }

    /** Update:
     * 	Función que actualiza el estado de ciertos componentes del juego, como el movimiento del jugador y de los enemigos, las colisiones entre ellos, etc. 
     */
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		this.jugador.update(delta, this.entrada);
		this.ave.update(delta, this.entrada);
		
		if (this.jugador.getColision().intersects(this.ave.getAreaColision())) {
			//System.out.println("Colisiono");
			cliente.enviarMensaje("restaVida\0");
		}

		if(subio_nivel == true && this.jugador.sobre_piso == false && this.jugador.getArriba() == 412) {
			System.out.println("Game Over");
			//cliente.enviarMensaje("restaVida\0");
		}

		boolean control_bloques = false;
		for (int i=0; i<this.bloques.size(); i++){

			if (this.jugador.getColision().intersects(this.bloques.get(i).getColision())) {
				
				float jugador_colisiona_el_lado_superior_del_objeto = this.jugador.getAbajo() - this.bloques.get(i).getArriba();
				float jugador_colisiona_el_lado_inferior_del_objeto = this.jugador.getAbajo() - this.bloques.get(i).getArriba();
				float jugador_colisiona_el_lado_izquiero_del_objeto = this.jugador.getIzquierdo() - this.bloques.get(i).getDerecho();
				float jugador_colisiona_el_lado_derecho_del_objeto = this.jugador.getIzquierdo() - this.bloques.get(i).getDerecho();
				
				if(jugador_colisiona_el_lado_izquiero_del_objeto >= -2 && this.jugador.jumping || jugador_colisiona_el_lado_izquiero_del_objeto >= -2 && this.jugador.sobre_piso == false) {
					this.jugador.setX(this.jugador.getIzquierdo() + 1.5f);
				}
				else if(jugador_colisiona_el_lado_derecho_del_objeto >= -50 && jugador_colisiona_el_lado_derecho_del_objeto <= -40 && this.jugador.jumping
						|| jugador_colisiona_el_lado_derecho_del_objeto >= -50 && jugador_colisiona_el_lado_derecho_del_objeto <= -40 && this.jugador.sobre_piso == false) {
					this.jugador.setX(this.jugador.getIzquierdo() - 1.5f);
				}
				else if(jugador_colisiona_el_lado_superior_del_objeto <= 1) {
					this.jugador.setY(this.jugador.getArriba());
					this.jugador.setNivel_piso( (int)this.jugador.getArriba());
					this.jugador.sobre_piso = true;
					control_bloques = true;
				}
				else if(jugador_colisiona_el_lado_inferior_del_objeto >= 58 && jugador_colisiona_el_lado_inferior_del_objeto <= 60) {
					this.jugador.jumping = false;
					this.jugador.jumping_2 = true;					
					this.bloques.remove(this.bloques.get(i));
					cliente.enviarMensaje("hielo\0");
					this.jugador.sobre_piso = false;
				}
			
			}else {
				if(i == this.bloques.size() - 1 && !(this.jugador.sobre_piso == true && control_bloques == true) && this.jugador.jumping_2 ) {
					this.jugador.sobre_piso = false;
					this.jugador.setNivel_piso(412);	
				}
			}
		}
    }

    /**getID:
     * retorna el ID del gamestate
     */
    public int getID() {
        return 1;
    }
    
    /**nivel1: 
     * Función que crea todas las filas de bloques del nivel, y las introduce en una lista para su fácil manejo 
     * @throws SlickException
     */
	public void nivel1() throws SlickException {
		
		// Piso 1
		int suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/green_block.png", suma, 455);
			this.bloques.add(bloque1);
		}
		
		// Piso 2
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/green_block.png", suma, 362);
			this.bloques.add(bloque1);
		}

		// Piso 3
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/brown_block.png", suma, 269);
			this.bloques.add(bloque1);
		}
		
		// Piso 4
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/brown_block.png", suma, 176);
			this.bloques.add(bloque1);
		}
		
		// Piso 5
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/brown_block.png", suma, 83);
			this.bloques.add(bloque1);
		}
		
		// Piso 6
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/blue_block.png", suma, -10);
			this.bloques.add(bloque1);
		}
		
		// Piso 7
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/blue_block.png", suma, -103);
			this.bloques.add(bloque1);
		}
		
		// Piso 8
		suma = 0;
		for (int i=0; i<28; i++) {
			suma = i * 20;
			Bloque bloque1 = new Bloque("res/imagenes/blue_block.png", suma, -196);
			this.bloques.add(bloque1);
		}
	}

}