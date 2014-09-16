

import java.util.*;   // pour pouvoir utiliser Random

/**
 * Generation de cartes aleatoires.
 * Un jeu de carte contient 52 cartes.  Chacune sera representee par un nombre entre 0 et 51.
 * 
 * @author Louise Laforest 
 * @version 2006-10-22
 */

public class PaquetDeCartes {

    /**
     * Initialise le processus aleatoire.  Un meme germe generera les memes cartes
     * @param germe pour initialiser le processus aleatoire
     */
    public static void initialiserJeuDeCarte ( int germe ) {
        generateur = new Random ( germe );
    } // initialiserJeuDeCarte

    /**
     * Brasse le paquet de cartes.
     */
    public static void brasser () {
        for ( int i = nombreCartesPigees; i < NOMBRE_CARTES; i++ ) {
            int j = alea ( nombreCartesPigees, i );
            int temp = paquet[i];
            paquet[i] = paquet[j];
            paquet[j] = temp;
        }
    }

    /**
     * Retourne la premiere carte sur le dessus du paquet.
     * La carte est retiree du paquet.
     * @return carte pigee (nombre entre 0 et NOMBRE_CARTES - 1)
     */
    public static int piger () {
        int reponse;
        if ( nombreCartesPigees == NOMBRE_CARTES ) {
            // rebrasser les cartes
            nombreCartesPigees = 0;
            brasser();
        }
        reponse = paquet [ nombreCartesPigees ];
        nombreCartesPigees++;
        return reponse;
    }
    
    /**
      * Determine si une carte est valide ou non
      * @param carte un nombre entier
      * @return true si carte est entre 0 et NOMBRE_CARTES - 1 inc., false sinon
      */
    public static boolean carteValide ( int carte ) {
        return carte >= 0 && carte < NOMBRE_CARTES;
    }
    
    /**
     * Retourne un nombre entre 0 et 3 inclusivement correspondant a l'une des 4 couleurs
     * (coeur, carreau, trefle, pique) 
     * @param carte un nombre entre 0 et NOMBRE_CARTES - 1 inc.
     * @return 0, 1, 2 ou 3 si la carte est valide, -1 sinon
     */
    public static int couleur ( int carte ) {
        int reponse = -1;
        if ( carteValide ( carte ) ) {
            reponse = carte / 13;
        }
        return reponse;
    }
    
    /**
     * Retourne un nombre entre 1 et 13 inclusivement correspondant a la valeur de la carte :
     * 1 : as, 2 : 2, 3 : 3, ..., 10 : 10, 11 : valet, 12 : dame, 13 : roi
     * @param carte un nombre entre 0 et 51 inc.
     * @return 1, 2, ..., 13 si la carte est valide, -1 sinon
     */
    public static int valeur ( int carte ) {
        int reponse = -1;
        if ( carteValide ( carte ) ) {
            reponse = carte % 13 + 1;
        }
        return reponse;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Retourne un nombre aleatoire uniformement distribue entre a et b inclusivement.
     * antecedent : a <= b (les nombres generes ne seront plus uniformes sinon)
     * @param a valeur minimale
     * @param b valeur maximale
     */
    private static int alea ( int a, int b ) {
        return (int) Math.floor ( ( b - a + 1 ) * generateur.nextDouble () ) + a;
    } // alea
    

    private static Random generateur = new Random ( 0 ) ;  // generateur de nombres aleatoires.  Doit etre cree (avec initialiserJeuDeCartes par exemple.)
    
    private static final int NOMBRE_CARTES = 52;
    
    private static int nombreCartesPigees = 0;
    
    private static int[] paquet;
    
    /**
     * Met les cartes en ordre dans le paquet.
     */
    private static void initialiserPaquet () {
        for ( int i = 0; i < NOMBRE_CARTES; i++ ) {
            paquet [ i ] = i;
        }
    }
    
    static {
        paquet = new int [ NOMBRE_CARTES ];
        PaquetDeCartes.initialiserPaquet();
    }
} // PaquetDeCartes
