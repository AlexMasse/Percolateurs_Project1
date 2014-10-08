/**
 * I N F 1 1 2 0
 *
 * Ce programme permet de miser sur des paris aux cartes.
 * 
 */
 
public class ControleurJeuDePari {

   /* AMELIORATON APPORTEE : Les methodes ne sont plus public et static, mais plutot protected.
    * Cette classe est instanciee dans la methode "main" pour l'acces a ses methodes.
    */


    // AMELIORATION APPORTEE : constante qui remplacera le cout initial de 2.00 $ pour le pari a 2.5
    //cette variable permet de changer le cout a tout les endroits en une seule fois
    static final double COUT_PARI = 2.5;

    /**
     * Affiche la carte selon sa couleur et sa valeur
     * @param carte doit etre entre 0 et 51 inclusivement
     */
    protected void afficherCarte (int carte) {
        // D�claration des variables locales
        int valeur = PaquetDeCartes.valeur(carte);
        int couleur = PaquetDeCartes.couleur(carte);
        
        // Affichage de la valeur de la carte
        switch (valeur) {
            case 1:
                System.out.print ("as");
                break;
            case 11:
                System.out.print ("valet");
                break;
            case 12:
                System.out.print ("dame");
                break;
            case 13:
                System.out.print ("roi");
                break;
            default:
                System.out.print (valeur);
                break;
        } // switch (valeur)
        
        //Affichage de la couleur de la carte
        switch (couleur) {
            case 0:
                System.out.println (" coeur");
                break;
            case 1:
                System.out.println (" carreau");
                break;
            case 2:
                System.out.println (" trefle"); 
                break;
            case 3:
                System.out.println (" pique");  
                break;
        } // switch (couleur)
    } // afficherCarte
    
    /**
     * D�termine si les deux cartes ont la m�me valeur (ex.: deux rois, deux 9)
     * @param carte1 et carte2 doivent �tre entre 0 et 51 inclusivement
     */
    protected boolean memeValeur (int carte1,int carte2) {
        // D�claration des variables locales
        boolean memeValeur;
        int valeur1 = PaquetDeCartes.valeur(carte1);
        int valeur2 = PaquetDeCartes.valeur(carte2);
        
        // V�rification des valeurs des cartes
        // AMELIORATION APPORTEE : simplification de la verification de la condition
        memeValeur = valeur1 == valeur2;
        return memeValeur;
    } // memeValeur
    
    /**
     * D�termine si les deux cartes ont la m�me couleur.
     * Les 4 couleurs possibles sont : coeur, carreau, tr�fle et pique.
     * @param carte1 et carte2 doivent �tre entre 0 et 51 inclusivement
     * @return true si les deux cartes ont la m�me couleur, false sinon
     */
    protected boolean memeCouleur (int carte1,int carte2) {
        // D�claration des variables locales
        boolean memeCouleur;
        int couleur1 = PaquetDeCartes.couleur(carte1);
        int couleur2 = PaquetDeCartes.couleur(carte2);
        
        // V�rification des couleurs des cartes
        // AMELIORATION APPORTEE : simplification de la verification de la condition
        memeCouleur = couleur1 == couleur2;
        return memeCouleur;
    } // memeCouleur
    
    /**
     * D�termine si une carte est une figure : As, roi, dame, valet.
     * @param carte doit �tre entre 0 et 51 inclusivement
     * @return true si la carte est une figure, false sinon
     */
    protected boolean estUneFigure (int carte) {
        // D�claration des variables locales
        boolean estUneFigure;
        int valeur = (carte % 13);
        
        // V�rification de la valeur des cartes
        // AMELIORATION APPORTEE : simplification de la verification de la condition
        estUneFigure = valeur == 0 || valeur > 9 && valeur < 13;
        return estUneFigure;
    } // estUneFigure
    
     /**
     * Permet a l'utilisateur d'initialiser le jeu de carte.
     * Un m�me entier germe g�n�rera les m�mes cartes.
     */
    protected void initialiserLeJeu () {
        int germe;
        System.out.println ( MessagesTp2.MESS_INITIALISER );
        germe = Clavier.lireInt ();
        PaquetDeCartes.initialiserJeuDeCarte ( germe );
        PaquetDeCartes.brasser();
    } // initialiserLeJeu
    
