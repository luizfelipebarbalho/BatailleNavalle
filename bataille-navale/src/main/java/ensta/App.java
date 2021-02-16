package ensta;
import navires.*;


public class App 
{
   public static void main( String[] args )
    {
        Board x = new Board("Luiz", 15);
        Carrier c = new Carrier('A',"Carrier", 3, Orientation.NORTH);
        Destroyer d = new Destroyer('B',"Destroyer", 3, Orientation.WEST);
        x.putShip(c, 3,1);
        x.putShip(d, 2,3);
        x.DrawShips();
        x.DrawShots();
        
    }
}
