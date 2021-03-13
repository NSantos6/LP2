#include <stdio.h>
#include <math.h>

typedef struct {
  float f1x, f1y, df2x, df2y;
  float tamanho;
  float angulacao;
}elipse;


void print_elipse(elipse* e){
    printf("A Elipse tem o tamanho de: %f, raios nas posicoes: (%f,%f) e (%f,%f) e rotacao %.1f graus.\n",e->tamanho, e->f1x,e->f1y,e->df2x,e->df2y, e->angulacao);
}

int main (void) {
    elipse e1 = {2,3,5,2,5,90};
    print_elipse(&e1);
}