     /**
     * Demande a l'utilisateur le montant d'argent qu'il a en sa possession.
     * Le programme le redemande tant que ce n'est pas superieur ou egal a 5.
     * @return un entier dont la valeur correspond au montant (en $).
     */
    protected double entreeArgent () {
        // D�claration de la variable locale
        double argent;
        
        // Message d'invite
        System.out.println (MessagesTp2.MESS_COMBIEN_MISE);
        argent = Clavier.lireDouble();
        while (argent < (COUT_PARI * 2)) { // Boucle de validation
            System.out.println (MessagesTp2.MESS_ERREUR_MONTANT_INITIAL);
            argent = Clavier.lireDouble();
        }
        return argent;
    } // entreeArgent


     /**
     * Demande � l'utilisateur s'il d�sire jouer une partie.
     * @return true si l'utilisateur veut jouer, false sinon
     */
    protected boolean jouerPartie () {
        // D�claration des variables locales
        // AMELIORATION APPORTEE : changer le mode d'affichage, on utilise maintenant la classe MessageTp2.java

        String reponse;
        boolean jouerUnePartie = false;
        
        // Message d'invite
        System.out.println (MessagesTp2.MESS_VEUT_JOUER);
        reponse = Clavier.lireString();
        
        //Boucle de validation
        while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non") && !reponse.equalsIgnoreCase("o") && !reponse.equalsIgnoreCase("n")) {
            System.out.println (MessagesTp2.MESS_ERREUR_OUI_NON);
            reponse = Clavier.lireString();
        }
        
