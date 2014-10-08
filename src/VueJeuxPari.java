/**
 * Created by ultimatum on 2014-10-07.
 */
import javax.swing.*;

public class VueJeuxPari extends JPanel {

    final private static java.awt.Color COULEUR_TAPIS =  new java.awt.Color(34,129,34);

    public VueJeuxPari(int hauteur, int largeur) {
        this.setBackground(COULEUR_TAPIS);
        this.setPreferredSize(new java.awt.Dimension(hauteur,largeur));

    }

    public void ajouter(Carte[] cartes, int nombre) {
        this.removeAll();
        for (int i = 0; i < nombre; ++i) {
            this.add(new ImageCarte(cartes[i]));
        }
        repaint();
    }
}
