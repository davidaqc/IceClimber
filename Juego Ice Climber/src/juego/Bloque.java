package juego;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bloque {

	private SpriteBloque bloque;
	private Rectangle colision;
	private String ruta_;

    public Bloque(String ruta, float x, float y) throws SlickException {
    	this.ruta_ = ruta;
        this.bloque = new SpriteBloque(ruta, x, y);
        this.colision = new Rectangle(this.bloque.getPosicion_x(), this.bloque.getPosicion_y(), (float) this.bloque.getWidth(), (float) this.bloque.getHeight());
    }
    
    public String getRuta_() {
		return ruta_;
	}

	public void setRuta_(String ruta_) {
		this.ruta_ = ruta_;
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
    
    public void setY(float f) {
    	this.bloque.setPosicion_y(f);
    }
}
   

