import GLOOP.*; 
public class Ufospiel{
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;

    private Ufo dasUfo;
    private Asteroid asteroid1,asteroid2,asteroid3,asteroid4,asteroid5,asteroid6,asteroid7,asteroid8,asteroid9,asteroid0;
    //[...]

    public Ufospiel(){
        kamera = new GLSchwenkkamera(1920,1080);
        kamera.verschiebe(0,300,500);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();

        asteroid1 = new Asteroid();
        asteroid2 = new Asteroid();
        asteroid3 = new Asteroid();
        asteroid4 = new Asteroid();
        asteroid5 = new Asteroid();
        asteroid6 = new Asteroid();
        asteroid7 = new Asteroid();
        asteroid8 = new Asteroid();
        asteroid9 = new Asteroid();
        asteroid0 = new Asteroid();
        
        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){           
            asteroid1.bewegeDich();
            asteroid2.bewegeDich();
            asteroid3.bewegeDich();
            if(tastatur.istGedrueckt('a')&&(dasUfo.gibXUfo()>-800)){
                dasUfo.bewegeLinks();
            }
            if(tastatur.istGedrueckt('d')&&(dasUfo.gibXUfo()<800)){
                dasUfo.bewegeRechts();
            }
            Sys.warte(5);
        }
        Sys.beenden(); 
    }
}
