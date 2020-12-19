/*
variables globales, inicializadas, esta variables
no se cambian durante todo el juego
*/
//de tipo entero
//optencion
static  int naranjas = 100;     //obtener najanjas vale 100 puntos
static int bananos = 200;       //obtener bananos vale 200 puntos
static int berenjenas = 300;    //obtener berenjenas vale 300 puntos
static int lechugas = 400;      //obtener lechugas vale 400 puntos
//destruccion
static int hielo = 10;          //destruir hielo vale 10 puntos
static int ave = 800;           //destruir ave vale 800 puntos
static int yeti = 400;          //destruir yeti vale 400 puntos
//de tipo char
static char *respuesta;//respuesta enviada al servidor
//cadenas de caracteres para validar mensajes del cliente
//para sumar puntos
static char *obtiene_naranja = "naranjas";      /*si la entrada es igual a obtiene_naranja se suma 100*/
static char *obtiene_banana = "bananos";        /*si la entrada es igual a obtiene_banana se suma 200*/
static char *obtiene_berenjena = "berenjenas";  /*si la entrada es igual a obtiene_berenjena se suma 300*/
static char *obtiene_lechuga = "lechuga";       /*si la entrada es igual a obtiene_lechuga se suma 400*/
static char *detruye_hielo = "hielo";           /*si la entrada es igual a detruye_hielo se suma 10*/
static char *detruye_ave = "ave";               /*si la entrada es igual a detruye_ave se suma 800*/
static char *detruye_yeti = "yeti";             /*si la entrada es igual a detruye_yeti se suma 400*/
//para sumar o restar puntos
static char *sumarVida = "sumaVida";    /*si la entrada es igual a sumaVida la vida se incrementa en 1*/
static char *restarVida = "restaVida";  /*si la entrada es igual a restaVida la vida se disminuye en 1*/
static char *error = "error\r\n";       /*si la entrada es igual a error\r\n se maneja el error*/
/**
se define una estrutura y se crea un tipo de variable jugador 
*/
typedef struct 
{
    //la estructura contiene:
    char name;          //nombre, de tipo char, para saber el nombre del jugador
    int vida;           //vidas, de tipo entero, para las cantidad de vidas de un jugador
    int puntos;         //puntos, de tipo entero, para las cantidad de puntos de un jugador
}Jugador;               //nomobre de la estrutura
Jugador player1[250] ;  //se inicializa a un posible jugador 1