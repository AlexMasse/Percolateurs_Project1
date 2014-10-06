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
        if (valeur1 == valeur2) {
            memeValeur = true;
        } else {
            memeValeur = false;
        }
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
        if (couleur1 == couleur2) {
            memeCouleur = true;
        } else {
            memeCouleur = false;
        }
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
        if (valeur == 0) {
            estUneFigure = true;
        } else if (valeur > 9 && valeur < 13) {
            estUneFigure = true;
        } else {
            estUneFigure = false;
        }
        return estUneFigure;
    } // estUneFigure
    
     /**
     * Permet a l'utilisateur d'initialiser le jeu de carte.
     * Un m�me entier germe g�n�rera les m�mes cartes.
     */
    protected void initialiserLeJeu () {
        int germe;
        System.out.println ( "Entrez un nombre entier pour initialiser le jeu : " );
        germe = Clavier.lireInt ();
        PaquetDeCartes.initialiserJeuDeCarte ( germe );
        PaquetDeCartes.brasser();
    } // initialiserLeJeu
    
     /**
     * Demande a l'utilisateur le montant d'argent qu'il a en sa possession.
     * Le programme le redemande tant que ce n'est pas superieur ou egal a 4.
     * @return un entier dont la valeur correspond au montant (en $).
     */
    protected int entreeArgent () {
        // D�claration de la variable locale
        int argent;
        
        // Message d'invite
        System.out.println ("Entrez le montant dont vous disposez : ");
        argent = Clavier.lireInt();
        while (argent < 4) { // Boucle de validation
            System.out.println ("*** Le montant doit etre superieur ou egal a 4 : ");
            argent = Clavier.lireInt();
        }
        return argent;
    } // entreeArgent


     /**
     * Demande � l'utilisateur s'il d�sire jouer une partie.
     * @return true si l'utilisateur veut jouer, false sinon
     */
    protected boolean jouerPartie () {
        // D�claration des variables locales
        String invite = "Voulez-vous jouer une partie ? ";
        String reponse;
        boolean jouerUnePartie = false;
        
        // Message d'invite
        System.out.println (invite);
        reponse = Clavier.lireString();
        
        //Boucle de validation
        while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
            System.out.println ("*** vous devez repondre par oui ou non :");
            reponse = Clavier.lireString();
        }
        
        if (reponse.equalsIgnoreCase("oui")) {
            jouerUnePartie = true;
        }
        return jouerUnePartie;
    } // jouerPartie
    
     /**
     * Demande � l'utilisateur combien de cartes il d�sire piger.
     * Si il a moins de 6$, l'ordinateur pige 2 cartes pour lui.
     * @param argent doit �tre un entier
     * @return 2 ou 3 cartes
     */
    protected int nombreDeCartes (int argent) {
        // D�claration de la variable locale
        int nombreDeCartes;
        
        // D�cision du nombre de cartes selon le montant d'argent
        if (argent < 6) {
            System.out.println ("Je vais piger deux cartes.");
            nombreDeCartes = 2;
        } else {
            System.out.println ("Combien de cartes voulez-vous piger (2 ou 3) ?");
            nombreDeCartes = Clavier.lireInt();
            
            // Boucle de validation
            while (nombreDeCartes != 2 && nombreDeCartes != 3) {
                System.out.println ("*** Le nombre de cartes doit etre 2 ou 3");
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
        
        // Affichage des choix de paris
        System.out.println ("Quel pari voulez-vous faire ?");
        System.out.println (" 1 : au moins une figure");
        System.out.println (" 2 : toutes < 5");
        System.out.println (" 3 : somme paire");
        System.out.println (" 4 : meme couleur");
        System.out.println (" 5 : meme valeur");
        System.out.println (" 6 : toutes des figures");
        
        // D�cision de l'utilisateur
        System.out.println ("Votre choix =>");
        numeroDePari = Clavier.lireInt();
        
        // Boucle de validation
        while (numeroDePari < 1 || numeroDePari > 6) {
            System.out.print ("*** vous devez choisir un numero entre 1 et 6 :");
            numeroDePari = Clavier.lireInt();
        }
        return numeroDePari;
    } // numeroDePari
    
     /**
     * V�rifie si, selon le num�ro de pari et les cartes pig�es,
     * l'utilisateur gagne son pari.
     * @param choixPari doit etre un numero entre 1 et 6
     * @param carte1 et carte2 doivent etre entre 0 et 51
     * @param carte3 doit �tre entre �gal � 51 ou moins
     * @return true si l'utilisateur gagne son pari, false sinon
     */
    protected boolean gagnePari (int choixPari, int carte1, int carte2, int carte3) {
        // D�claration des variables locales
        boolean pariCarte1 = false;
        boolean pariCarte2 = false;
        boolean pariCarte3 = false;
        boolean gagnePari = false;
        boolean troisCartes = false;
        int valeurCarte1 = PaquetDeCartes.valeur(carte1);
        int valeurCarte2 = PaquetDeCartes.valeur(carte2);
        int valeurCarte3 = 0;
        
        // V�rifie si l'utilisateur a pig� 3 cartes
        if (carte3 > -1) {
            troisCartes = true;
            valeurCarte3 = PaquetDeCartes.valeur(carte3);
        }
        
        // V�rification selon le num�ro de pari
        switch (choixPari) {
            case 1: // Pari 1
            
                // V�rifie si les cartes sont des figures
                pariCarte1 = estUneFigure(carte1);
                pariCarte2 = estUneFigure(carte2);
                if (troisCartes) { // L'utilisateur a trois cartes
                    pariCarte3 = estUneFigure(carte3);
                }
                
                // V�rifie si au moins une carte respecte la condition
                if (pariCarte1 == true || pariCarte2 == true || pariCarte3 == true) {
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
                    if (pariCarte1 == true && pariCarte2 == true && pariCarte3 == true) {
                        gagnePari = true;
                    } 
                } else { // L'utilisateur a deux cartes
                    // V�rifie si les deux cartes pig�es respectent la condition
                    if (pariCarte1 == true && pariCarte2 == true) {
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
                    if (memeCouleur(carte1,carte2) && memeCouleur(carte1,carte2)) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // V�rification de la condition
                    if (memeCouleur(carte1,carte2)) {
                        gagnePari = true;
                    }
                }
                break;
            case 5: // Pari 5
                if (troisCartes) { // L'utilisateur a trois cartes
                    // V�rification des conditions
                    if (memeValeur(carte1,carte2) && memeValeur(carte1,carte2)) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // V�rification de la condition
                    if (memeValeur(carte1,carte2)) {
                        gagnePari = true;
                    }
                }
                break;
            case 6: // Pari 6
                gagnePari = estUneFigure(carte1) && estUneFigure(carte2);
                if (troisCartes) {
                    gagnePari = gagnePari && estUneFigure(carte3);
                }
                break;
            default: break;
        } // switch (choixPari)

        return gagnePari;
    } // gagnePari
    
     /**
     * Donne le montant d'argent gagn� par l'utilisateur selon son pari.
     * @param nombreDeCartes doit �tre 2 ou 3
     * @param numeroDePari doit �tre entre 1 et 5
     * @return gain le montant gagn� par l'utilisateur
     */
    protected int argentGagne (int nombreDeCartes, int numeroDePari) {
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
                gain = (2 * (int)(Math.pow(nombreDeCartes - 1,3))) + 2;
                break;
            case 6: // Pari 6
                gain = 5 * nombreDeCartes;
                break;
            default: break;
        } // switch (numeroDePari)
        return gain;
    } // argentGagne

} // Tp2
