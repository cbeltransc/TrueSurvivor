/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class NewPanel extends JPanel implements ActionListener,MouseListener{
    
    
    private int x;
    private Timer timer;

    public NewPanel() {
        this.addMouseListener(this);
        timer=new Timer (10,this);
        timer.start();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(x<700){
        this.x+=1;
        checkCollisions();
        repaint();
       
        
           }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
      
        g.setColor(Color.GREEN);
        g.fillRect(x+100, 400, 100, 101);
        g.fillRect(x+150, 410, 100, 20);
        g.fillOval(x+110, 500, 30, 30);
        g.fillOval(x+160, 500, 30, 30);
        g.drawRect(x+80, 380, 180, 150);
        g.setColor(Color.cyan);
        g.fillRect(150, 50, 50, 100);
        g.fillRect(300, 50, 50, 100);
        g.fillOval(570, 50, 50,50);
        g.fillOval(570, 150, 50,50);
        g.setColor(Color.red);
        g.fillRect(750, 490, 40, 40);
       
        
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
        return new Rectangle (x+80,380,180 ,150);
        
    }
    
    public void checkCollisions(){
        Rectangle tanque=getBound();
        Rectangle objeto=new Rectangle (750, 490, 40, 40);
        if(tanque.intersects(objeto)){
            timer.stop();
        }
        
    }
    
}
