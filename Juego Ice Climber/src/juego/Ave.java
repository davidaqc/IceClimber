package juego;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Ave {
	
    private SpriteJugador ave;
	private Rectangle colision;
	private SpriteSheet sprite;
	private int direccion = 0;
	int vueltas = 0;

	public Rectangle getColision() {
		return colision;
	}

	public Ave(String ruta, float x, float y) throws SlickException {
		sprite = new SpriteSheet("res/imagenes/spriteSheetAve.png", 41, 42);
        this.ave = new SpriteJugador(sprite, 100);
        this.ave.setAutoUpdate(false);
        this.colision = new Rectangle(this.ave.getPosicion_x(), this.ave.getPosicion_y(), (float) this.ave.getWidth(), (float) this.ave.getHeight());

        this.ave.setPosicion_x(50);
        this.ave.setPosicion_y(486 - y * 93);
	}
    
    public void draw() {
    	if (direccion == 0) {
    		this.ave.draw_();
    	}else {
    		this.ave.draw();
    	}
    }

    public void update(int delta, Input entrada) throws SlickException {
        actualizarTeclado(entrada);
        sincronizarArea();
    }
    
    private void actualizarTeclado(Input entrada) throws SlickException {
    	
    	if(this.ave.getPosicion_x() == 50) {
    		direccion = 0;
    		vueltas += 1;
    		if(vueltas == 3) {
    			this.ave.setPosicion_x(-1000);
    		}
    	}
    	
    	if(this.ave.getPosicion_x() >= 50 && this.ave.getPosicion_x() <= 420 && direccion == 0) {
        	this.ave.setPosicion_x(this.ave.getPosicion_x() + 0.5f);
    	}else {
    		direccion = 1;
    		this.ave.setPosicion_x(this.ave.getPosicion_x() - 0.5f);
    	}
    	
    	if(this.ave.getPosicion_x() >= 235) {
    		this.ave.setPosicion_y(this.ave.getPosicion_y() + 0.07f);
    	}else {
    		this.ave.setPosicion_y(this.ave.getPosicion_y() - 0.07f);
    	}
    	
    	this.ave.update(2);
		
    }
    
	public Shape getAreaColision() {
        return this.colision;
    }
    
    public void sincronizarArea() {
        this.colision.setX(this.ave.getPosicion_x());
        this.colision.setY(this.ave.getPosicion_y());
    }
    
    public float getIzquierdo() {
    	return this.ave.getPosicion_x();
    }
    
    public float getDerecho() {
    	return (this.ave.getPosicion_x() + this.ave.getWidth());
    }
    
    public float getArriba() {
    	return this.ave.getPosicion_y();
    }
    
    public float getAbajo() {
    	return (this.ave.getPosicion_y() + this.ave.getHeight());
    }
    
    public void setX(float posicion_x) {
    	this.ave.setPosicion_x(posicion_x);
    }
    
    public void setY(float posicion_y) {
    	this.ave.setPosicion_y(posicion_y);
    }

}
