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

public class AND extends Gates implements MouseListener, MouseMotionListener {

    int giris1X = 0, giris1Y = 10;
    int giris2X = 0, giris2Y = 30;
    int cikisX = 60, cikisY = 20;

    int giris1W = 10, giris1H = 10;
    int giris2W = 10, giris2H = 10;
    int cikisW = 10, cikisH = 10;

    int giris1value = 0;
    int giris2value = 0;
    int cikisValue = 0;

    boolean giris1On = false, giris2On = false, cikisOn = false;

    private BufferedImage image;

    public AND() {
        super("and");
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        try {
            image = ImageIO.read(new File(this.getClass().getResource("andGate.png").getPath()));
        } catch (IOException ex) {
            Logger.getLogger(OR.class.getName()).log(Level.SEVERE, null, ex);
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
        g.fillOval(0, 10, 10, 10);
        g.setColor(Color.green);
        if (giris2On) {
            g.setColor(Color.red);
        }
        g.drawString(String.valueOf(giris2value), giris2X, giris2Y);
        g.fillOval(0, 30, 10, 10);
        g.setColor(Color.green);
        if (cikisOn) {
            g.setColor(Color.red);
        }
        g.fillOval(cikisX, cikisY, cikisW, cikisH);
        g.drawString(String.valueOf(cikisValue),cikisX,cikisY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (giris1On) { // Eğer mouse'a tıklandıysa ve o anda giriş1 üstündeyse
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
        } else if (giris2On) { // Eğer mouse'a tıklandıysa ve o anda giriş2 üstündeyse
            switch (String.valueOf(giris2value)) {
                case "0":
                    giris2value = 1;
                    repaint();
                    break;
                case "1":
                    giris2value = 0;
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
    public void mouseMoved(MouseEvent e) { // 
        int X = e.getX();
        int Y = e.getY();
        if (X < 10 && (Y > giris2Y && Y < giris2Y + giris2H)) { // Eğer mouse giriş2 in bulunduğu koordinatlar üzerine geldiyse
            giris2On = true;
            giris1On = false;
        } else if (X < 10 && (Y > giris1Y && Y < giris1Y + giris1H)) { // Eğer mouse giriş1 in bulunduğu koordinatlar üzerine geldiyse
            giris1On = true;
            giris2On = false;
        } else if (X > 60 && (Y > cikisY && Y < cikisY + cikisH)) { // Eğer mouse çıkışın bulunduğu koordinatlar üzerine geldiyse
            cikisOn = true;
        } else {
            resetIO(); // Resetle
        }
        repaint();
    }

    public void calc(){ // Giriş değerlerine göre çıkışı hesaplama
        if(giris1value == 0 || giris2value == 0){
            cikisValue = 0;
        }else{
            cikisValue = 1;
        }
        repaint();
    }
    
    public void resetIO() {
        // Mouse üzerinden ayrıldığı zaman, giriş ve çıkışın renklerini varsayılan yapıyoruz
        giris1On = false;
        giris2On = false;
        cikisOn = false;
        repaint();
    }

}
