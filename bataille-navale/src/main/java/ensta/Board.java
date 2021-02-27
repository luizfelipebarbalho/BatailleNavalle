package ensta;
import navires.AbstractShip;

public class Board implements IBoard {
 
    private ShipState[][] ships;
    private Boolean[][] shots;
    private String name;
    private int size;

    public Board(String name, int size){

        this.name = name;
        this.size = size;
        this.ships = new ShipState[this.size][this.size];
        this.shots = new Boolean[this.size][this.size];

        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                this.ships[i][j] = new ShipState();
                this.shots[i][j] = null;
            }
        }
    }

    public Board(String name){
        this.name = name;
        this.size = 10;
        this.ships = new ShipState[10][10];
        this.shots = new Boolean[10][10];

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.ships[i][j] = new ShipState();
                this.shots[i][j] = null;
            }
        }

    }

    public String getName(){return name;}
    public int getSize(){return size;}   //interface
    
    public void DrawShips(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            if(alphabet.charAt(i)=='A'){
                System.out.print("   " +alphabet.charAt(i));
            }
            else{
                System.out.print(" " +alphabet.charAt(i));
            }
            
        }
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            if(i<9){System.out.print(i+1 + "  ");}
            else{
                System.out.print(i+1 + " ");
            }
            
            for(int j=0; j<this.size; j++){
                if(ships[i][j].getShip() == null){System.out.print(". ");}
                else if(shots[i][j]!=null){System.out.print(ColorUtil.colorize(ships[i][j].getShip().getLabel() + " ",ColorUtil.Color.RED));}
                else{System.out.print(ColorUtil.colorize(ships[i][j].getShip().getLabel() + " ",ColorUtil.Color.WHITE));}
                
            }
            System.out.println(" ");
        }
    }

    public void DrawShots(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
           if(alphabet.charAt(i)=='A'){
                System.out.print("   " +alphabet.charAt(i));
            }
            else{
                System.out.print(" " +alphabet.charAt(i));
            }
        }
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            if(i<9){System.out.print(i+1 + "  ");}
            else{
                System.out.print(i+1 + " ");
            }
            for(int j=0; j<this.size; j++){

                if(shots[i][j]==null){
                    System.out.print(ColorUtil.colorize("." + " ",ColorUtil.Color.WHITE));
                }
                else if(shots[i][j]==false){
                    System.out.print(ColorUtil.colorize("X" + " ",ColorUtil.Color.WHITE));
                }
                else if(shots[i][j]==true){
                    System.out.print(ColorUtil.colorize("X" + " ",ColorUtil.Color.RED));

                }
               
            }
            System.out.println(" ");
        }
    }
    public void putShip(AbstractShip ship, int x, int y) throws ArrayIndexOutOfBoundsException
    {

         for(int k=0;k<ship.getTaille();k++)
         {
            if(ship.getOrientation() == Orientation.WEST)
                if(x-k<0 || x-k > this.size || this.ships[y][x-k].getShip() != null)
                    throw new ArrayIndexOutOfBoundsException("NOT POSSIBLE");


            if(ship.getOrientation() == Orientation.EAST)
                if(x+k<0 || x+k>this.size || this.ships[y][x+k].getShip() != null)
                    throw new ArrayIndexOutOfBoundsException("NOT POSSIBLE");


            if(ship.getOrientation() == Orientation.SOUTH)
                if(y+k<0|| y+k>this.size || this.ships[y+k][x].getShip() != null)
                    throw new ArrayIndexOutOfBoundsException("NOT POSSIBLE");
            
            if(ship.getOrientation() == Orientation.NORTH)
                if (y-k<0 || y-k>this.size || this.ships[y-k][x].getShip() != null)
                    throw new ArrayIndexOutOfBoundsException("NOT POSSIBLE");


         }

        for(int k=0;k<ship.getTaille();k++)
         {
            if(ship.getOrientation() == Orientation.WEST)
                this.ships[y][x-k].setShip(ship);

            if(ship.getOrientation() == Orientation.EAST)
                this.ships[y][x+k].setShip(ship);

            if(ship.getOrientation() == Orientation.SOUTH)
                this.ships[y+k][x].setShip(ship);

            if(ship.getOrientation() == Orientation.NORTH)
                this.ships[y-k][x].setShip(ship);

         }
        
    }

    public void Print(){
        this.DrawShips();
        this.DrawShots();
    }

        /**
    * Sends a hit at the given position
    * @param x
    * @param y
    * @return status for the hit (eg : strike or miss)
    */
    public Hit sendHit(int x, int y)
    {
        if(this.ships[y][x].getShip()== null) return Hit.MISS;
        else
        {   
                this.ships[y][x].addStrike();

                if(this.ships[y][x].isSunk()) return Hit.fromInt(this.ships[y][x].getShip().getTaille());
                
                else return Hit.STRIKE;
                   
        }
                
    }
    public boolean hasShip(int x, int y){
        if(this.ships[y][x].getShip()==null){
            return false;
        }
        else{
            return true;
        }
    }
    public void setHit(boolean hit, int x, int y){
        this.shots[y][x]= hit;
        
    }
    public Boolean getHit(int x, int y){
        return this.shots[y][x];
    }


}
