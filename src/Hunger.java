import GLOOP.*;
public class Hunger {
    public double geschw1;
    private Ufo dasUfo;
    GLTafel food;
    public Hunger(Ufo pDasUfo, double geschw){
        food = new GLTafel(Math.random()*1600-1000,5000,Math.random()*1500-100,80,80);//y=Math.random()*2000+3000
        food.drehe(-90,0,0);
        food.setzeTextur("src/img/Startkeule.png");
        geschw1=geschw;
        dasUfo = pDasUfo;
    }
    public void reset(){food.setzePosition(Math.random()*1600-1000,5000,Math.random()*1500-100);//y=Math.random()*2000+3000
        System.out.println("true");
    }
    public void dreheEssen() {
        food.drehe(0, 0, 0.005);//0.005


    }
    public void moveEssen(){
        food.verschiebe(0,geschw1,0);
        if(food.gibY()<-200){
            this.reset ();
        }

    }
    public void tot(){
        food.setzePosition(Math.random()*1600-1000,5000,Math.random()*1500-100);
    }
    public boolean hit() {
        double distance = Math.sqrt(Math.pow(food.gibX() - dasUfo.gibXUfo(), 2) + Math.pow(food.gibY() - dasUfo.gibYUfo(), 2) + Math.pow(food.gibZ() - dasUfo.gibZUfo(), 2));
        if (distance<60) return true;
        else return false;
    }



}

