package navires;
import ensta.Orientation;

public class BattleShip extends AbstractShip {   

    public BattleShip(Orientation orientation){
        super('B', "BattleShip", 3, orientation);  
    }
    public BattleShip(){
        super('B', "BattleShip", 3, Orientation.EAST);
    }
    @Override
    public String toString(){
        return super.toString();
    }



}