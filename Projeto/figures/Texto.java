package figures;

import java.awt.*;
public  class Texto extends Figure{
    private String palavra, fonte;
	private int tamanho;
    public Texto (String palavra, int x, int y, int tamanho, Color fundo) {
	this.palavra = palavra;
        this.fonte = fonte;
	this.tamanho = tamanho;
    }
    @Override
    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font(fonte, Font.ITALIC, tamanho));
        g2d.setColor(fundo);
	g2d.drawString(palavra,x,y);
    }
}
