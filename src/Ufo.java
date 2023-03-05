import GLOOP.*;
public class Ufo{
    private GLQuader rumpf;

    private GLTastatur tastatur;



    public Ufo(){
        rumpf = new GLQuader(0,0,150, 50,50,4);
        rumpf.setzeFarbe(0,0,0);

    }
 
    public void bewegeLinks(){

            rumpf.verschiebe(-5, 0, 0);
            rumpf.setzeDrehung(0,-10,0);

    }

    public void bewegeRechts(){

            rumpf.verschiebe(5, 0, 0);
            rumpf.setzeDrehung(0,10,0);


    }
    public void bewegeOben(){

        rumpf.verschiebe(0, 0, 5);
        rumpf.setzeDrehung(10,0,0);

    }
    public void bewegeUnten(){

        rumpf.verschiebe(0, 0, -5);
        rumpf.setzeDrehung(-10,0,0);

    }
    public void normal(){
        rumpf.setzeDrehung(0,0,0);
    }

    public double gibXUfo(){
            return rumpf.gibX();
    }
    public double gibYUfo(){
        return rumpf.gibY();
    }
    public double gibZUfo(){
        return rumpf.gibZ();
    }

    public void farbe(){
        rumpf.setzeFarbe(1,0,0);
    }



}
