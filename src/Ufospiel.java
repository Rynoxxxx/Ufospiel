import GLOOP.*; 
public class Ufospiel{
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;

    Asteroid[] asteroid ;
    private Ufo dasUfo;

    //[...]

    public Ufospiel(){
        kamera = new GLSchwenkkamera(1600,900);
        kamera.verschiebe(0,-400,-500);
        kamera.setzeBlickpunkt(0,0,50);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();
        asteroid = new Asteroid[100];
        for(int i=0;i< asteroid.length;i++){
            asteroid[i] = new Asteroid();
        }



        
        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){
            for(int i=0;i< asteroid.length;i++) {
                asteroid[i].bewegeDich();
            }


            if(tastatur.istGedrueckt('a')&&(dasUfo.gibXUfo()>-800)){
                dasUfo.bewegeLinks();
            }
            if(tastatur.istGedrueckt('d')&&(dasUfo.gibXUfo()<800)){
                dasUfo.bewegeRechts();
            }
            if(tastatur.istGedrueckt('w')){
                dasUfo.bewegeOben();
            }
            if(tastatur.istGedrueckt('s')){
                dasUfo.bewegeUnten();
            }

            Sys.warte(5);
        }
        Sys.beenden(); 
    }
}
