package ensta;
import navires.AbstractShip;

public class Board {
 
    private char[][] Ships;
    private boolean[][] Shots;
    private String name;
    private int size;

    public Board(String name, int size){
        this.name = name;
        this.size = size;
        Ships = new char[this.size][this.size];
        Shots = new boolean[this.size][this.size];

        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                Ships[i][j] = '.';
                Shots[i][j] = false;
            }
        }
    }

    public Board(String name){
        this.name = name;
        this.size = 10;
        Ships = new char[10][10];
        Shots = new boolean[10][10];

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Ships[i][j] = '.';
                Shots[i][j] = false;
            }
        }

    }

    public String getName(){return name;}
    public int getSize(){return size;}   //interface
    
    public void DrawShips(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            System.out.print(" " +alphabet.charAt(i));
        }
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            System.out.print(i + " ");
            for(int j=0; j<this.size; j++){
                System.out.print(Ships[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void DrawShots(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            System.out.print(" " +alphabet.charAt(i));
        }
        System.out.println(" ");
        for(int i=0; i<this.size; i++){
            System.out.print(i + " ");
            for(int j=0; j<this.size; j++){
                if(Shots[i][j]==true){
                    System.out.print("X" + " ");
                }
                else{
                    System.out.print("." + " ");
                }
                
            }
            System.out.println(" ");
        }
    }
    boolean putShip(AbstractShip ship, int x, int y){
        boolean thereisaboat = false;
        //PARA CHECAR SE É POSSIVEL BOTAR O BARCO
         if(x<this.size && y<this.size && Ships[x][y]=='.'){
                      if(ship.getOrientation() == Orientation.NORTH){
                         for(int k=0;k<ship.getTaille();k++){
                               if(x-k>=0 && x-k<this.size && Ships[x-k][y] != '.'){
                                  thereisaboat = true ;
                                }   
                            }
                        }
                      if(ship.getOrientation() == Orientation.SOUTH){
                          for(int k=0;k<ship.getTaille();k++){
                               if(x+k<this.size && Ships[x+k][y] != '.'){
                                   thereisaboat = true ;
                                }
                            }
                         }
                        if(ship.getOrientation() == Orientation.EAST){
                         for(int k=0;k<ship.getTaille();k++){
                             if(y+k<this.size && Ships[x][y+k] != '.'){
                                    thereisaboat = true ;
                                }
                            }
                        }
                       if(ship.getOrientation() == Orientation.WEST){
                         for(int k=0;k<ship.getTaille();k++){
                               if (y-k>=0 && y-k<this.size && Ships[x][y-k] != '.'){
                                    thereisaboat = true ;
                               }
                            }
                        }  
                    
                
                
            
        }
       
        //PARA PREENCHER O BARCO
       
        if(x<this.size && y<this.size && Ships[x][y]=='.' && thereisaboat == false){
                      if(ship.getOrientation() == Orientation.NORTH){
                         for(int k=0;k<ship.getTaille();k++){
                               if(x-k>=0 && x-k<this.size){
                                  Ships[x-k][y] = ship.getLabel();
                                }   
                            }
                            return true;
                        }
                      if(ship.getOrientation() == Orientation.SOUTH){
                          for(int k=0;k<ship.getTaille();k++){
                               if(x+k<this.size){
                                   Ships[x+k][y] = ship.getLabel();
                                }
                            }
                            return true;
                         }
                        if(ship.getOrientation() == Orientation.EAST){
                         for(int k=0;k<ship.getTaille();k++){
                             if(y+k<this.size){
                                 Ships[x][y+k] = ship.getLabel();
                                }
                            }
                            return true;
                        }
                       if(ship.getOrientation() == Orientation.WEST){
                         for(int k=0;k<ship.getTaille();k++){
                               if (y-k>=0 && y-k<this.size){
                                   Ships[x][y-k] = ship.getLabel();
                               }
                            }
                            return true;
                        }  
                    
                
                
            
        }
         else{
            System.out.println("Coordinates Out of Range or Already Filled");
            return false;
        }
        
        
    };
    public void Print(){
        this.DrawShips();
        this.DrawShots();
    }
    

}
