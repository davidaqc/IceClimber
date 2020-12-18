//obtencion
static  int naranjas = 100;
static int bananos = 200;
static int berenjenas = 300;
static int lechugas = 400;
//destruccion
static int hielo = 10;
static int ave = 800;
static int yeti = 400;

static char *respuesta;
static char *obtiene_naranja = "naranjas";
static char *obtiene_banana = "bananos";
static char *obtiene_berenjena = "berenjenas";
static char *obtiene_lechuga = "lechuga";
static char *detruye_hielo = "hielo";
static char *detruye_ave = "ave";
static char *detruye_yeti = "yeti";
static char *sumarVida = "sumaVida";
static char *restarVida = "restaVida";
static char *error = "error\r\n";

typedef struct 
{
    char name;
    int vida;
    int puntos;
}Jugador;
Jugador player1[250] ;