package icono;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;
public class dibujo extends JPanel {
    // ventana
    private JFrame ventana;
    //contenedor
    private Container contenedor;
    
    private final int [] FIGURA = {
    		0x1C70,
    		0x3EF8,
    		0x3FF8,
    		0x67FC,
    		0x6FFC,
    		0x7FFC,
    		0x7FFC,
    		0x3FF8,
    		0x1FF0,
    		0x0FC0,
    		0x07C0,
    		0x0380,
    		0x0100,
    		0x0000,
    		0x0000,
    
    };
    
    // mascara 
   private final int MASCARA = 0x8000;
    
    // ancho en bits
    private final int ANCHO_BITS = 32;
    
    //coordenadas
    private int  coordenada_x, coordenada_y;
    
    // definiendo hilo de ejecucion
    private Thread hilo;

    public dibujo() {
        // INICIALIZAR LA VENTANA
        ventana = new JFrame("Dibujando icono");
        //Definirlo en tamano la ventana
        ventana.setSize(800, 600);
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        //agregar la vetana en el contedor
        contenedor.add(this, BorderLayout.CENTER);
        
        // definir hilo
        this.hilo = new Thread();
        
       
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for( int i=0; i< this.FIGURA.length;i++){
            //iterador para el ancho en bits de la figura
            for(int j=0; j < this.ANCHO_BITS;j++){
                int temp = this.FIGURA[i] & (this.MASCARA >> j); 
                
                if(temp !=0){
                    graphics.drawLine(
                            this.coordenada_y+j, 
                            this.coordenada_x+i, 
                            this.coordenada_y+j, 
                            this.coordenada_x+i
                    );
                    
                } 
            }
        }
        
       
    }
    public void dibujar(){
        this.coordenada_x =(int) (Math.random()*500);
        this.coordenada_y =(int) (Math.random()*500);
        for (;;){
            try{
                this.coordenada_x = this.coordenada_x -10;
                
                this.coordenada_y = this.coordenada_y +0;
                
                    this.hilo.sleep(300); // medio segundo
             paint(getGraphics());
        } catch(Exception e){
                System.out.println(e.getMessage());
        
                 }
            }
        
        
        }    
    
    
    
    
    
    
}