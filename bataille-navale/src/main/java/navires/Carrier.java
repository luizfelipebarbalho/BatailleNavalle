package navires;
import ensta.Orientation;

public class Carrier extends AbstractShip {
   

    public Carrier(Orientation orientation){
        super('C', "Carrier", 4, orientation);  
    }
    public Carrier(){
        super('C', "Carrier", 4, Orientation.EAST);
    }

    @Override
    public String toString(){
        return super.toString();
    }



}