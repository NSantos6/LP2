package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Arco extends Figure {
    private int initAngle, finalAngle;

    public Arco (int x, int y, int w, int h, int initAngle, int finalAngle, int contornoR, int contornoG, int contornoB, int fundoR, int fundoG, int fundoB) {
        super(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB);
        this.initAngle = initAngle;
        this.finalAngle = finalAngle;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.RED);
	    g2d.draw(new Arc2D.Double(this.x-3,this.y-3, this.w+6,this.h+6, this.initAngle,this.finalAngle, Arc2D.PIE));
        }
	
	    g2d.setColor(new Color(this.contornoR,this.contornoG,this.contornoB));
	    g2d.fill(new Arc2D.Double(this.x,this.y, this.w,this.h, this.initAngle,this.finalAngle, Arc2D.PIE));
    

        g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.initAngle,this.finalAngle, Arc2D.PIE));
	
        g2d.setColor(new Color(this.fundoR,this.fundoG,this.fundoB));

        g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.initAngle,this.finalAngle, Arc2D.PIE));
    }
}
