package figures;
import java.awt.*;
import java.awt.Graphics;
import java.io.Serializable;

import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    public int contornoR, contornoG, contornoB;
    public int fundoR, fundoG, fundoB;
	
    public Figure (int x, int y, int w, int h,int contornoR, int contornoG, int contornoB, int fundoR, int fundoG, int fundoB){
        this.x = x;
        this.y = y;
	this.w = w;
	this.h = h;
        this.contornoR = contornoR;
        this.contornoG = contornoG;
	this.contornoB = contornoB;
    this.fundoR = fundoR;
    this.fundoG = fundoG;
    this.fundoB = fundoB;
    }
	
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void resize (int dw, int dh) {
	this.w += dw;
	this.h += dh;
    }

	
    public void fundo (int fundoR, int fundoG, int fundoB) {
        this.fundoR = fundoR;
        this.fundoG = fundoG;
	    this.fundoB = fundoB;
    }

    public void contorno (int contornoR, int contornoG, int contornoB) {
        this.contornoR = contornoR;
        this.contornoG = contornoG;
	    this.contornoB = contornoB;
    }


    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
