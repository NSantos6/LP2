import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RectPaint {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Retângulos Coloridos");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100, 30, Color.red, Color.blue); // Definições do primeiro retângulo
        this.r2 = new Rect(50, 200, 200, 40, Color.magenta, Color.magenta); // Definições do segundo retângulo
        this.r3 = new Rect(50, 100, 130, 70, Color.red, Color.white); // Definições do terceiro retângulo
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color lados;
    Color fundo;

    Rect (int x, int y, int w, int h, Color lados, Color fundo) { ; //Classes Color
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.lados = lados;
        this.fundo = fundo;
    }


    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,255,0)); // Método setColor
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(fundo);
        
        
        g2d.fillRect(x+2, y+2, w-2, h-2); //Método fillRect
    }
}
