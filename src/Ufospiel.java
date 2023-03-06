import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;

    public Asteroid[] asteroid;
    private Ufo dasUfo;
    int ufohoehe, ufolaenge, ufobreite;

    //[...]

    public Ufospiel() {
        kamera = new GLKamera(1600, 900);
        kamera.verschiebe(0, -200, -300);
        kamera.setzeBlickpunkt(0, 0, 150);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        ufohoehe = 2;
        ufolaenge = 25;
        ufobreite = 25;


        dasUfo = new Ufo();
        asteroid = new Asteroid[300];
        for (int i = 0; i < asteroid.length; i++) {
            asteroid[i] = new Asteroid(dasUfo);

        }


        fuehreAus();
    }

    public void fuehreAus() {
        while (!tastatur.esc()) {
            for (int i = 0; i < asteroid.length; i++) {
                asteroid[i].bewegeDich();
                if (asteroid[i].hit()) {
                    dasUfo.farbe();
                    dasUfo.noclip();
                    dasUfo.explosion();
                    Sys.warte(2000);
                    dasUfo.tot();                                               //hier löschen
                    dasUfo.respawn();
                    kamera.setzePosition(0,-300,100);
                    dasUfo.farbeOff();
                    dasUfo.noclipOff();
                }

            }
            if (tastatur.istGedrueckt('a') && (dasUfo.gibXUfo() > -800)) {
                dasUfo.bewegeLinks();
                kamera.verschiebe(-5, 0, 0);
            }
            if (tastatur.istGedrueckt('d') && (dasUfo.gibXUfo() < 750)) {
                dasUfo.bewegeRechts();
                kamera.verschiebe(5, 0, 0);
            }
            if ((tastatur.istGedrueckt('w')) && (dasUfo.gibZUfo() < 1350)) {
                dasUfo.bewegeOben();
                kamera.verschiebe(0, 0, 5);
            }
            if ((tastatur.istGedrueckt('s')) && (dasUfo.gibZUfo() > -150)) {
                dasUfo.bewegeUnten();
                kamera.verschiebe(0, 0, -5);
            }
            if ((!tastatur.istGedrueckt('s')) && (!tastatur.istGedrueckt('w')) && (!tastatur.istGedrueckt('a')) && (!tastatur.istGedrueckt('d'))) {
                dasUfo.normal();
            }
                this.kamerafolge();
                Sys.warte(5);
            }
            Sys.beenden();
        }
        public void kamerafolge () {
            kamera.setzeBlickpunkt(dasUfo.gibXUfo(), dasUfo.gibYUfo(), dasUfo.gibZUfo());

        }
    }



