package navires;
import ensta.Orientation;

public abstract class AbstractShip {
    protected char label ;
    protected String nom ;
    protected int taille;
    protected Orientation orientation;

    static int nbShips = 0;
    public AbstractShip(char label,String nom, int taille, Orientation orientation){
        this.label = label;
        this.nom = nom;
        this.taille = taille;
        this.orientation = orientation;
        nbShips++;
    }

    public static int getNbShips(){
        return nbShips;
    }


    public int getTaille(){return taille;}
    public String getNom(){return nom;}
    public char getLabel(){return label;}
    public Orientation getOrientation(){return orientation;}

    public void setLabel(char label){this.label = label;}
    public void setNom(String nom){this.nom = nom;}
    public void setTaille(int taille){this.taille=taille;}
    public void setOrientation(Orientation ori){this.orientation=ori;}

    @Override
    public String toString(){
        return "LABEL: "+label+" / nom: "+nom+" / Taille: "+taille+"/Orientation: "+orientation;
    }
}