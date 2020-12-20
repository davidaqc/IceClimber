package juego; 

import java.net.*;
import java.io.*;
 

public class cliente {
	static String hostname = "localhost";
	static int port = 8888;
	static String line;
	static String mensaje;
	static PrintWriter writer;
	static InputStream input;
	static OutputStream output;
	static BufferedReader reader;
    public static void conectar() {
 
    	
       try (Socket socket = new Socket(hostname, port)) {
        while(true) {
        	input= socket.getInputStream();
        	output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
            reader= new BufferedReader(new InputStreamReader(input));
            leerMensaje();
            
        	}
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    
    }
    /**
     * Lee los mensajes recibidos del servidor
     * @throws IOException
     */
     public static void leerMensaje() throws IOException {
    	
    	line = reader.readLine();
    	System.out.println(line);
    	
    }
     /**
      * Envia mensajes hacia el servidor
      * @param cambio
      */
     public static void enviarMensaje(String cambio) {
    	 
    	 mensaje = cambio;
    	 writer.println(mensaje);
    	 
     }
}