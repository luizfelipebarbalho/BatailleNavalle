package navires;
import ensta.Orientation;

public class Submarine extends AbstractShip {
   

    public Submarine(Orientation orientation){
        super('S', "Submarine", 1, orientation);  
    }
    public Submarine(){
        super('S', "Submarine", 1, Orientation.EAST);
    }

    @Override
    public String toString(){
        return super.toString();
    }



}