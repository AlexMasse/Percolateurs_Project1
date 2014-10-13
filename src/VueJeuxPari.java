/**
 * INF6150
 *
 * Gere l'affichage des cartes du jeu
 *
 * Creation      : 2014/10/07
 * @author Percolateurs
 * @version 1.0
 *
 */
import javax.swing.*;

public class VueJeuxPari extends JPanel {

    //representation unicode du sigle de coeur, carreau, trefle et pique
    final private static String[] COULEURS = {"\u2665", "\u2666", "\u2663", "\u2660"};
    //couleur de l'arriere plan du jeu (vert "casino")
    final private static java.awt.Color COULEUR_TAPIS =  new java.awt.Color(34,129,34);

    public VueJeuxPari(int hauteur, int largeur) {
        this.setBackground(COULEUR_TAPIS);
        this.setPreferredSize(new java.awt.Dimension(hauteur,largeur));

    }

    /**
     * Retire toutes les cartes de l'affichage
     */
    public void vider() {
        this.removeAll();
    }

    /**
     * Affiche les cartes contenues dans un tableau a la console
     * et les ajoutes dans l'affichage complexe.
     *
     * @param cartes le tableau de cartes
     * @param nombre le nombre de cartes dans le tableau
     */
    public void afficher(Carte[] cartes, int nombre) {
        this.removeAll();
        for ( int i = 0; i < nombre; ++i ) {
            this.add( new ImageCarte(cartes[i]) );
            afficherConsole(cartes[i]);
        }
        repaint();
    }

    /**
     * Affiche une carte a la console
     * @param carte la carte a afficher
     */
    private void afficherConsole(Carte carte) {
        //cadre superieur
        String dessus = ".---.";
        //cadre inferieur
        String dessous = "'---'";
        //convertion des cartes > 10 en leur valeur literaire
        String valeur;

        switch (carte.getValeur()) {
            case 1:
                valeur = "A";
                break;
            case 11:
                valeur = "V";
                break;
            case 12:
                valeur = "D";
                break;
            case 13:
                valeur = "K";
                break;
            default:
                valeur = Integer.toString(carte.getValeur());
                break;
        }

        System.out.println(dessus);
        if (carte.getValeur() != 10) {
            System.out.println("|" + COULEURS[carte.getCouleur()] + "" + valeur + " |");
            System.out.println("| " + "" + valeur + COULEURS[carte.getCouleur()] + "|");
        } else {
            System.out.println("|" + COULEURS[carte.getCouleur()] + "" + valeur + "|");
            System.out.println("|" + "" + valeur + COULEURS[carte.getCouleur()] + "|");
        }

        System.out.println(dessous);
    }

}
