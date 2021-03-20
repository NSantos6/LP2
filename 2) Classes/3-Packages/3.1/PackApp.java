import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Triangle t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 100, 30, Color.pink, Color.black);
        this.e1 = new Ellipse(50, 100, 100, 50, Color.magenta, Color.orange);
        this.t1 = new Triangle(50, 145, 116, 120, Color.red, new Color(255, 215, 0));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g); // Retangulo
        this.e1.paint(g); // Ellipse
        this.t1.paint(g); // Triangulo
    }
}
