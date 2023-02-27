import GLOOP.*;
import java.lang.*;
public class Asteroid{ 
    private GLKugel kugel;


    public Asteroid(){
        kugel = new GLKugel(Math.random()*1600-800,Math.random()*1500+1000,Math.random()*1500-242, 50, "src/img/Krater.jpg");

    }
    public void reset(){
        kugel.setzePosition(Math.random()*1600-1000,Math.random()*1500+2000,Math.random()*1500-100);
    }
    public double asteroidY() {return kugel.gibY();}
    public void bewegeDich(){
        kugel.verschiebe(0,-5,0);
        if(kugel.gibY()<-200){
            this.reset();
        }
    }

    double x;
    public void haltePosition(){
       // kugel.setzePosition();
    }


}
