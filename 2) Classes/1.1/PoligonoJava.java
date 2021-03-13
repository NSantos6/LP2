public class PoligonoJava {
    public static void main (String[] args) {
        Poligono p1= new Poligono(50,30,5,100,100);
        p1.print();       
    }
}

class Poligono{
    int posx,posy,lados,h,w;

    Poligono (int posx, int posy, int lados, int h,int w){
        this.posx = posx ;
        this.posy = posy;
        this.lados = lados;
        this.h = h;
        this.w = w;
    }
    void print(){
        System.out.format (" O Poligo tem %d lados, o tamanho de (%d,%d) e a posicao de (%d,%d).\n ", this.lados, this.h,this.w,this.posx,this.posy);
    }
}

