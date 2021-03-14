public class RectApp {
    public static void main (String[] args) {
        Rect r1= new Rect (1,1,12,15,100);
        r1.print();
        r1.drag(5, 5);    
    }
}

class Rect {
    int x,y;
    int h,w;
    int a;
    Rect (int x, int y, int w, int h, int a){
        this.x = x ; 
        this.y = y;
        this.h = h;
        this.w = w;
        this.a= h*w;

    }

    int area (){
        return this.a; // Retorna a área do retângulo
    }

    void print(){
        System.out.format (" O Retangulo tem tamanho de: (%d,%d), e está na posicao (%d,%d).\n ", this.w,this.h, this.x, this.y);
    }
    void drag (int dx, int dy){ // "Arrasta" o Objeto, somando dx e dy a sua posição atual
        this.x = x+dx;
        this.y = y+dy;
    }
}
