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
        kamera.verschiebe(0,-200,-300);
        kamera.setzeBlickpunkt(0, 0, 150);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();
        asteroid = new Asteroid[400];
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
                kamera.verschiebe(-5,0,0);
            }
            if(tastatur.istGedrueckt('d')&&(dasUfo.gibXUfo()<800)){
                dasUfo.bewegeRechts();
                kamera.verschiebe(5,0,0);
            }
            if(tastatur.istGedrueckt('w')){
                dasUfo.bewegeOben();
                kamera.verschiebe(0,0,5);
            }
            if(tastatur.istGedrueckt('s')){
                dasUfo.bewegeUnten();
                kamera.verschiebe(0,0,-5);
            }
            if((!tastatur.istGedrueckt('s'))&&(!tastatur.istGedrueckt('w'))&&(!tastatur.istGedrueckt('a'))&&(!tastatur.istGedrueckt('d'))){
                dasUfo.normal();
            }
            this.kamerafolge();
            Sys.warte(5);
        }
        Sys.beenden(); 
    }
    public void kamerafolge(){
        kamera.setzeBlickpunkt(dasUfo.gibXUfo(), dasUfo.gibYUfo(), dasUfo.gibZUfo());

    }
}


