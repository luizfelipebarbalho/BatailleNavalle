package ensta;
import navires.*;

public class ShipState {
    protected AbstractShip ship;
    protected boolean struck = false;

    public ShipState(){
        this.ship = null; 
    }

    public void setShip(AbstractShip ship){
        this.ship = ship;
    }
    
    public void addStrike(){
        if(this.struck==false){
            ship.addStrike();
            this.struck = true;
        }
    }
        
        //marquer le navire comme touché
    
    public boolean isStruck(){
        return this.struck;
    }
    public boolean isSunk(){ 
        //return vrai si le navile est completement detruit
        return ship.isSunk();
    }
    public AbstractShip getShip(){
        return this.ship;
    }

   

    public char getLabel(){
        return this.ship.getLabel();
        
    }
}