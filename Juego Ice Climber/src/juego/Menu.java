package juego;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
    private static final Punto JUGADOR1;
    private static final Punto JUGADOR2;
    private static final Punto JUGADOR3;
    private Sprite botonJugador1;
    private Sprite botonJugador2;
    private Sprite botonJugador3;
    private Image logo;
    private int indicador;
    private Sprite puntero;

    static {
    	JUGADOR1 = new Punto(130.0f, 190.0f);
    	JUGADOR2 = new Punto(130.0f, 240.0f);
    	JUGADOR3 = new Punto(130.0f, 290.0f);
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	this.logo = new Image("res/imagenes/logo.png");
        this.botonJugador1 = new Sprite("res/imagenes/player1.png", new Punto(180.0f, 200.0f));
        this.botonJugador2 = new Sprite("res/imagenes/player2.png", new Punto(180.0f, 250.0f));
        this.botonJugador3 = new Sprite("res/imagenes/player3.png", new Punto(180.0f, 300.0f));
        this.puntero = new Sprite("res/imagenes/mazo.png", JUGADOR1);
        this.indicador = 0;
    }
    

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	this.logo.draw(120, 30);
        this.botonJugador1.draw();
        this.botonJugador2.draw();
        this.botonJugador3.draw();
        this.puntero.draw();
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input entrada = container.getInput();
        if (entrada.isKeyPressed(Input.KEY_UP)) {
        	if(this.indicador == 0) {
                this.indicador = 2;
                this.puntero.setPosicion(JUGADOR3);
        	}else if(this.indicador == 1) {
                this.indicador = 0;
                this.puntero.setPosicion(JUGADOR1);
        	}else {
                this.indicador = 1;
                this.puntero.setPosicion(JUGADOR2);
        	}
        } 
        else if (entrada.isKeyPressed(Input.KEY_DOWN)) {
        	if(this.indicador == 0) {
                this.indicador = 1;
                this.puntero.setPosicion(JUGADOR2);
        	}
        	else if(this.indicador == 1) {
        		this.indicador = 2;
                this.puntero.setPosicion(JUGADOR3);
        	}
        	else {
                this.indicador = 0;
                this.puntero.setPosicion(JUGADOR1);
        	}
        }
        else if (entrada.isKeyPressed(Input.KEY_ENTER)){
        	System.out.println("Iniciar juego con: " + this.indicador + " jugadores");
        } 
    }

    public int getID() {
        return 0;
    }
}