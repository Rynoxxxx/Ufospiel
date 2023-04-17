import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht,licht1;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel counter,coins, Leben1, Leben2, Leben3;
    private GLTafel [] leben,essen;
    public Asteroid[] asteroid;
    private Ufo dasUfo;
    private Coins coin;
    private Hunger hunger;
    int ufohoehe, ufolaenge, ufobreite,zahl, x, ubrigLeben, y, ubrigHunger, zeit;


    //[...]

    public Ufospiel() {
        kamera = new GLKamera();
        kamera.verschiebe(0, -200, -300);
        kamera.setzeBlickpunkt(0, 0, 150);
        licht = new GLLicht();
        licht1 = new GLLicht(0,-500,-500);
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        counter = new GLTafel(0,-140,150,190,15);
        counter.drehe(74.5,0,0);
        counter.setzeFarbe(128/255,128/255,128/255);
        counter.setzeKamerafixierung(true);
        ufohoehe = 2;
        zahl = 0;

        x=0;
        y=0;
        ubrigLeben=5;
        ubrigHunger=1;
        leben = new GLTafel[6];
        essen = new GLTafel[3];

        //essen
        for (int i=0; i< essen.length; i++){
            essen[i] = new GLTafel(54-y,-141,153,10,10,"src/img/Startkeule.png");
            essen[i].setzeKamerafixierung(true);
            essen[i].drehe(95,180,0);
            y=y+15;


        }
        essen[1].setzeSichtbarkeit(false);
        essen[2].setzeSichtbarkeit(false);

        //leben
        for (int i=0; i< leben.length; i++){
            leben[i] = new GLTafel(-64+x,-141,153,12,12,"src/img/herz1.png");
            leben[i].setzeKamerafixierung(true);
            leben[i].drehe(95,180,0);
            x=x+10;
        }

        coins = new GLTafel(0,-141,153,15,2);
        coins.drehe(74.5,0,0);
        coins.setzeKamerafixierung(true);
        coins.setzeText(String.valueOf(zahl),8);
        ufolaenge = 25;
        ufobreite = 25;
        dasUfo = new Ufo();
        coin = new Coins(dasUfo,-0.05);
        coin.tot();
        hunger = new Hunger(dasUfo,-0.1);
        hunger.tot();
        asteroid = new Asteroid[200];
        for (int i = 0; i < asteroid.length; i++) {
            asteroid[i] = new Asteroid(dasUfo, -(Math.random()*10+5), Math.random()*25+25);

        }


        fuehreAus();
    }

    public void fuehreAus() {
        zeit=0;
        while (!tastatur.esc()) {
            for (int i = 0; i < asteroid.length; i++) {
                asteroid[i].bewegeDich();
                asteroid[i].drehe();
                //---------------coin
                coin.moveCoin();
                coin.dreheCoin();
                if(coin.hit()){
                    zahl= zahl+1;
                    coins.setzeText(String.valueOf(zahl),8);
                    coin.reset();
                }
                //---------------essen
                hunger.moveEssen();
                hunger.dreheEssen();
                if(hunger.hit()){
                    if ((ubrigHunger>-1)&&(ubrigHunger<3)){
                        zeit=0;
                        essen[ubrigHunger].setzeSichtbarkeit(true);
                        ubrigHunger++;
                    }

                    hunger.reset();
                }
                if (ubrigHunger==3){
                    if (!(ubrigLeben ==5)){
                        ubrigLeben++;
                        ubrigHunger--;
                        essen[2].setzeSichtbarkeit(false);
                        leben[ubrigLeben].setzeSichtbarkeit(true);
                    }
                }
                //---------------asteroid
                if (asteroid[i].hit()) {
                    dasUfo.farbe();
                    dasUfo.noclip();
                    dasUfo.explosion();
                    if(ubrigLeben==0){

                        Sys.beenden();
                    }
                    if (ubrigLeben>-1){
                        leben[ubrigLeben].setzeSichtbarkeit(false);
                        ubrigLeben--;
                    }

                    Sys.warte(2000);
                    dasUfo.tot();
                    dasUfo.respawn();
                    kamera.setzePosition(0,-300,100);
                    for (int e = 0; e < asteroid.length; e++) {
                        asteroid[e].tot();
                    }
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
                zeit=zeit+5;
                if(zeit==10000){
                    zeit=0;
                    if(ubrigHunger==1){
                        essen[0].setzeSichtbarkeit(false);
                        ubrigHunger--;
                        Sys.warte(10000);
                        //System.out.println("lelelelelelle");
                        Sys.beenden();
                    }
                    if(ubrigHunger==2){
                        essen[1].setzeSichtbarkeit(false);
                        ubrigHunger--;
                    }
                    if(ubrigHunger==3){
                        essen[2].setzeSichtbarkeit(false);
                        ubrigHunger--;
                    }


                }
            }

        Sys.beenden();
        }
        public void kamerafolge () {
            kamera.setzeBlickpunkt(dasUfo.gibXUfo(), dasUfo.gibYUfo(), dasUfo.gibZUfo());

        }
    }



