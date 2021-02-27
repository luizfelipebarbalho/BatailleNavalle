package ensta;
import navires.*;
import java.util.*;


public class App 
{
   public static void main( String[] args )
    {   int[] coord = new int[2];
        Board x = new Board("Luiz", 15);
        BattleShipsAI ia = new BattleShipsAI(x,x);
        int nav_detruit = 0;
        Hit hit = null;

        //x.DrawShips();
        List<AbstractShip> bats = new ArrayList<AbstractShip>();
        bats.add(new Destroyer(Orientation.NORTH));
        bats.add(new Submarine(Orientation.NORTH));
        bats.add(new Submarine(Orientation.NORTH));
        bats.add(new BattleShip(Orientation.NORTH));
        bats.add(new Carrier(Orientation.NORTH));
        
        ia.putShips(bats.toArray(new AbstractShip[0]));
        
     
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        
        
        x.DrawShips();
        x.DrawShots();

        while (nav_detruit < 5)
        {
            hit = ia.sendHit(coord);
            
            if(hit != Hit.MISS && hit != Hit.STRIKE)nav_detruit += 1;

            System.out.printf("(%C , %d) \n", 65 + coord[0],coord[1]);
            System.out.println(hit.toString()); 
             System.out.println("");
        }

        x.DrawShips();
        x.DrawShots();
        
    }
}
