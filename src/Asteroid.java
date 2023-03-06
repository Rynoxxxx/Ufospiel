import GLOOP.*;
import java.lang.*;
public class Asteroid{ 
    private GLKugel kugel;

    private Ufo dasUfo;

    public Asteroid(Ufo pDasUfo){
        kugel = new GLKugel(Math.random()*1600-1000,Math.random()*2000+3000,Math.random()*1500-100, 50, "src/img/Krater.jpg");
        dasUfo = pDasUfo;
    }
    public void reset(){
        kugel.setzePosition(Math.random()*1600-1000,Math.random()*2000+3000,Math.random()*1500-100);
    }

    public void bewegeDich(){
        kugel.verschiebe(0,-5,0);
        if(kugel.gibY()<-200){
            this.reset();
        }
    }
    public double getX() {return kugel.gibX();}
    public double getZ() {return kugel.gibZ();}
    public double getY() {return kugel.gibY();}
    double x;
    public void haltePosition(){
       // kugel.setzePosition();
    }

        public boolean hit() {
            double distance = Math.sqrt(Math.pow(kugel.gibX() - dasUfo.gibXUfo(), 2) + Math.pow(kugel.gibY() - dasUfo.gibYUfo(), 2) + Math.pow(kugel.gibZ() - dasUfo.gibZUfo(), 2));
            if (distance<75) return true;
            else return false;
    }


}
