/**
 * Created by ultimatum on 2014-10-07.
 */
import javax.swing.*;

public class VueJeuxPari extends JPanel {

    final private static String[] COULEURS = {"\u2665", "\u2666", "\u2663", "\u2660"};

    final private static java.awt.Color COULEUR_TAPIS =  new java.awt.Color(34,129,34);

    public VueJeuxPari(int hauteur, int largeur) {
        this.setBackground(COULEUR_TAPIS);
        this.setPreferredSize(new java.awt.Dimension(hauteur,largeur));

    }
    public void vider() {
        this.removeAll();
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
        String dessus = ".---.";
        String dessous = "'---'";
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
