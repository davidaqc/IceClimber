package juego;

public class ProcesoCliente extends Thread{
	
	public ProcesoCliente(String msg) {
		super(msg);
	}
	
	public void run() {
		cliente.conectar();
	}

}
