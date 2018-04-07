package logicworld;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Gates extends JPanel {

    String name = "";

    public Gates(String name) {
        this.name = name;
        this.setBackground(Color.white);
        this.setSize(70, 50);
    }


    @Override
    public String toString() {
        return this.name;
    }
}
