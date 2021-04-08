package figures;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Figure {
	public abstract void print ();
    	int x, y, w, h, x1, x2, x3, y1, y2, y3;
    	Color contorno;
    	Color fundo;
    public abstract void paint (Graphics g);
}
