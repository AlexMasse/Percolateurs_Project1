/**
 * INF6150
 *
 * Represente une carte a jouer possedant une couleur et une valeur determine
 * par sa position dans un paquet de cartes. Il est laisse a l'utilisateur de
 * decider comment utiliser ces valeurs. Une carte est immuable une fois instanciee.
 *
 * Creation      : 2014/10/07
 * @author Percolateurs
 * @version 1.0
 *
 */

public class Carte {

    private final int couleur;
    private final int valeur;
    private final int positionPaquet;

    /**
     * Intancie une carte en lui fournissant la couleurm la valeur et sa position
     * dans le paquet.
     *
     * @param couleur la couleur de la carte
     * @param valeur la valeur de la carte
     * @param positionPaquet la position de la carte dans le paquet
     */
    public Carte (int couleur, int valeur, int positionPaquet) {
        this.couleur = couleur;
        this.valeur  = valeur;
        this.positionPaquet = positionPaquet;
    }

    /**
     * Intancie une carte en lui fournissant sa position
     * dans le paquet.
     *
     * @param positionPaquet La position dans le paquet
     */
    public Carte (int positionPaquet) {
        this.couleur = PaquetDeCartes.couleur(positionPaquet);
        this.valeur  = PaquetDeCartes.valeur(positionPaquet);
        this.positionPaquet = positionPaquet;
    }

    /**
     * Retourne la valeur de la carte
     * @return La valeur de la carte
     */
    public int getValeur() {

        return this.valeur;
    }

    /**
     * Retourne la couleur de la carte
     * @return la couleur de la carte
     */
    public int getCouleur() {

        return this.couleur;
    }

    /**
     * Retourne la position de la carte dans le paquet
     * @return la position de la carte dans le paquet
     */
    public int getPositionPaquet() {

        return this.positionPaquet;
    }
}
