package ensta;
import navires.*;
import java.io.Serializable;
import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();

            // TODO set ship orientation
            if(res.orientation.contains("n"))ships[i].setOrientation(Orientation.NORTH);
            if(res.orientation.contains("s"))ships[i].setOrientation(Orientation.SOUTH);
            if(res.orientation.contains("e"))ships[i].setOrientation(Orientation.EAST);
            if(res.orientation.contains("w"))ships[i].setOrientation(Orientation.WEST);

            // TODO put ship at given position
            try{
                board.putShip(ships[i],res.x,res.y);
            }
            catch(ArrayIndexOutOfBoundsException e){
                 //TODO when ship is positioned    
                System.out.println(e.getMessage());
                i--;
            }
            ++i;
            done = i == 5;

            board.DrawShips();

                       
        } while (!done);
    }

    public Hit sendHit(int[] coords) 
    {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();

            // TODO call sendHit on this.opponentBoard
            coords[0]= hitInput.x;
            coords[1]= hitInput.y;

            if(hitInput.x < 0 || hitInput.y < 0 || hitInput.x >= board.getSize() || hitInput.x >= board.getSize())
                System.out.println("Shot out of bounds");

            else if(board.getHit(hitInput.x, hitInput.y) == null)
            {
                hit = this.opponentBoard.sendHit(hitInput.x,hitInput.y);
                
                if(hit == Hit.MISS) this.board.setHit(false,hitInput.x,hitInput.y);

                else  this.board.setHit(true,hitInput.x,hitInput.y);

                System.out.println(hit.toString());
                done = true; 
                board.Print();

            }

            else
                System.out.println("Position already attacked");
            

           
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
