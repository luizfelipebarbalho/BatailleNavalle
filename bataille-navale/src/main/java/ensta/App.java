package ensta;
import navires.*;
import java.util.*;


public class App 
{
   public static void main( String[] args )
    {   int[] v = new int[2];
        Board x = new Board("Luiz", 15);

        //x.DrawShips();
        List<AbstractShip> bats = new ArrayList<AbstractShip>();
        bats.add(new BattleShip(Orientation.NORTH));
        bats.add(new BattleShip(Orientation.NORTH));
        bats.add(new BattleShip(Orientation.NORTH));
        bats.add(new BattleShip(Orientation.NORTH));
        bats.add(new BattleShip(Orientation.NORTH));
        
        
        Player p = new Player(x,x,bats);
        p.putShips();
        p.sendHit(v);
        p.sendHit(v);
        p.sendHit(v);
        p.sendHit(v);
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        x.DrawShips();
        x.DrawShots();
        
    }
}
