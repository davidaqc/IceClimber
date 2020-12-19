package juego;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteBloque extends Image {
	
    private float posicion_x;
    private float posicion_y;

    public SpriteBloque(String ruta, float x, float y) throws SlickException {
        super(ruta);
		posicion_x = x;
		posicion_y = y;
    }

    public void draw() {
        super.draw(this.posicion_x, this.posicion_y);
    }
    
	public float getPosicion_x() {
		return posicion_x;
	}
	
	public float getPosicion_y() {
		return posicion_y;
	}

	public void setPosicion_x(float posicion_x) {
		this.posicion_x = posicion_x;
	}

	public void setPosicion_y(float posicion_y) {
		this.posicion_y = posicion_y;
	}
		
}
