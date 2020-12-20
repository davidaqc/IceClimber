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

	/** Ave 
	 * Constructor del objeto Ave 
	 * @param ruta
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Ave(String ruta, float x, float y) throws SlickException {
		sprite = new SpriteSheet("res/imagenes/spriteSheetAve.png", 41, 42);
        this.ave = new SpriteJugador(sprite, 100);
        this.ave.setAutoUpdate(false);
        this.colision = new Rectangle(this.ave.getPosicion_x(), this.ave.getPosicion_y(), (float) this.ave.getWidth(), (float) this.ave.getHeight());

        this.ave.setPosicion_x(50);
        this.ave.setPosicion_y(300);
	}
    
	/** draw
	 * Dibujar el objeto en pantalla
	 */
    public void draw() {
    	if (direccion == 0) {
    		this.ave.draw_();
    	}else {
    		this.ave.draw();
    	}
    }
    /** Update
     * Actualiza la posicion del ave y de su hitbox
     * 
     * @param delta
     * @param entrada
     * @throws SlickException
     */
    public void update(int delta, Input entrada) throws SlickException {
        actualizarTeclado(entrada);
        sincronizarArea();
    }
    
    /** actualizarTeclado
     * Actualiza posicion del ave
     * @param entrada
     * @throws SlickException
     */
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
    
    /** getAreaColision
     * Obtiene el area de la colision del ave
     * @return
     */
	public Shape getAreaColision() {
        return this.colision;
    }
    
	/** sincronizarArea
	 * Setea la posicion de la colision junto con la imagen
	 */
    public void sincronizarArea() {
        this.colision.setX(this.ave.getPosicion_x());
        this.colision.setY(this.ave.getPosicion_y());
    }
    
    /** getIzquierdo
     * Obtiene su lado izquierod
     * @return
     */
    public float getIzquierdo() {
    	return this.ave.getPosicion_x();
    }
    
    /** getDerecho
     * Obtiene su lado derecho
     * @return
     */
    public float getDerecho() {
    	return (this.ave.getPosicion_x() + this.ave.getWidth());
    }
    
    /** getArriba
     * Obtiene su lado superior 
     * @return
     */
    public float getArriba() {
    	return this.ave.getPosicion_y();
    }
    
    /** getAbajo
     * Obtiene su lado inferior 
     * @return
     */
    public float getAbajo() {
    	return (this.ave.getPosicion_y() + this.ave.getHeight());
    }
    
    /** setX
     * Setea la posicion X del ave
     */
    public void setX(float posicion_x) {
    	this.ave.setPosicion_x(posicion_x);
    }
    
    /** setY
     * Setea la posicion Y del ave
     */
    public void setY(float posicion_y) {
    	this.ave.setPosicion_y(posicion_y);
    }

}
