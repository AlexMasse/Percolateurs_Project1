/**
 * Created by ultimatum on 2014-10-02.
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;

public class PercolateursSim1 {

    //temporairement pour scenario test
    private static final int[][] TESTS = {{33, 51, -1}, {38, 50, 24}, {39, 0, 48}};
    private static int nbTests = 0;
    private static int compteurTest = 0;
    private static  boolean test = false;


    public static void main(String[] args) throws Exception
    {
        //TEST
        for (String s: args) {
            System.out.println(s);
            if (s.equals("test1")) {
                test = true;
                nbTests = 2;
                System.out.println("!!!MODE TEST #1!!!");
            }
            if (s.equals("test2")) {
                test = true;
                nbTests = 3;
                compteurTest = 2;
                System.out.println("!!!MODE TEST #2!!!");
            }
        }

        // AMELIORATION APPORTEE : MVC
        ControleurJeuDePari controller = new ControleurJeuDePari();
        // AMELIORATION APPORTEE : Affichage copmplexe
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setTitle("Jeux de paris");
        VueJeuxPari jPanelCarte = new VueJeuxPari(250, 150);
        frame.add(jPanelCarte);
        frame.pack();
        frame.setVisible(true);

        // D�claration des variables
        double argent = 0;
        NumberFormat deuxDeci = new DecimalFormat("#.00");
        int nombreDeCartes = 0;
        boolean jouerPartie;
        // AMELIORATION APPORTEE : 3 int maintenant en 1 array
        int mainDeCartes[] = new int[3];
        int numeroDePari = 0;
        boolean gagnePari;


        controller.initialiserLeJeu(); // Initialisation de l'ordre des cartes

        // Saisie des variables necessaires a l'execution du jeu
        argent = controller.entreeArgent(); // Entree du montant d'argent de l'utilisateur
        jouerPartie = controller.jouerPartie(); // Est-ce l'utilisateur veut jouer?

        // Boucle principale
        while (jouerPartie && argent >= (ControleurJeuDePari.COUT_PARI * 2)) {
            // Saisie des variables n�cessaires pour un pari
            mainDeCartes[2] = -1; // Puisqu'on ne sait pas le nombre de cartes
            nombreDeCartes = controller.nombreDeCartes(argent); // Nombre de cartes jou�es
            argent = argent - (ControleurJeuDePari.COUT_PARI * nombreDeCartes); // Achat des cartes dependament du cout par carte
            numeroDePari = controller.numeroDePari(); // Pari en jeu


            // Affectation et affichage des cartes
            mainDeCartes[0] = PaquetDeCartes.piger();
            mainDeCartes[1] = PaquetDeCartes.piger();
            if ( test && compteurTest <nbTests ) {
                mainDeCartes[0] = TESTS[compteurTest][0];
                mainDeCartes[1] = TESTS[compteurTest][1];
                if (nombreDeCartes < 3) {
                    ++compteurTest;
                }
            }
            System.out.println (MessagesTp2.MESS_CARTE_PIGEES);
            controller.afficherCarte(mainDeCartes[0]);
            controller.afficherCarte(mainDeCartes[1]);
            if (nombreDeCartes == 3) {
                mainDeCartes[2] = PaquetDeCartes.piger();
                if ( test && compteurTest < nbTests ) {
                    mainDeCartes[2] = TESTS[compteurTest][2];
                     ++compteurTest;
                }
                controller.afficherCarte(mainDeCartes[2]);
            }

            // Affichage de la somme des cartes
            System.out.println(controller.sommeCartes(mainDeCartes, nombreDeCartes));

            // AMELIORATION APPORTEE : Affichage complexe
            // Conversion des cartes en objet Carte pour l'affichage graphique
            Carte[] cartes = new Carte[3];
            cartes[0] = new Carte(mainDeCartes[0]);
            cartes[1] = new Carte(mainDeCartes[1]);
            cartes[2] = new Carte(mainDeCartes[2]);

            jPanelCarte.afficher(cartes, nombreDeCartes);
            frame.pack();
            frame.setVisible(true);

            // V�rification si l'utilisateur gagne et ajout du gain
            gagnePari = controller.gagnePari(numeroDePari,mainDeCartes);
            if (gagnePari) { // L'utilisateur a gagn� son pari
                double gain = controller.argentGagne(nombreDeCartes,numeroDePari);
                argent = argent + gain;
                System.out.println (MessagesTp2.MESS_GAGNE + deuxDeci.format(gain) + " $");

            } else { // L'utilisateur a perdu son pari
                System.out.println (MessagesTp2.MESS_PERDU);
            }

            // Fin du pari
            System.out.println (MessagesTp2.MESS_SUITE_AVEC_TOTAL + deuxDeci.format(argent) + " $");

            // V�rification si l'utilisateur peut/veut continuer � jouer
            if (argent < (ControleurJeuDePari.COUT_PARI *2)) {
                System.out.println (MessagesTp2.MESS_PARTIE_FINIE);
            } else {
                jouerPartie = controller.jouerPartie();
            }


        } // while (Boucle principale)

        // Messages de fin de programme

        System.out.println (MessagesTp2.MESS_CONCLUSION + deuxDeci.format(argent) + " $ en poche.");
        System.exit(0);
    }
}
