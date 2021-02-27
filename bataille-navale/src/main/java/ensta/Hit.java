package ensta;
import java.util.NoSuchElementException;

public enum Hit {
    MISS(-1, "manqué :'("),
    STRIKE(-2, "touché!!!!!!!!!!"),
    DESTROYER(2, "Frégate DESTROYED"),
    SUBMARINE(3, "Sous-marin DESTROYED"),
    BATTLESHIP(4, "Croiseur DESTROYED"),
    CARRIER(5, "Porte-avion DESTROYED");

    /* ***
     * Attributs
     */
    private int value;
    private String label;

    /* ***
     * Constructeur
     */
    Hit(int value, String label) {
        this.value = value;
        this.label = label;
    }

    /* ***
     * Méthodes
     */
    public static Hit fromInt(int value) {
        for (Hit hit : Hit.values()) {
            if (hit.value == value) {
                return hit;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

    public String toString() {
        return this.label;
    }
};
