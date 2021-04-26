package figures;
import java.awt.*;
import java.awt.Graphics;
//import java.util.Random;

public abstract class Figure {
	public abstract void print ();
    public int x, y, w, h;
    public Color contorno;
    public Color fundo;
    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public void aumento(int largura, int altura){
		this.w += largura;
		this.h += altura;
	}
    public abstract void paint (Graphics g);
}
