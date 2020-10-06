
package Animar;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Circulo {
    
    private int coordenada_x, coordenada_y;
    private int radio;
    private Color color;
    private int sentido;
    private final int ARRIBA = 1;
    private final int ARRIBA_DERECHA = 2;
    private final int DERECHA = 3;
    private final int DERECHA_ABAJO = 4;
    private final int ABAJO = 5;
    private final int ABAJO_IZQUIERDA = 6;
    private final int IZQUIERDA = 7;
    private final int IZQUIERDA_ARRIBA = 8;
    
    private int velocidad;
    private int minimo_x, minimo_y, maximo_x, maximo_y;
    
    private Random random;
    
    public Circulo(int ancho, int alto, int radio, int velocidad){
        random = new Random();
        color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
        this.coordenada_x = this.random.nextInt(ancho - radio);
        this.coordenada_y = this.random.nextInt(alto - radio);
        this.radio = radio;
        this.sentido = 1 + random.nextInt(8);
        this.velocidad = velocidad;
        this.minimo_x = 0;
        this.minimo_y = 0;
        this.maximo_x = ancho;
        this.maximo_y = alto;
    }
    
    public void dibujar(Graphics graphics){
        graphics.setColor(this.color);
        
        graphics.fillOval(this.coordenada_x,this.coordenada_y,this.radio,this.radio);
    }
    
    public void animar(){
        int x_positiva = this.coordenada_x + this.velocidad;
        int y_positiva = this.coordenada_y + this.velocidad;
        
        int x_negativa = this.coordenada_x - this.velocidad;
        int y_negativa = this.coordenada_y - this.velocidad;
        
        switch(this.sentido){
            case ARRIBA:
                if(y_negativa > this.minimo_y ){
                    this.coordenada_y = y_negativa;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = ABAJO_IZQUIERDA;
                        break;
                        case 2:
                            this.sentido = ABAJO;
                        break;
                        case 3:
                            this.sentido = DERECHA_ABAJO;
                        break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case ARRIBA_DERECHA:
                if((x_positiva < this.maximo_x) && (y_positiva > this.minimo_y)){
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_negativa;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = IZQUIERDA; break;
                        case 2: this.sentido = ABAJO_IZQUIERDA; break;
                        case 3: this.sentido = ABAJO; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case DERECHA:
                if(x_positiva < this.maximo_x){
                    this.coordenada_x = x_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = IZQUIERDA_ARRIBA; break;
                        case 2: this.sentido = IZQUIERDA; break;
                        case 3: this.sentido = ABAJO_IZQUIERDA; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case DERECHA_ABAJO:
                if((x_positiva < this.maximo_x) && (y_positiva < this.maximo_y)){
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = IZQUIERDA; break;
                        case 2: this.sentido = IZQUIERDA_ARRIBA; break;
                        case 3: this.sentido = ARRIBA; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case ABAJO:
                if(y_positiva < this.maximo_y){
                    this.coordenada_y = y_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = IZQUIERDA_ARRIBA; break;
                        case 2: this.sentido = ARRIBA; break;
                        case 3: this.sentido = ARRIBA_DERECHA; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case ABAJO_IZQUIERDA:
                if((y_positiva < this.maximo_y) && (x_negativa > this.minimo_x)){
                    this.coordenada_x = x_negativa;
                    this.coordenada_y = y_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = ARRIBA; break;
                        case 2: this.sentido = ARRIBA_DERECHA; break;
                        case 3: this.sentido = DERECHA; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case IZQUIERDA:
                if(x_negativa > this.minimo_x){
                    this.coordenada_x = x_negativa;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = ARRIBA_DERECHA; break;
                        case 2: this.sentido = DERECHA; break;
                        case 3: this.sentido = DERECHA_ABAJO; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
            case IZQUIERDA_ARRIBA:
                if((x_negativa > this.minimo_x)&&(y_negativa > this.minimo_y)){
                    this.coordenada_x = x_negativa;
                    this.coordenada_y = y_negativa;
                }else{
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1: this.sentido = DERECHA; break;
                        case 2: this.sentido = DERECHA_ABAJO; break;
                        case 3: this.sentido = ABAJO; break;
                    }
//                    this.sentido = 1 + random.nextInt(8);
                }
            break;
        }
    }
    
}
