/**
 * Created by ultimatum on 2014-10-02.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PercolateursSim1 {

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
        ControleurJeuDePari controller = new ControleurJeuDePari();

        //TODO : Refactorer la methode main en quelques methodes pour diminuer le main

        // D�claration des variables
        double argent = 0;
        int nombreDeCartes = 0;
        boolean jouerPartie;
        int carte1 = 0;
        int carte2 = 0;
        int carte3 = 0;
        int numeroDePari = 0;
        boolean gagnePari;


        controller.initialiserLeJeu(); // Initialisation de l'ordre des cartes

        // Saisie des variables n�cessaires � l'ex�cution du jeu
        argent = controller.entreeArgent(); // Entr�e du montant d'argent de l'utilisateur
        jouerPartie = controller.jouerPartie(); // Est-ce l'utilisateur veut jouer?

        // Boucle principale
        while (jouerPartie == true && argent >= (ControleurJeuDePari.COUT_PARI * 2)) {
            // Saisie des variables n�cessaires pour un pari
            carte3 = -1; // Puisqu'on ne sait pas le nombre de cartes
            nombreDeCartes = controller.nombreDeCartes(argent); // Nombre de cartes jou�es
            argent = argent - (ControleurJeuDePari.COUT_PARI * nombreDeCartes); // Achat des cartes dependament du cout par carte
            numeroDePari = controller.numeroDePari(); // Pari en jeu

            // Affectation et affichage des cartes
            carte1 = PaquetDeCartes.piger();
            carte2 = PaquetDeCartes.piger();
            System.out.println (MessagesTp2.MESS_CARTE_PIGEES);
            controller.afficherCarte(carte1);
            controller.afficherCarte(carte2);
            if (nombreDeCartes == 3) {
                carte3 = PaquetDeCartes.piger();
                controller.afficherCarte(carte3);
            }

            // V�rification si l'utilisateur gagne et ajout du gain
            gagnePari = controller.gagnePari(numeroDePari,carte1,carte2,carte3);
            if (gagnePari) { // L'utilisateur a gagn� son pari
                double gain = controller.argentGagne(nombreDeCartes,numeroDePari);
                argent = argent + gain;
                System.out.print (MessagesTp2.MESS_GAGNE + gain + " $");

            } else { // L'utilisateur a perdu son pari
                System.out.println (MessagesTp2.MESS_PERDU);
            }

            // Fin du pari
            System.out.println (MessagesTp2.MESS_SUITE_AVEC_TOTAL + argent + " $");

            // V�rification si l'utilisateur peut/veut continuer � jouer
            if (argent < (ControleurJeuDePari.COUT_PARI *2)) {
                System.out.println (MessagesTp2.MESS_PARTIE_FINIE);
            } else {
                jouerPartie = controller.jouerPartie();
            }
        } // while (Boucle principale)

        // Messages de fin de programme

        System.out.println (MessagesTp2.MESS_CONCLUSION + argent + " $ en poche.");


        //TODO : J'ai commente l'affichage graphique dans le "main" le temps que ce soit fonctionnel

        /*JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Jeux de paris");

        VueJeuxCarte jPanelCarte = new VueJeuxCarte(400, 200);

        frame.add(jPanelCarte.getjPanel());
        frame.pack();
        frame.setVisible(true);
        System.out.println(PIQUE + "\033[31m" + " g " + CARREAU);
        System.out.println("\033[0m BLACK");*/
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
