package juego;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Hielo {

    private SpriteJugador hielo;
	private Rectangle colision;
	private SpriteSheet sprite;
	private int direccion = 0;
	int vueltas = 0;

	public Rectangle getColision() {
		return colision;
	}

	public Hielo(String ruta, float x, float y) throws SlickException {
		sprite = new SpriteSheet("res/imagenes/hielo.png", 13, 20);
        this.hielo = new SpriteJugador(sprite, 100);
        this.hielo.setAutoUpdate(false);
        this.colision = new Rectangle(this.hielo.getPosicion_x(), this.hielo.getPosicion_y(), (float) this.hielo.getWidth(), (float) this.hielo.getHeight());

        this.hielo.setPosicion_x(50);
        this.hielo.setPosicion_y(280);
	}
    
    public void draw() {
    	if (direccion == 0) {
    		this.hielo.draw_();
    	}else {
    		this.hielo.draw();
    	}
    }

    public void update(int delta, Input entrada) throws SlickException {
        actualizarTeclado(entrada);
        sincronizarArea();
    }
    
    private void actualizarTeclado(Input entrada) throws SlickException {
    	this.hielo.setPosicion_y(this.hielo.getPosicion_y() + 0.5f);
    }
    
	public Shape getAreaColision() {
        return this.colision;
    }
    
    public void sincronizarArea() {
        this.colision.setX(this.hielo.getPosicion_x());
        this.colision.setY(this.hielo.getPosicion_y());
    }
    
    public float getIzquierdo() {
    	return this.hielo.getPosicion_x();
    }
    
    public float getDerecho() {
    	return (this.hielo.getPosicion_x() + this.hielo.getWidth());
    }
    
    public float getArriba() {
    	return this.hielo.getPosicion_y();
    }
    
    public float getAbajo() {
    	return (this.hielo.getPosicion_y() + this.hielo.getHeight());
    }
    
    public void setX(float posicion_x) {
    	this.hielo.setPosicion_x(posicion_x);
    }
    
    public void setY(float posicion_y) {
    	this.hielo.setPosicion_y(posicion_y);
    }
}