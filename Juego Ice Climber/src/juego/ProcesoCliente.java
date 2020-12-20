package juego;

public class ProcesoCliente extends Thread{
	
	/** ProcesoCliente
	 * Setea el titulo de la ventana 
	 * @param msg
	 */
	public ProcesoCliente(String msg) {
		super(msg);
	}
	
	/** run
	 * conecta la instancia del cliente con la del servidor
	 */
	public void run() {
		cliente.conectar();
	}

}
