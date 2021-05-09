public interface figuraCalculavel{
    public int area();
    public int perimetro();
}

public class Triangle implements figuraCalculavel{
    public int h;
    public int base;
    public int x, y, z;

    public int h(){
        return h;
    }

    public void setH(int h){
        this.h = h;
    }

    public int base(){
        return base;
    }

    public int setB(int base){
        this.base = base;
    }

    public int ladoX(){
        return x();
    }

    public int ladoY(){
        return y();
    }

    public int ladoZ(){
        return z();
    }

    public void setX(){
        this.x = x;
    }

    public void setY(){
        this.y = y;
    }

    public void setZ(){
        this.z = z;
    }

    @Override
    public int area(){
        int area = 0;
        area = (base * h) / 2;
        return area;
    }

    @Override
    public int perimetro(){
        int perimetro = 0;
        perimetro = x + y + z;
        return perimetro;
    }

    public class Rect implements figuraCalculavel{
        public int x, y, w, h;

        public Rect (int base, int h) {
            this.base = base;
            this.h = h;
        }

        @Override
        public int area(){
            int area = 0;
            area = (base * h);
            return area;
        }
        public int perimetro(){
            int perimetro = 0;
            perimetro = ((2 * base) + (2 * h));
            return perimetro;
        }

    }

    public class Losango implements figuraCalculavel{
        public int diagonalMaior, diagonalMenor, lados;

        public Losango (int diagonalMaior, int diagonalMenor, int lados){
            this.diagonalMaior = diagonalMaior;
            this.diagonalMenor = diagonalMenor;
            this.lados = lados;
        }
        @Override
        public int area(){
            int area = 0;
            area = (diagonalMaior * diagonalMenor) / 2;
            return area;
        }
        @Override
        public int perimetro(){
            int perimetro = 0;
            perimetro = (lados * 4);
            return area;
        }


    }

}



///////////////////////////////////////////////////////////////////////////////////////


public interface selfDrivable{
    String destino();
    String drive();
}

public class Carro implements selfDrivable{
    public String dest, drive;
    public Carro (String dest, String drive){
        this.dest = dest;
        this.drive = drive;
    }
    @Override
    public String destino(){
        String destino = "UERJ"
        return dest;
    }
    @Override
    public String drive(){
        System.out.println("Driving..");
        return drive;
    }


}

public class Aviao implements selfDrivable{
    public String dest, drive;
    public Aviao (String dest, String drive){
        this.dest = dest;
        this.drive = drive;
    }
    @Override
    public String destino(){
        String destino = "Aeroporto Internacional Tom Jobim"
        return dest;
    }
    @Override
    public String drive(){
        System.out.println("Driving..");
        return drive;
    }
}

public class Metro implements selfDrivable{
    public String dest, drive;
    public Metro(String dest, String drive){
        this.dest = dest;
        this.drive = drive;
    }
    @Override
    public String destino(){
        String destino = "Estacao final linha 4 - Jardim Oceânico"
        return dest;
    }
    @Override
    public String drive(){
        System.out.println("Driving..");
        return drive;
    }
}

