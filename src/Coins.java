import GLOOP.*;

public class Coins {
public double geschw1;
private Ufo dasUfo;
GLZylinder munze;
    public Coins(Ufo pDasUfo, double geschw){
    munze = new GLZylinder(Math.random()*1600-1000,5000,Math.random()*1500-100,30,10);//y=Math.random()*2000+3000
    munze.drehe(-90,0,0);
    munze.setzeFarbe(0,1,0);
    geschw1=geschw;
    dasUfo = pDasUfo;
    }
    public void reset(){munze.setzePosition(Math.random()*1600-1000,5000,Math.random()*1500-100);//y=Math.random()*2000+3000
        System.out.println("true");
    }
    public void dreheCoin() {
        munze.drehe(0, 0, 0.005);


    }
    public void moveCoin(){
        munze.verschiebe(0,geschw1,0);
        if(munze.gibY()<-200){
            this.reset ();
        }

        }
        public void tot(){
        munze.setzePosition(Math.random()*1600-1000,5000,Math.random()*1500-100);
        }
    public boolean hit() {
        double distance = Math.sqrt(Math.pow(munze.gibX() - dasUfo.gibXUfo(), 2) + Math.pow(munze.gibY() - dasUfo.gibYUfo(), 2) + Math.pow(munze.gibZ() - dasUfo.gibZUfo(), 2));
        if (distance<60) return true;
        else return false;
    }



}
