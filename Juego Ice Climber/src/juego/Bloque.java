package juego;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bloque {

	private SpriteBloque bloque;
	private Rectangle colision;

    public Bloque(String ruta, float x, float y) throws SlickException {
        this.bloque = new SpriteBloque(ruta, x, y);
        this.colision = new Rectangle(this.bloque.getPosicion_x(), this.bloque.getPosicion_y(), (float) this.bloque.getWidth(), (float) this.bloque.getHeight());
    }
    
    public void draw() {
        this.bloque.draw();
    }
    
    public void update(int delta) {
        sincronizarArea();
    }

	public Rectangle getColision() {
		return colision;
	}

	public Shape getAreaColision() {
        return this.colision;
    }
    
    public void sincronizarArea() {
        this.colision.setX(this.bloque.getPosicion_x());
        this.colision.setY(this.bloque.getPosicion_y());
    }
    
    public void eliminarBloque() {
    	this.bloque.setPosicion_x(1000);
    	this.bloque.setPosicion_y(-1000);
    }
    
    public float getIzquierdo() {
    	return this.bloque.getPosicion_x();
    }
    
    public float getDerecho() {
    	return (this.bloque.getPosicion_x() + this.bloque.getWidth());
    }

    public float getArriba() {
    	return this.bloque.getPosicion_y();
    }
    
    public float getAbajo() {
    	return (this.bloque.getPosicion_y() + this.bloque.getHeight());
    }
}
   

