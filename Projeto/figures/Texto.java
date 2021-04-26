package figures;
import java.awt.Graphics;
import java.awt.*;
import java.util.Random;

public  class Texto extends Figure{
    private String palavra, fonte;
	private int tamanho, x, y;
    Random rand = new Random();

	public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.palavra, this.fonte, this.tamanho);
	}
    public Texto (String palavra, int x, int y, int tamanho, String fonte, Color fundo) {
		this.palavra = palavra;
        this.fonte = fonte;
		this.tamanho = tamanho;
		this.x = x;
		this.y = y;
    }

    public void drag(int x, int y){
        this.x += x;
        this.y += y;
    }
    
    @Override
    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font(fonte, Font.ITALIC, tamanho));
        g2d.setColor(new Color (rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		g2d.drawString(palavra,x,y);
        
    }
}


