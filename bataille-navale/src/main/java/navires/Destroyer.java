package navires;
import ensta.Orientation;

public class Destroyer extends AbstractShip {
   

    public Destroyer(Orientation orientation){
        super('D', "Destroyer", 3, orientation);  
    }
    public Destroyer(){
        super('D', "Destroyer", 3, Orientation.EAST);
    }
    @Override
    public String toString(){
        return super.toString();
    }



}