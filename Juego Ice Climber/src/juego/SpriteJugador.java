package juego;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class SpriteJugador extends Animation {
	
    private float posicion_x;
    private float posicion_y;

    /** SpriteJugador
     * Constructor de SpriteJugador
     * @param frames
     * @param duration
     */
    public SpriteJugador(SpriteSheet frames, int duration) {
		super(frames, duration);
		posicion_x = 450;
		posicion_y = 412;
	}
    /**draw
     * Dibuja el sprite en pantalla
     */
    public void draw() {
        super.draw(this.posicion_x, this.posicion_y);
    }
    
    /**draw_
     * Dibuja el sprite con el lado opuesto
     */
    public void draw_() {
    	super.getCurrentFrame().getFlippedCopy(true, false).draw(this.posicion_x, this.posicion_y);
    }
    /**getPosicion_x
     * Obtiene la posicion X 
     * @return
     */
	public float getPosicion_x() {
		return posicion_x;
	}
	
	/**getPosicion_y
	 * Obtiene la posicion Y 
	 * @return
	 */
	public float getPosicion_y() {
		return posicion_y;
	}

	/**setPosicion_x
	 * Setea la posicion X
	 * @param posicion_x
	 */
	public void setPosicion_x(float posicion_x) {
		this.posicion_x = posicion_x;
	}

	/**setPosicion_y
	 * Setea la posicion Y 
	 * @param posicion_y
	 */
	public void setPosicion_y(float posicion_y) {
		this.posicion_y = posicion_y;
	}
		
}
