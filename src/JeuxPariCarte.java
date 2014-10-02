/**
 * Created by ultimatum on 2014-10-02.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JeuxPariCarte  {



    /*

    Joueur joueur
    Jframe plancheJeux
    Main

     */
    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Jeux de paris");

        VueJeuxCarte jPanelCarte = new VueJeuxCarte(200, 200);

        frame.add(jPanelCarte);
        frame.pack();
        frame.setVisible(true);
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
