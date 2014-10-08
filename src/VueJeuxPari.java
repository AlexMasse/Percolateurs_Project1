/**
 * Created by ultimatum on 2014-10-07.
 */
import javax.swing.*;

public class VueJeuxPari extends JPanel {

    public static String PIQUE   = "\u2660";
    public static String COEUR   = "\u2665";
    public static String TREFLE  = "\u2663";
    public static String CARREAU = "\u2666";
    final private static String[] COULEURS = {"\u2665", "\u2666", "\u2663", "\u2660"};

    final private static java.awt.Color COULEUR_TAPIS =  new java.awt.Color(34,129,34);

    public VueJeuxPari(int hauteur, int largeur) {
        this.setBackground(COULEUR_TAPIS);
        this.setPreferredSize(new java.awt.Dimension(hauteur,largeur));

    }

    public void afficher(Carte[] cartes, int nombre) {
        this.removeAll();
        for (int i = 0; i < nombre; ++i) {
            this.add(new ImageCarte(cartes[i]));
            afficherConsole(cartes[i]);
        }
        repaint();
    }

    private void afficherConsole(Carte carte) {
        System.out.println(".---.");
        System.out.println("|" + COULEURS[carte.getCouleur()] + "" + carte.getValeur() + " |");
        System.out.println("| "  + "" + carte.getValeur() + COULEURS[carte.getCouleur()] + "|");
        System.out.println("'---'");
    }

}
