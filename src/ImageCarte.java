/**
 * INF6150
 *
 * Represente l'image d'une carte a jouer. Les images doivent se trouver
 * dans le repertoire ./images et etre nommees selon leur position dans le paquet.
 * On manipule l'image de la carte comme un JLabel.
 *
 * Droits d'auteur sur les images  :
 * John Fitzgibbon. «Original "Windows" Playing Cards».  In Playing cards. cards_png.zip. [fichier .zip]. jfitz.com, [En ligne],
 * http://www.jfitz.com/cards/index.html (Page consultee le 1er octobre 2014)
 *
 * notice originale
 *
 * These images were created using GIFCon, XnView and Paint Shop Pro.
 * Feel free to use for personal or professional purposes, subject to the following:
 * Additional Copyright information:
 * Larry Ewing <lewing@isc.tamu.edu> created Tux using GIMP.
 * Marshall Kirk McKusick <mckusick@mckusick.com> is the copyright holder and creator of the BSD Daemon image.
 * The "Windows" cards were originally designed by Susan Kare for Microsoft.
 * To the best of my knowledge, the images used in any "standard" French/British 52 card deck are public domain.
 * The top Jokers are derived from an image I found of a John Waddington design.
 * The bottom Jokers were created by me as quick placeholders for a design I never got around to implementing.
 * I guess it's possible that Microsoft could claim copyright on the Windows Ace of Spades.
 * If they did, I'd suggest filling in or changing the white pattern on the Spade.
 *
 * Creation      : 2014/10/07
 * @author Percolateurs
 * @version 1.0
 *
 */
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class ImageCarte extends JLabel{

    //la carte a afficher
    private final Carte carte;
    //l'image de la carte
    private final ImageIcon  faceCarte;

    /**
     * Construit un JLabel avec l'image de la carte
     * @param carte la carte qui doit [etre affichee.
     */
    public ImageCarte(Carte carte) {
        super();
        this.carte = carte;
        this.faceCarte = new ImageIcon(getClass().getResource("images/" + carte.getPositionPaquet() + ".png"));
        setIcon(this.faceCarte);
    }
}