        if (reponse.equalsIgnoreCase("oui") || reponse.equalsIgnoreCase("o")) {
            jouerUnePartie = true;
        }
        return jouerUnePartie;
    } // jouerPartie
    
     /**
     * Demande � l'utilisateur combien de cartes il d�sire piger.
     * Si il a moins que le cout de 3 piges, l'ordinateur pige 2 cartes pour lui.
     * @param argent doit �tre un entier
     * @return 2 ou 3 cartes
     */
    protected int nombreDeCartes (double argent) {
        // D�claration de la variable locale
        int nombreDeCartes;
        
        // D�cision du nombre de cartes selon le montant d'argent
        if (argent < (COUT_PARI * 3)) {
            System.out.println (MessagesTp2.MESS_PIGE_MINIMUM);
            nombreDeCartes = 2;
        } else {
            System.out.println (MessagesTp2.MESS_NBR_CARTES);
            nombreDeCartes = Clavier.lireInt();
            
            // Boucle de validation
            while (nombreDeCartes != 2 && nombreDeCartes != 3) {
                System.out.println (MessagesTp2.MESS_ERREUR_NBR_CARTE);
                nombreDeCartes = Clavier.lireInt();
            }
        }
        return nombreDeCartes;
    } // nombreDeCartes
    
     /**
     * Affiche les diff�rents choix de paris et demande a l'utilisateur
     * sur lequel il d�sire miser.
     * @return 1, 2, 3, 4 ou 5, d�pendamment de ce que l'utilisateur a choisi.
     */
    protected int numeroDePari () {
        // D�claration de la variable locale
        int numeroDePari;
        
        // Affichage du menu et choix de l'utilisateur

        System.out.print (MessagesTp2.MENU);
        numeroDePari = Clavier.lireInt();
        
        // Boucle de validation
        while (numeroDePari < 1 || numeroDePari > 6) {
            System.out.print (MessagesTp2.MESS_ERREUR_MENU);
            numeroDePari = Clavier.lireInt();
        }
        return numeroDePari;
    } // numeroDePari
    
     /**
     * V�rifie si, selon le num�ro de pari et les cartes pig�es,
     * l'utilisateur gagne son pari.
     * @param choixPari doit etre un numero entre 1 et 6
     * @param mainCartes tableau de 3 int, donc 3 cartes (0 à 51)
     * @return true si l'utilisateur gagne son pari, false sinon
     */
    protected boolean gagnePari (int choixPari, int mainCartes[]) {
        // D�claration des variables locales
        boolean pariCarte1 = false;
        boolean pariCarte2 = false;
        boolean pariCarte3 = false;
        boolean gagnePari = false;
        boolean troisCartes = false;
        int valeurCarte1 = PaquetDeCartes.valeur(mainCartes[0]);
        int valeurCarte2 = PaquetDeCartes.valeur(mainCartes[1]);
        int valeurCarte3 = 0;
        
        // V�rifie si l'utilisateur a pig� 3 cartes
        if (mainCartes[2] > -1) {
            troisCartes = true;
            valeurCarte3 = PaquetDeCartes.valeur(mainCartes[2]);
        }
        
        // V�rification selon le num�ro de pari
        switch (choixPari) {
            case 1: // Pari 1
            
                // V�rifie si les cartes sont des figures
                pariCarte1 = estUneFigure(mainCartes[0]);
                pariCarte2 = estUneFigure(mainCartes[1]);
                if (troisCartes) { // L'utilisateur a trois cartes
                    pariCarte3 = estUneFigure(mainCartes[2]);
                }
                
                // V�rifie si au moins une carte respecte la condition
                // AMELIORATION APPORTEE : simplification de la verification de la condition
                if (pariCarte1 || pariCarte2 || pariCarte3) {
                    gagnePari = true;
                }
                break;
            case 2: // Pari 2
                
                // V�rifie si chaque carte est inf�rieure � 5
                if (valeurCarte1 < 5) {
                    pariCarte1 = true;
                }
                if (valeurCarte2 < 5) {
                    pariCarte2 = true;
                }
                if (troisCartes) {
                    if (valeurCarte3 < 5) {
                        pariCarte3 = true;
                    }
                }
                
                // V�rification de la condition
                if (troisCartes) { // L'utilisateur a trois cartes
                    // V�rifie si les trois cartes respectent la condition
                    // AMELIORATION APPORTEE : simplification de la verification de la condition
                    if (pariCarte1 && pariCarte2 && pariCarte3) {
                        gagnePari = true;
                    } 
                } else { // L'utilisateur a deux cartes
                    // V�rifie si les deux cartes pig�es respectent la condition
                    // AMELIORATION APPORTEE : simplification de la verification de la condition
                    if (pariCarte1 && pariCarte2) {
                        gagnePari = true;
                    }
                }
                break;
            case 3: // Pari 3
                if (troisCartes) { // L'utilisateur a trois cartes
                    // V�rification de l'addition des valeurs
                    if ((valeurCarte1 + valeurCarte2 + valeurCarte3) % 2 == 0) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // V�rification de l'addition des valeurs
                    if ((valeurCarte1 + valeurCarte2) % 2 == 0) {
                        gagnePari = true;
                    }
                }
                break;
            case 4: // Pari 4
                if (troisCartes) { // L'utilisateur a trois cartes
                    // V�rification des conditions
                    if (memeCouleur(mainCartes[0],mainCartes[1]) && memeCouleur(mainCartes[0],mainCartes[2])) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // V�rification de la condition
                    if (memeCouleur(mainCartes[0],mainCartes[1])) {
                        gagnePari = true;
                    }
                }
                break;
            case 5: // Pari 5
                gagnePari = estUneFigure(mainCartes[0]) && estUneFigure(mainCartes[1]);
                if (troisCartes) {
                    gagnePari = gagnePari && estUneFigure(mainCartes[2]);
                }
                break;
            case 6: // Pari 6
                if (troisCartes) { // L'utilisateur a trois cartes
                    // V�rification des conditions
                    if (memeValeur(mainCartes[0],mainCartes[1]) && memeValeur(mainCartes[0],mainCartes[2])) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // V�rification de la condition
                    if (memeValeur(mainCartes[0],mainCartes[1])) {
                        gagnePari = true;
                    }
                }
                break;
            default: break;
        } // switch (choixPari)

        return gagnePari;
    } // gagnePari
    
     /**
     * Donne le montant d'argent gagn� par l'utilisateur selon son pari.
     * @param nombreDeCartes doit �tre 2 ou 3
     * @param numeroDePari doit �tre entre 1 et 6
     * @return gain le montant gagn� par l'utilisateur
     */
    protected double argentGagne (int nombreDeCartes, int numeroDePari) {
        // D�claration de la variable locale
        int gain = 0;
        
        // D�cision du gain en argent selon le num�ro du pari
        switch (numeroDePari) {
            case 1: // Pari 1
                gain = 17 - (2 * nombreDeCartes);
                break;
            case 2: // Pari 2
                gain = 4 * nombreDeCartes;
                break;
            case 3: // Pari 3
                gain = (2 * nombreDeCartes) + 2;
                break;
            case 4: // Pari 4
                gain = (3 * (int)(Math.pow(nombreDeCartes - 1,2))) + 2;
                break;
            case 5: // Pari 5
                gain = 5 * nombreDeCartes;
                break;
            case 6: // Pari 6
                gain = (2 * (int)(Math.pow(nombreDeCartes - 1,3))) + 2;
                break;
            default: break;
        } // switch (numeroDePari)
        return gain;
    } // argentGagne
    
} // Tp2
