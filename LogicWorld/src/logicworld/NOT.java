package logicworld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class NOT extends Gates implements MouseListener, MouseMotionListener {

    int giris1X = 0, giris1Y = 20;
    int cikisX = 60, cikisY = 20;

    int giris1W = 10, giris1H = 10;
    int cikisW = 10, cikisH = 10;

    int giris1value = 0;
    int cikisValue = 0;

    boolean giris1On = false, cikisOn = false;

    private BufferedImage image;

    public NOT() {
        super("not");
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        try {
            image = ImageIO.read(new File(this.getClass().getResource("not.png").getPath()));
        } catch (IOException ex) {
            
        }
        calc();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 10, 0, 55, 50, this);
        g.setColor(Color.green);
        if (giris1On) {
            g.setColor(Color.red);
        }
        g.drawString(String.valueOf(giris1value), giris1X, giris1Y);
        g.fillOval(0, giris1Y, giris1W,giris1H);
        g.setColor(Color.green);
        g.setColor(Color.green);
        if (cikisOn) {
            g.setColor(Color.red);
        }
        g.fillOval(cikisX, cikisY, cikisW, cikisH);
        g.drawString(String.valueOf(cikisValue),cikisX,cikisY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (giris1On) {
            switch (String.valueOf(giris1value)) {
                case "0":
                    giris1value = 1;
                    repaint();
                    break;
                case "1":
                    giris1value = 0;
                    repaint();
                    break;
                default:
                    break;
            }
        
        }
        calc();
        
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
        resetIO();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY();
        if (X < 10 && (Y > giris1Y && Y < giris1Y + giris1H)) {
            giris1On = true;
        } else if (X > 60 && (Y > cikisY && Y < cikisY + cikisH)) {
            cikisOn = true;
        } else {
            resetIO();
        }
        repaint();
    }

    public void calc(){
        if(giris1value == 0 ){
            cikisValue = 1;
        }else{
            cikisValue = 0;
        }
        repaint();
    }
    
    public void resetIO() {
        giris1On = false;
        cikisOn = false;
        repaint();
    }

}
