import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import figures.*;

// == Projeto Parte 2/2 ==

class App {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    private ArrayList<Button> buts = new ArrayList<Button>();
    private Figure focus = null;
    private Button focus_but = null;
    private Random rand = new Random();
	  private Point mp;

    ListFrame () {

		try{
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();
		} catch (Exception x){
			System.out.println("ERRO!");
		}

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					try{
						FileOutputStream f = new FileOutputStream("proj.bin");
						ObjectOutputStream o = new ObjectOutputStream(f);
						o.writeObject(figs);
						o.flush();
						o.close();
					} catch (Exception x){
						System.out.println("ERRO!");
					}
                    System.exit(0);
                }
            }
        );


	buts.add(new Button(1, new RoundRect(0,0,0,0,15,10,181,171,37,15,10,187)));
	buts.add(new Button(2, new Rect(0, 0, 0, 0, 0, 255, 0,100,255,0)));
	buts.add(new Button(3, new Ellipse(0,0,0,0,13,21,252,13,21,252)));
	
	this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) {  //seleciona a figura
		    focus = null;
		    focus_but = null;
		    int x = evt.getX();
		    int y = evt.getY();
		    for (Figure fig: figs) {
		        if (fig.clicked(x,y)) {
			    focus = fig;
			    repaint();
			    break;
                        }
			else {
			    focus = null;
			    repaint();
			}
		    }
		    for (Button but: buts) {
		        if (but.clicked(x,y)) {
			    focus_but = but;
			    repaint();
			    break;
			}
		    }
		    if ((focus_but != null) && (focus == null)) { //Define o foco do Button
		        if (focus_but.idx == 1) {
				figs.add(new RoundRect(x+175,y+100, rand.nextInt(50),rand.nextInt(50),15,10,0,0,255,0,0,255));   //x+175,y+100
			}
			else if (focus_but.idx == 2) {
				figs.add(new Rect(x+100, y+25, rand.nextInt(50), rand.nextInt(50), 255, 0, 0,0,0,255)); // x+175, y+25
			}
			else if (focus_but.idx == 3) {
				figs.add(new Ellipse(x+100,y+50, rand.nextInt(50),rand.nextInt(50),0,255,0,0,255,0));  //x+175,y+50
			}
		    }
		    repaint();
		}
	    }
	);
	
	this.addMouseMotionListener(
	    new MouseMotionAdapter() {
	        public void mouseDragged (MouseEvent evt) {  //move a figura selecionada
		    for (Figure fig: figs) {
		        if (focus == fig) {
			    focus.x = evt.getX()-focus.w/2;
			    focus.y = evt.getY()-focus.h/2;
			    repaint();
			}
		    }
		}
	    }
	);

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
		     		mp = getMousePosition();
					int circleH = 15;
					int circleW = 5;
		    		int x = mp.x;
                    int y = mp.y;
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
					int contornoR = rand.nextInt(255);
					int contornoG = rand.nextInt(255);
					int contornoB = rand.nextInt(255);
					int fundoR = rand.nextInt(255);
					int fundoG = rand.nextInt(255);
					int fundoB = rand.nextInt(255);
		    
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
                    }
		    		else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
		    		}//else if(evt.getKeyChar() == 'p'){
						//figs.add(new Texto(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
					/*}*///else if(evt.getKeyChar() == 't'){
						//figs.add(new Triangl(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
					//}else if(evt.getKeyChar() == 'p'){
						//figs.add(new Linha(x, y, w, h, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
					/*}*/else if(evt.getKeyChar() == 'k'){
						figs.add(new RoundRect(x, y, w, h, circleW, circleH, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
					}//else if(evt.getKeyChar() == 'c'){
						//figs.add(new Circle(x, y, w, h, circleW, circleH, contornoR, contornoG, contornoB, fundoR, fundoG, fundoB));
					/*}*/else if(evt.getKeyChar() == 'l'){ // Limpa todas as figuras de uma vez, mas caso exista uma figura com foco, esssa não será deletada.
						figs.clear();
			}

			
	            for (Figure fig: figs) {
		        if (focus == fig) {
			    if (evt.getKeyCode() == KeyEvent.VK_DELETE) { // Deleta a figura em que o Foco está ativo pressionando 'DEL'
			        figs.remove(fig);
				focus = null;
				repaint();
				break;
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {  // Move a figura para a esquerda pressionando 'seta p/ esqeurda'
				fig.drag(-1,0);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {  // Move a figura para a direita pressionando 'seta p/ direita'
				fig.drag(1,0);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_UP) {  // Move a figura para cima pressionando 'seta p/ cima'
				fig.drag(0,-1);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {  // Move a figura para baixo pressionando 'seta p/ baixo'
				fig.drag(0,1);
			    }
			    else if (evt.getKeyChar() == '+') {  // Aumenta a figura pressionando '+'
				fig.resize(1,1);
			    }
			    else if (evt.getKeyChar() == '-') {  // Diminui a figure pressionando '-'
				fig.resize(-1,-1);
			    }
			    else if (evt.getKeyChar() == 'c') {  //muda cor de contorno da figura selecionada
				fig.fundo(fundoR,fundoG,fundoB);
			    }
			    else if (evt.getKeyChar() == 'f') {  //muda cor de fundo da figura selecionada
				fig.contorno(contornoR, contornoG, contornoB);
			    }
			}
		    }
		    repaint();
                }
            }
        );

        this.setTitle("Projeto LP2 - Editor - 2/2");
        this.setSize(410, 410);
    }

    public void paint (Graphics g) {
        super.paint(g);
	Graphics2D g2Graphics2d = (Graphics2D) g;

        for (Figure fig: this.figs) {
            fig.paint(g, false);
        }
	
	if (focus != null) {  
	    focus.paint(g, true);  
	}
	for (Button but: this.buts) {
	    but.paint(g, but == focus_but);
	}
    }
}
