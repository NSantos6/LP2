package figures;

import java.awt.*;
import java.util.Random;


public class Rect extends Figure {
    public int x, y, w, h;
    int width, height;
    Color contorno;
    Color fundo;
    Random rand = new Random();

    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    public void drag(int x, int y, int w, int h){
        this.x += x;
        this.y += y;
        this.w += w;
        this.h += h;
    }
    
    @Override
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color (rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.setBackground(Color.black);

        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y,this.w,this.h);
        g2d.setColor(fundo);
        g2d.fillRect(x+1,y+1, this.w-1,this.h-1);


        //g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        //g2d.setColor(fundo);
       // g2d.setColor(contorno);
        //g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
    }
}
