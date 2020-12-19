package juego;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class SpriteJugador extends Animation {
	
    private float posicion_x;
    private float posicion_y;

    public SpriteJugador(SpriteSheet frames, int duration) {
		super(frames, duration);
		posicion_x = 450;
		posicion_y = 412;
	}

    public void draw() {
        super.draw(this.posicion_x, this.posicion_y);
    }
    
    public void draw_() {
    	super.getCurrentFrame().getFlippedCopy(true, false).draw(this.posicion_x, this.posicion_y);
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
