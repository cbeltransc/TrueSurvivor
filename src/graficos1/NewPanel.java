/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class NewPanel extends JPanel implements ActionListener,MouseListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.secuencia==2){
            this.secuencia=0;
        }else{
            this.secuencia++;
        }
        if(this.sec==8){
            this.sec=0;
        }else{
            this.sec++;
        }
        if(x<700){
        this.x+=1;
        checkCollisions();
        repaint();
       
        
           }
        
    }
    private int x;
    private int y;
    private Timer timer;
    private int secuencia;
    private int sec;
    
    public NewPanel() {
        this.addMouseListener(this);
        timer=new Timer (5,this);
        timer.start();
        
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        y=400;
        
       
   
        Image fondo=loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        
        Image nina=loadImage("free_radical_game_sprites.png");
        Image moneda=loadImage ("FullCoins.png");
        g.drawImage(nina, x, y, x+32, y+32,this.secuencia*32+192, 192,192+this.secuencia*32+32, 192+32, this);
        g.drawImage(moneda, 750, 400, 766, 416,this.sec*16 , 0, this.sec*16+16, 16, this);
       
        
 
       
        
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp=e.getPoint();
        if(getBounds().contains (mp)){
            timer.stop();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public Rectangle getBound(){
        return new Rectangle (x, y, x+32, y+32);
        
    }
    
    public void checkCollisions(){
        Rectangle tanque=getBound();
        Rectangle objeto=new Rectangle (750, 400, 766, 416);
        if(tanque.intersects(objeto)){
            timer.stop();
        }
        
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii=new ImageIcon(imageName);
        Image image=ii.getImage();
        return image;
            }
    
    
}
