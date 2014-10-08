/**
 * Created by ultimatum on 2014-10-07.
 */
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class ImageCarte extends JLabel{

    private final Carte carte;
    private final ImageIcon  faceCarte;


    public ImageCarte(Carte carte) {
        super();
        this.carte = carte;
        this.faceCarte = new ImageIcon(getClass().getResource("images/" + carte.getPositionPaquet() + ".png"));
        setIcon(this.faceCarte);
    }
}
