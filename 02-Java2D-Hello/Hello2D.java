import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.getContentPane().setBackground( Color.orange ); // Cor de fundo
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        
    }

    public void paint (Graphics g) {
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setPaint(Color.blue);
        //int w = getWidth();
        //int h = getHeight();
        //g2d.drawLine(0,0, w,h);
        //g2d.drawLine(0,h, w,0);
        
        //g2d.draw(new Rectangle2D.Double(x, y,rectwidth, rectheight));

        g2d.setBackground(Color.BLACK);

        int[] xPoints = {50,100,150,200,250,300,350};
        int[] yPoints = {350,250,275,200,275,150,100};
        int nPoints = xPoints.length;

        g2d.setColor(Color.magenta);
        
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xPoints, yPoints, nPoints);

        g2d.setFont(new Font("Comic Sans", Font.ITALIC,25));
        g2d.setColor(Color.red);
        
        
        g2d.drawString("STONKS",100,100);


        g2d.draw(new Ellipse2D.Double(50, 40,235,164));

    }

    /*
    public void Paint (Graphics f){
        Graphics2D g2 = (Graphics2D) f;
        QuadCurve2D g2 = new QuadCurve2D.Float();
    }*/
}

