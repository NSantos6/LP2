package figures;
import java.awt.Graphics;
import java.awt.*;
import java.awt.geom.*;

public class Ellipse extends Figure {
	
    public Ellipse (int x, int y, int w, int h, int contornoR, int contornoG, int contornoB, int fundoR, int fundoG, int fundoB) {
        super(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB);
    }


    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	    if (focused) {
	        g2d.setPaint(Color.RED);
	        g2d.drawOval(this.x-3, this.y-3, this.w+6, this.h+6);
	}
	
	g2d.setColor(new Color(this.contornoR,this.contornoG,this.contornoB));
	g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.drawOval(this.x,this.y, this.w,this.h);
	g2d.setColor(new Color(this.fundoR, this.fundoG, this.fundoB));
	g2d.drawOval(this.x, this.y, this.w, this.h);
    }
}
