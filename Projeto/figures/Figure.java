package figures;
import java.awt.*;
import java.awt.Graphics;
//import java.util.Random;

public abstract class Figure {
	public abstract void print ();
    int x, y, w, h;
    Color contorno;
    Color fundo;
    public abstract void paint (Graphics g);
}
