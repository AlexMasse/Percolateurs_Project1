/**
 * Created by ultimatum on 2014-10-02.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JeuxPariCarte  {

    public static String PIQUE   = "\u2660";
    public static String COEUR   = "\u2665";
    public static String TREFLE  = "\u2663";
    public static String CARREAU = "\u2666";

    /*

    Joueur joueur
    Jframe plancheJeux
    Main


    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Jeux de paris");

        VueJeuxCarte jPanelCarte = new VueJeuxCarte(400, 200);

        frame.add(jPanelCarte);
        frame.pack();
        frame.setVisible(true);
        System.out.println(PIQUE + "\033[31m" + " g " + CARREAU);
        System.out.println("\033[0m BLACK");
    }

    public void creerPanneauJeux() {

    }

    //si on veut traiter la fermeture de la fenetre
    /*
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }


    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    */
}
