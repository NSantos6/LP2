import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import figures.*;

class app {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Rect r = new Rect(0,0,0,0, Color.BLUE, Color.CYAN);
    Random rand = new Random();
    int posX = 0, posY = 0;
    Figure focus = null;
    Point mp;



    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) {  //seleciona a figura
            System.out.println(evt.getX() + "," + evt.getY()); // Teste
            mp = getMousePosition(); // Mouse Position
		    focus = null;
		    for (Figure fig: figs) {
		        if ((fig.x <= evt.getX() && (fig.x + fig.w) >= evt.getX()) && (fig.y <= evt.getY() && fig.y + fig.h >= evt.getY())) {
			    focus = fig;
                //figs.remove(focus);
                figs.add(focus);
			    repaint();
            }
			else {

			    focus = null;
			    repaint();
			}
	   }
	}
	    }
	);

    this.addMouseMotionListener(
	    new MouseMotionAdapter() {
	        public void mouseDragged (MouseEvent evt) {  //Move a figura selecionada quando mouse é arrastado
            System.out.println(evt.getX() + "," + evt.getY());
		    for (Figure fig: figs) {
		        if (focus == fig) {
                    focus.x = evt.getX()-focus.w/2;
					focus.y = evt.getY()-focus.h/2;
					r.x = focus.x-1;
					r.y = focus.y-1;
			        //fig.drag(evt.getX()-focus.x, evt.getY()-focus.y);
			        repaint();
		    }
	     }
		}
	});


        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) { // Eventos teclado
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(70);
                    int h = rand.nextInt(70);



                    int x1 = rand.nextInt(350);
                    int x2 = rand.nextInt(350);
                    int x3 = rand.nextInt(350);
                    int y1 = rand.nextInt(350);
                    int y2 = rand.nextInt(350);
                    int y3 = rand.nextInt(350);
                    
                    Color contorno = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                    Color fundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h, contorno, fundo));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h, contorno, fundo));
                    } else if (evt.getKeyChar() == 't') {
                    	figs.add(new Triangl(x1, x2, x3, y1, y2,y3,contorno, fundo));
                    } else if (evt.getKeyChar() == 'p'){
                        int tamanho = rand.nextInt(40);
                        figs.add(new Texto("alo, teste", x, y, tamanho, "Italic",  fundo));
                    }else if(evt.getKeyChar() == 'l'){ // Limpa as figuras
                        figs.clear();
                    }else if(evt.getKeyChar() == '1'){
                        for(Figure fig: figs){
                            if(focus == fig){
                                //fig.fundo(new Color(0,0,255));
                                repaint();
                            }
                        } 
                    } else if (evt.getKeyChar() == '+') { // Aumenta a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.aumento(1,1);
								focus.aumento(1,1);
								repaint();
							}
						}
                    }else if (evt.getKeyChar() == '-') { // Diminui a figura
                        //diminui a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.aumento(-1,-1);
								focus.aumento(-1,-1);
								repaint();
							}
						}
                    }
                    repaint();
                }
            }
        );

        

        this.setTitle("Projeto LP2 - Editor - 1/2");
        this.setSize(410, 410);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
