package navires;
import ensta.Orientation;

public class BattleShip extends AbstractShip {   

    public BattleShip(Orientation orientation){
        super('B', "BattleShip", 4, orientation);  
    }
    public BattleShip(){
        super('B', "BattleShip", 4, Orientation.EAST);
    }
    @Override
    public String toString(){
        return super.toString();
    }



}