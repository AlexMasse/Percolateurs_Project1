/**
 * Created by ultimatum on 2014-10-02.
 */
public class Carte {
    private final int couleur;
    private final int valeur;

    //doit être une carte valide
    public Carte (int positionPaquet ) {
        if (positionPaquet < 1 || positionPaquet > 52) {
            throw new IllegalArgumentException();
        }
        this.couleur = couleurCarte(positionPaquet);
        this.valeur  = valeurCarte(positionPaquet);
    }

    public String couleurToString() {

        return "";
    }
    public int getValeur() {
        return this.valeur;
    }
    public int getCouleur() {
        return this.couleur;
    }
    private int couleurCarte(int positionPaquet) {
        return 0;
    }
    private int valeurCarte(int positionPaquet) {
        return 0;
    }

}
