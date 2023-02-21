import GLOOP.*;
import java.lang.*;
public class Asteroid{ 
    private GLKugel kugel;


    public Asteroid(){
        kugel = new GLKugel(Math.random()*1600-800,1000,0, 50, "src/img/Krater.jpg");

    }

    public void bewegeDich(){
        kugel.verschiebe(0,-0.5,0);  

    }
    double x;
    public void haltePosition(){
       // kugel.setzePosition();
    }


}
