import GLOOP.*;

public class Coins {
public double geschw1;
GLZylinder munze;
    public Coins(double geschw){
    munze = new GLZylinder(Math.random()*1600-1000,5000,Math.random()*1500-100,30,10);//y=Math.random()*2000+3000
    munze.drehe(-90,0,0);
    munze.setzeFarbe(0,1,0);
    geschw1=geschw;
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



}
