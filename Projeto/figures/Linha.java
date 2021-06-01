package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Linha extends Figure {
	

	public Linha (int x, int y, int w, int h, int contornoR, int contornoG, int contornoB, int fundoR, int fundoG, int fundoB) {
        super(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB);
		
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setColor(new Color(this.contornoR, this.contornoG, this.contornoB));
        if (focused){
            g2d.setPaint(Color.RED);
        }
        g2d.drawLine(x, y, x+w+3, y+h+3);  

	}

}
