import GLOOP.*;
public class Ufo{
    private GLPrismoid rumpf;

    private GLTastatur tastatur;


    public Ufo(){
        rumpf = new GLPrismoid(0,0,0, 50,50,3,80);
        rumpf.setzeFarbe(0,0,0);

    }
 
    public void bewegeLinks(){

            rumpf.verschiebe(-5, 0, 0);

    }

    public void bewegeRechts(){

            rumpf.verschiebe(5, 0, 0);

    } 

    public double gibXUfo(){
            return rumpf.gibX();
    }



    public void explodiere(){
        //[...]
    }

}
