package juego;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Jugador{
	
    private SpriteJugador jugador;
	boolean jumping;
	boolean jumping_2;
	private Rectangle colision;
	private int nivel_piso = 455;
	private int altura_del_salto = 120;	
	boolean sobre_piso = true;

	public Rectangle getColision() {
		return colision;
	}

	public Jugador(String ruta, float x, float y) throws SlickException {
        this.jugador = new SpriteJugador(ruta, x, y);
        this.colision = new Rectangle(this.jugador.getPosicion_x(), this.jugador.getPosicion_y(), (float) this.jugador.getWidth(), (float) this.jugador.getHeight());
    }
    
    public void draw() {
        this.jugador.draw();
    }

    public void update(int delta, Input entrada) throws SlickException {
        actualizarTeclado(entrada);
        sincronizarArea();
    }
    
    private void actualizarTeclado(Input entrada) throws SlickException {
    	
        if (entrada.isKeyDown(Input.KEY_LEFT)) {
        	this.jugador.setPosicion_x(this.jugador.getPosicion_x() - 0.4f);
        	if(this.jugador.getPosicion_x() < -10) {
        		this.jugador.setPosicion_x(520);
        	}
        } 
        
        if (entrada.isKeyDown(Input.KEY_RIGHT)) {
        	this.jugador.setPosicion_x(this.jugador.getPosicion_x() + 0.4f);
        	if(this.jugador.getPosicion_x() > 520) {
        		this.jugador.setPosicion_x(-10);
        	}
        }
        
		if( entrada.isKeyPressed(Input.KEY_UP) && !jumping && this.jugador.getPosicion_y() >= nivel_piso){
			jumping=true;
			jumping_2 = false;


		}
		
		if (jumping) {
			if(this.jugador.getPosicion_y() < 100) {
				System.out.println("Moer");
			}
			this.jugador.setPosicion_y(this.jugador.getPosicion_y() - 0.5f);
			if(this.jugador.getPosicion_y() <= nivel_piso - altura_del_salto) {
				jumping=false;
				sobre_piso = false;
			}
		}
			
		if (this.jugador.getPosicion_y() <= nivel_piso - altura_del_salto){
			this.jugador.setPosicion_y(this.jugador.getPosicion_y());
			jumping_2 = true;
		}

		if (this.jugador.getPosicion_y() != nivel_piso) {
			if (jumping_2) {
				this.jugador.setPosicion_y(this.jugador.getPosicion_y() + 0.5f);
			}
		}
		
    }
    
    public int getNivel_piso() {
		return nivel_piso;
	}

	public void setNivel_piso(int nivel_piso) {
		this.nivel_piso = nivel_piso;
	}

	public Shape getAreaColision() {
        return this.colision;
    }
    
    public void sincronizarArea() {
        this.colision.setX(this.jugador.getPosicion_x());
        this.colision.setY(this.jugador.getPosicion_y());
    }
    
    public float getIzquierdo() {
    	return this.jugador.getPosicion_x();
    }
    
    public float getDerecho() {
    	return (this.jugador.getPosicion_x() + this.jugador.getWidth());
    }
    
    public float getArriba() {
    	return this.jugador.getPosicion_y();
    }
    
    public float getAbajo() {
    	return (this.jugador.getPosicion_y() + this.jugador.getHeight());
    }
    
    public void setX(float posicion_x) {
    	this.jugador.setPosicion_x(posicion_x);
    }
    
    public void setY(float posicion_y) {
    	this.jugador.setPosicion_y(posicion_y);
    }

}
