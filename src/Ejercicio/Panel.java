/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class Panel extends JPanel implements ActionListener{
    
    private int x;
    private int y;
    private int a;
    private int b;
    private Timer timer;
    private int sec1;
    private int sec2;
  
    public Panel() {
        addKeyListener(new Tecla());
        setFocusable(true);
        timer=new Timer (100,this);
        timer.start();
        x=0;
        y=300;
        b=400;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.sec1==4){
            this.sec1=0;
        }else{
            this.sec1++;
        }
        repaint();
    }
    
    public Image loadImage(String imageName){
        ImageIcon i=new ImageIcon(imageName);
        Image image=i.getImage();
        return image;
    } 
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo=loadImage("red_background.png");
        for (int i = 0; i < 1000; i+=22) {
         g.drawImage(fondo, i, 0, null);   
        }
        Image nube=loadImage("clouds.png");
        for (int i = 0; i < 1000; i+=335) {
         g.drawImage(nube,i,50,null);   
        }
        Image bueno=loadImage("walking.png");
        g.drawImage(bueno, x, y, x+115, y+134, (this.sec1*115), 0, (this.sec1*115)+115, 134, this);
        Image malo=loadImage("enemy_run.png");
        g.drawImage(malo, a, b, x, y, x, y, x, y, this);
        
    }
    private class Tecla extends KeyAdapter{
        public void keyRelesed(KeyEvent e){
        System.out.println("soltar tecla");
    }
    
    @Override

    public void keyPressed(KeyEvent e){
        int key =e.getKeyCode();
        if (key==KeyEvent.VK_SPACE){
            try{
            Thread.sleep(52);
            }catch (InterruptedException d){
                System.out.println("el muñeco se detuvo");
    
        }
        }
        if(key==KeyEvent.VK_LEFT){
            x=x-10;
        }
        
        if(key==KeyEvent.VK_RIGHT){
            x=x+10;
        }
        if(key==KeyEvent.VK_UP){
            y=y-10;
        }
        if(key==KeyEvent.VK_DOWN){
            y=y+10;
        }

    }
    
}
}
