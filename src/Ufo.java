import GLOOP.*;

import java.io.File;

public class Ufo{
    private GLQuader rumpf;
    private GLTafel explo;
    private GLTastatur tastatur;



    public Ufo(){
        rumpf = new GLQuader(0,0,150, 50,50,50,"src/img/meme.gif");
        rumpf.skaliere(1);
        rumpf.drehe(0,0,0);
        rumpf.setzeFarbe(0,0,0);
        explo = new GLTafel(0,0,150,200,200,"src/img/expolsion.png");
        explo.drehe(-90,0,180);
        explo.setzeSichtbarkeit(false);
    }
 
    public void bewegeLinks(){

            rumpf.verschiebe(-5, 0, 0);
            rumpf.setzeDrehung(0,-10,0);
            explo.verschiebe(-5, 0, 0);
    }

    public void bewegeRechts(){

            rumpf.verschiebe(5, 0, 0);
            rumpf.setzeDrehung(0,10,0);
            explo.verschiebe(5, 0, 0);

    }
    public void bewegeOben(){

        rumpf.verschiebe(0, 0, 5);
        rumpf.setzeDrehung(10,0,0);
        explo.verschiebe(0, 0, 5);
    }
    public void bewegeUnten(){

        rumpf.verschiebe(0, 0, -5);
        rumpf.setzeDrehung(-10,0,0);
        explo.verschiebe(0, 0, -5);
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
    public void farbeOff(){
        rumpf.setzeFarbe(0,0,0);
    }

    public void noclip(){
        rumpf.setzeSichtbarkeit(false);
    }
    public void noclipOff(){
        rumpf.setzeSichtbarkeit(true);
    }
    public void tot(){
        rumpf.setzePosition(0,0,0);
        explo.setzePosition(0,0,0);
    }
    public void explosion(){
        explo.setzeSichtbarkeit(true);
    }
    public void respawn(){
        explo.setzeSichtbarkeit(false);
    }



}
