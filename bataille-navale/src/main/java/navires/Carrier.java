package navires;
import ensta.Orientation;

public class Carrier extends AbstractShip {
   

    public Carrier(char label,String nom, int taille, Orientation orientation){
        super(label, nom, taille, orientation);
       
    }

    @Override
    public String toString(){
        return super.toString();
    }



}