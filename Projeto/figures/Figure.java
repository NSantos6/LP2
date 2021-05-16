package figures;

import java.awt.Graphics;
import java.awt.*;
import java.awt.Graphics;
//import java.util.Random;

public abstract class Figure {
    public int x, y;
    public int w, h;
    public int r, g, b;
    protected int contornoR;
    public Color contorno, fundo;

	

    public Figure (int x, int y, int w, int h, Color fundo, Color contorno){
        this.x = x;
        this.y = y;
	    this.w = w;
	    this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }


	
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void tamanho (int dw, int dh) {
	this.w += dw;
	this.h += dh;
    }
	
    public abstract void paint (Graphics g);
}
