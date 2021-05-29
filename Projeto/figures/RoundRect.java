package figures;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;

public class RoundRect extends Figure {
    private int circleW, circleH;

    public RoundRect (int x, int y, int w, int h, int circleW, int circleH, int contornoR, int contornoG, int contornoB, int fundoR, int fundoG, int fundoB) {
        super(x,y, w,h,contornoR,contornoG, contornoB, fundoR, fundoG, fundoB);
	this.circleW = circleW;
	this.circleH = circleH;
    }


    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.RED);
	    g2d.draw(new RoundRectangle2D.Double(this.x-2,this.y-2, this.w+4,this.h+4, this.circleW,this.circleH));
	}
	
	g2d.setColor(new Color(this.contornoR,this.contornoG,this.contornoB));
	g2d.fill(new RoundRectangle2D.Double(this.x,this.y, this.w,this.h, this.circleW,this.circleH));
        g2d.setColor(new Color(this.fundoR,this.fundoG,this.fundoB));
        g2d.draw(new RoundRectangle2D.Double(this.x,this.y, this.w,this.h, this.circleW,this.circleH));
    }
}
