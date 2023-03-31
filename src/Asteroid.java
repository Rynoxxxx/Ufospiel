import GLOOP.*;
import java.lang.*;
public class Asteroid{ 
    private GLKugel kugel;

    private Ufo dasUfo;


    public double geschw1;
    public double rad, scale1;

    public Asteroid(Ufo pDasUfo,double geschw, double radius){
        rad=radius;
        kugel = new GLKugel(Math.random()*3000-1500,Math.random()*2000+3000,Math.random()*1900-300, rad, "src/img/Krater.jpg");
        kugel.skaliere(Math.random()+1,Math.random()+1,Math.random()+1);
        dasUfo = pDasUfo;
        geschw1=geschw;

    }
    public void reset(){
        kugel.setzePosition(Math.random()*3000-1500,Math.random()*2000+3000,Math.random()*1900-300);
    }

    public void drehe(){
        kugel.drehe(10 / rad,10 / rad,10 / rad );

    }

    public void bewegeDich(){

        kugel.verschiebe(0,geschw1,0);
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
    public void tot(){
        kugel.setzePosition(Math.random()*3000-1500,Math.random()*2000+3000,Math.random()*1900-300);
    }


}
