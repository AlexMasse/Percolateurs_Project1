/**
 * Created by ultimatum on 2014-10-02.
 */
public class Carte {

    private final int couleur;
    private final int valeur;
    private final int positionPaquet;

    //doit être une carte valide
    public Carte (int couleur, int valeur, int positionPaquet) {
        this.couleur = couleur;
        this.valeur  = valeur;
        this.positionPaquet = positionPaquet;
    }

    public int getValeur() {

        return this.valeur;
    }
    public int getCouleur() {

        return this.couleur;
    }
    public int getPositionPaquet() {

        return this.positionPaquet;
    }


}
