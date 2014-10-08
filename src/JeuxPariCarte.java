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

     */
    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Jeux de paris");



        VueJeuxCarte jPanelCarte = new VueJeuxCarte(350, 125);
        Carte[] cartes = new Carte[4];
        cartes[0] = new Carte(1,1,0);
        cartes[1] = new Carte(1,1,5);
        cartes[2] = new Carte(1,1,12);
        cartes[3] = new Carte(1,1,10);

        /*
        ImageCarte image = new ImageCarte(carte);
        ImageCarte image2 = new ImageCarte(carte2);
        ImageCarte image3 = new ImageCarte(carte3);
        ImageCarte image4 = new ImageCarte(carte4);
        jPanelCarte.add(image);
        jPanelCarte.add(image2);
        jPanelCarte.add(image3);
        jPanelCarte.removeAll();
        jPanelCarte.add(image4);
        */
        jPanelCarte.ajouter(cartes, 3);
/*
        JPanel jPanelCarte = new JPanel();
        jPanelCarte.setLayout(new FlowLayout());
        jPanelCarte.setBackground(new java.awt.Color(34,139,34));
        jPanelCarte.setPreferredSize(new java.awt.Dimension(300, 200));
        //arte carte = new Carte(1,1);
        ImageIcon imageCarte = new ImageIcon(getClass().getResource("images/c1.png") );
        JLabel jLabelCarte = new JLabel(imageCarte);

        */
        frame.add(jPanelCarte);
        frame.add(jPanelCarte);
        //jPanelCarte.add(image);



        //frame.repaint();
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
