/*
TCP Echo server example in winsock
Live Server on port 8888
*/
/*
Server: maneja la comunicacion Java-C en C.
se controla las vidas y los puntos de los jugadores
*/
/*
se incluyenlibrerias
*/
#include<stdio.h>
#include<winsock2.h>
#include "variables.h"				//se incluye el .h que tiene las variables globales
#pragma comment(lib, "ws2_32.lib") 	//Winsock Library
/*
actualizar_puntos
se encarga de actualizar los puntos
recibe:
		->num, tipo entero, con los puntos a sumar
entrega:
		->actualiza los puntos del jugador en la estructura
*/
void actualizar_puntos(int num){
    player1[250].puntos += num;			//suma los puntos especificados
	printf("%i\n", player1[250].puntos);//imprime en consola para llevar orden
}
/*
actualizar_Vida
se encarga de actualizar la vida
recibe:
		->num, tipo entero, la vida a sumar o restar a sumar
entrega:
		->actualiza la vida del jugador en la estructura
*/
void actualizar_Vida(int num){
    player1[250].vida += num;			//suma/resta la vida
	printf("%i\n", player1[250].vida);	//imprime en consola para llevar orden
}

void leerEntrada(){
	
	
}
/*
readMessage
lee el mensaje que envia el cliente e interpreta la accion que debe tomar
recibe:
		->*messageRead, un puntero a un char que apunta al mensaje enviado
entrega:
		->en si, verifica las entradas y decide que hacer
*/
char *readMessage(char *messageRead){
	if(strcmp(obtiene_naranja, messageRead) == 0){	//si obtiene_naranja es igual messageRead
		actualizar_puntos(naranjas);				//actualiza los puntos
		respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaNaranjas\n");
		return respuesta;
	}
	else  if(strcmp(obtiene_banana, messageRead) == 0){	//si obtiene_banana es igual messageRead
		actualizar_puntos(bananos);						//actualiza los puntos
		respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaBananos\n");
		return respuesta;
	}
	else  if(strcmp(obtiene_berenjena, messageRead) == 0){	//si obtiene_berenjena es igual messageRead
        actualizar_puntos(berenjenas);						//actualiza los puntos
		respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaBerenjena\n");
		return respuesta;
    }
    else  if(strcmp(obtiene_lechuga, messageRead) == 0){//si obtiene_lechuga es igual messageRead
        actualizar_puntos(lechugas);					//actualiza los puntos
        respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaBlechuga\n");
		return respuesta;
    }
    else  if(strcmp(detruye_hielo, messageRead) == 0){	//si detruye_hielo es igual messageRead
        actualizar_puntos(hielo);						//actualiza los puntos
        respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaHielos\n");
		return respuesta;
    }
    else  if(strcmp(detruye_ave, messageRead) == 0){//si detruye_ave es igual messageRead
        actualizar_puntos(ave);						//actualiza los puntos
        respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaAve\n");
		return respuesta;
    }
    else  if(strcmp(detruye_yeti, messageRead) == 0){	//si detruye_yeti es igual messageRead
        actualizar_puntos(yeti);						//actualiza los puntos
        respuesta = "actualizacionDePuntuacion\r\n";
		printf("sumaYeti\n");
		return respuesta;
    }
	else  if(strcmp(sumarVida, messageRead) == 0){	//si sumarVida es igual messageRead
        actualizar_Vida(1);							//actualiza la vida
        respuesta = "actualizacionDeVida\r\n";
		printf("sumaVida\n");
		return respuesta;
    }
	else  if(strcmp(restarVida, messageRead) == 0){	//si restarVida es igual messageRead
        actualizar_Vida(-1);						//actualiza la vida
        respuesta = "actualizacionDeVida\r\n";
		printf("restaVida\n");
		return respuesta;
    }
	else{
		printf("pruebaIncorrecta\n");
		
		return error;//muestra el error
	}
}
/*
metodo main que arranca el servidor
*/
int main(int argc , char *argv[])
{
	/*
	se define a los jugadores de forma inicial
	con una vida de 3 y 0 puntos
	siempre se inician estructuras para dos jugadores
	depende de la cantidad que entres es que se usas estras estructuras
	*/
	
	WSADATA wsa;											//abre el socket
	SOCKET master , new_socket , client_socket[3] , s;		//socket creado y cantidad de clientes
	struct sockaddr_in server, address;						//es la direccion de trabajo
	int max_clients = 3 , activity, addrlen, i, valread;	/*masimo de clientes, el estdo de conexion,
	posicion en la que va a quedar y el mensaje, respectivamente*/
	char *message = "mensaje|prueba \r\n";					//respuesta para coneccion
	int MAXRECV = 1024;										//tamanio del buffer, lo que se recibe
    fd_set readfds;											//descritores del socket
	char *buffer;											//mensaje del cliente
	buffer =  (char*) malloc((MAXRECV + 1) * sizeof(char));	//para leer el mensaje
	/*
	ciclo para agregar a un arreglo los clientes conectados
	*/
	for(i = 0 ; i < 3;i++)
	{
		client_socket[i] = 0;
	}
	/*
	inicializacion del socket
	*/
	printf("\nInicializanco socket...");
	if (WSAStartup(MAKEWORD(2,2),&wsa) != 0)					//si el socket no se inicializa
	{
		printf("Error. Codigo de error : %d",WSAGetLastError());//imprime el numero de error
		exit(EXIT_FAILURE);										//finaliza el programa
	}
	printf("Inicializado.\n");
	//Crea el socket y lo valida
	if((master = socket(AF_INET , SOCK_STREAM , 0 )) == INVALID_SOCKET)
	{
		printf("No se pudo crear el socket : %d" , WSAGetLastError());
		exit(EXIT_FAILURE);
	}
	printf("Socket creado.\n");									//imprime el exito
	//son los parametros del socket, la estructura (direccion y puerto)
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = INADDR_ANY;
	server.sin_port = htons( 8888 );
	//enlace los clientes, los espera
	if( bind(master ,(struct sockaddr *)&server , sizeof(server)) == SOCKET_ERROR)
	{
		printf("Se encontro un error. Codigo de error : %d" , WSAGetLastError());
		exit(EXIT_FAILURE);
	}
	puts("Bind done");
	listen(master , 3);											//espera por las conecciones
	puts("Esperando conexiones...");							//acepta la conexion entrante
	addrlen = sizeof(struct sockaddr_in);						//lee el largo de la direccion
    /*
	el ciclo donde recibe y envia mensajes del y al cliente
	*/
	while(TRUE)
    {
        FD_ZERO(&readfds);										//limpia el socket
        //esperar conexion del cliente
        FD_SET(master, &readfds);
        //comprueba si puede agregar clientes
        for (  i = 0 ; i < max_clients ; i++)					//si no se ha llegado al maximo de cliantes
        {
            s = client_socket[i];								//lo agrega
											
            if(s > 0)
            {
                FD_SET( s , &readfds);							//o no hace nada
            }
        }
        //personaliza el socket por cliente, espera actividad de forma indefinida
        activity = select( 0 , &readfds , NULL , NULL , NULL);
        if ( activity == SOCKET_ERROR )							//si hay actividad
        {
			//verifica si hay actividad erronea
            printf("Error de comunicacion. Codigo error : %d" , WSAGetLastError());
			exit(EXIT_FAILURE);
        }
        
        if (FD_ISSET(master , &readfds)) 						//acepta la nueva connexion
        {
            if ((new_socket = accept(master , (struct sockaddr *)&address, (int *)&addrlen))<0)
            {
                perror("accept");
                exit(EXIT_FAILURE);
            }
            //imprime la nueva conexion
			//imprime socket
			//imprime la direccion id
			//imprime el puerto
            printf("Nueva conexion , socket  %d , ip  : %s , port : %d \n" , new_socket , inet_ntoa(address.sin_addr) , ntohs(address.sin_port));
       
            //envia mensaje de exito en la conexion
            if( send(new_socket, message, strlen(message), 0) != strlen(message) ) 
            {
                perror("send failed");
            }
            puts("Bienvenido"); 
            //aniade un nuevo socket(direccion/cliente) al array de clientes
			for (i = 0; i < max_clients; i++) 
            {
                if (client_socket[i] == 0)
                {
                    client_socket[i] = new_socket;
                    printf("Cliente conectado %d \n" , i);
					player1[250].vida = 3;
					player1[250].puntos = 0;
					fgets(entradaConsola, 30, stdin);
                    break;
                }
            }
        }
        //interpreta el mensaje
		//verifica si es un cliente conocido
        for (i = 0; i < max_clients; i++) 
        {
            s = client_socket[i];			
            if (FD_ISSET( s , &readfds)) 										//leer el mensaje del cliante
            {
				getpeername(s , (struct sockaddr*)&address , (int*)&addrlen); 	//detalles del cliente
				//lee el mensaje y verifica de donde proviene el mensaje
				//y verifica la estructura y el largo del mensaje
                valread = recv( s , buffer, MAXRECV, 0);
				
				if( valread == SOCKET_ERROR)									//si lo leido es incorrecto
				{
					int error_code = WSAGetLastError();
					if(error_code == WSAECONNRESET)
					{
						//desconecta el cliente
						printf("Host desconectado , ip %s , port %d \n" , inet_ntoa(address.sin_addr) , ntohs(address.sin_port));
                     
						
						closesocket( s );										//y cierra la conecion
						
						client_socket[i] = 0;//si es un clinte valido con un mendaje erroneo, lo saca de los clientes aceptados
					}
					else
					{
						printf("Error. Codigo error : %d" , error_code);		//imprime el error
					}
				}
				if ( valread == 0)
                {
                    //si un cliante se desconecta, imprime quien se desconecto
                    printf("Host desconectado , ip %s , port %d \n" , inet_ntoa(address.sin_addr) , ntohs(address.sin_port));
                     
                    
                    closesocket( s );											//cierra la conexion y lo saca de la lista
                    client_socket[i] = 0;
                }
                else															//y si el mensaje es valido
                {
					//el char es la respuesta al cliente
					//dadd por la funcion readMessage
					//segun la solicitud del cliente
					
					char *mensajePrueba = readMessage(buffer);
					printf(mensajePrueba);										//imrime el mensaje
					send( s , mensajePrueba , strlen(mensajePrueba) , 0 );		//envia el mensaje al cliente
					//
					
					
					
                }
            }
        }
    }
	closesocket(s);																//cierra el socket
	WSACleanup();																//limpia la conexion
	return 0;
}