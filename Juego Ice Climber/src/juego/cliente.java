package juego; 

import java.net.*;
import java.io.*;
 
/**
 * This program demonstrates a socket client program that talks to a SMTP server.
 *
 * @author www.codejava.net
 */
public class cliente {
 
    public static void conectar() {
 
        String hostname = "localhost";
        int port = 8888;
 
       try (Socket socket = new Socket(hostname, port)) {
        while(true) {
            InputStream input = socket.getInputStream();
 
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            String line = reader.readLine();
            System.out.println(line);
            
            writer.println("hello " + hostname);
 
            line = reader.readLine();
            System.out.println(line);
 
            writer.println("jugador|vida");
            line = reader.readLine();
            System.out.println(line);
        	}
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    
    }
}