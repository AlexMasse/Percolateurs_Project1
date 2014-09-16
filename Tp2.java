/**
 * I N F 1 1 2 0
 *
 * Ce programme permet de miser sur des paris aux cartes.
 * 
 */
 
public class Tp2 {

    /**
     * Affiche la carte selon sa couleur et sa valeur
     * @param carte doit etre entre 0 et 51 inclusivement
     */
    public static void afficherCarte (int carte) {
        // Déclaration des variables locales
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
     * Détermine si les deux cartes ont la même valeur (ex.: deux rois, deux 9)
     * @param carte1 et carte2 doivent être entre 0 et 51 inclusivement
     */
    public static boolean memeValeur (int carte1,int carte2) {
        // Déclaration des variables locales
        boolean memeValeur;
        int valeur1 = PaquetDeCartes.valeur(carte1);
        int valeur2 = PaquetDeCartes.valeur(carte2);
        
        // Vérification des valeurs des cartes
        if (valeur1 == valeur2) {
            memeValeur = true;
        } else {
            memeValeur = false;
        }
        return memeValeur;
    } // memeValeur
    
    /**
     * Détermine si les deux cartes ont la même couleur.
     * Les 4 couleurs possibles sont : coeur, carreau, trèfle et pique.
     * @param carte1 et carte2 doivent être entre 0 et 51 inclusivement
     * @return true si les deux cartes ont la même couleur, false sinon
     */
    public static boolean memeCouleur (int carte1,int carte2) {
        // Déclaration des variables locales
        boolean memeCouleur;
        int couleur1 = PaquetDeCartes.couleur(carte1);
        int couleur2 = PaquetDeCartes.couleur(carte2);
        
        // Vérification des couleurs des cartes
        if (couleur1 == couleur2) {
            memeCouleur = true;
        } else {
            memeCouleur = false;
        }
        return memeCouleur;
    } // memeCouleur
    
    /**
     * Détermine si une carte est une figure : As, roi, dame, valet.
     * @param carte doit être entre 0 et 51 inclusivement
     * @return true si la carte est une figure, false sinon
     */
    public static boolean estUneFigure (int carte) {
        // Déclaration des variables locales
        boolean estUneFigure;
        int valeur = (carte % 13);
        
        // Vérification de la valeur des cartes
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
     * Un même entier germe générera les mêmes cartes.
     */
    public static void initialiserLeJeu () {
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
    public static int entreeArgent () {
        // Déclaration de la variable locale
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
     * Demande à l'utilisateur s'il désire jouer une partie.
     * @return true si l'utilisateur veut jouer, false sinon
     */
    public static boolean jouerPartie () {
        // Déclaration des variables locales
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
     * Demande à l'utilisateur combien de cartes il désire piger.
     * Si il a moins de 6$, l'ordinateur pige 2 cartes pour lui.
     * @param argent doit être un entier
     * @return 2 ou 3 cartes
     */
    public static int nombreDeCartes (int argent) {
        // Déclaration de la variable locale
        int nombreDeCartes;
        
        // Décision du nombre de cartes selon le montant d'argent
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
     * Affiche les différents choix de paris et demande a l'utilisateur
     * sur lequel il désire miser.
     * @return 1, 2, 3, 4 ou 5, dépendamment de ce que l'utilisateur a choisi.
     */
    public static int numeroDePari () {
        // Déclaration de la variable locale
        int numeroDePari;
        
        // Affichage des choix de paris
        System.out.println ("Quel pari voulez-vous faire ?");
        System.out.println (" 1 : au moins une figure");
        System.out.println (" 2 : toutes < 5");
        System.out.println (" 3 : somme paire");
        System.out.println (" 4 : meme couleur");
        System.out.println (" 5 : meme valeur");
        
        // Décision de l'utilisateur
        System.out.println ("Votre choix =>");
        numeroDePari = Clavier.lireInt();
        
        // Boucle de validation
        while (numeroDePari < 1 || numeroDePari > 5) {
            System.out.print ("*** vous devez choisir un numero entre 1 et 5 :");
            numeroDePari = Clavier.lireInt();
        }
        return numeroDePari;
    } // numeroDePari
    
     /**
     * Vérifie si, selon le numéro de pari et les cartes pigées,
     * l'utilisateur gagne son pari.
     * @param choixPari doit etre un numero entre 1 et 5
     * @param carte1 et carte2 doivent etre entre 0 et 51
     * @param carte3 doit être entre égal à 51 ou moins
     * @return true si l'utilisateur gagne son pari, false sinon
     */
    public static boolean gagnePari (int choixPari, int carte1, int carte2, int carte3) {
        // Déclaration des variables locales
        boolean pariCarte1 = false;
        boolean pariCarte2 = false;
        boolean pariCarte3 = false;
        boolean gagnePari = false;
        boolean troisCartes = false;
        int valeurCarte1 = PaquetDeCartes.valeur(carte1);
        int valeurCarte2 = PaquetDeCartes.valeur(carte2);
        int valeurCarte3 = 0;
        
        // Vérifie si l'utilisateur a pigé 3 cartes
        if (carte3 > -1) {
            troisCartes = true;
            valeurCarte3 = PaquetDeCartes.valeur(carte3);
        }
        
        // Vérification selon le numéro de pari
        switch (choixPari) {
            case 1: // Pari 1
            
                // Vérifie si les cartes sont des figures
                pariCarte1 = estUneFigure(carte1);
                pariCarte2 = estUneFigure(carte2);
                if (troisCartes) { // L'utilisateur a trois cartes
                    pariCarte3 = estUneFigure(carte3);
                }
                
                // Vérifie si au moins une carte respecte la condition
                if (pariCarte1 == true || pariCarte2 == true || pariCarte3 == true) {
                    gagnePari = true;
                }
                break;
            case 2: // Pari 2
                
                // VÈrifie si chaque carte est infÈrieure ‡ 5
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
                
                // VÈrification de la condition
                if (troisCartes) { // L'utilisateur a trois cartes
                    // VÈrifie si les trois cartes respectent la condition
                    if (pariCarte1 == true && pariCarte2 == true && pariCarte3 == true) {
                        gagnePari = true;
                    } 
                } else { // L'utilisateur a deux cartes
                    // Vérifie si les deux cartes pigées respectent la condition
                    if (pariCarte1 == true && pariCarte2 == true) {
                        gagnePari = true;
                    }
                }
                break;
            case 3: // Pari 3
                if (troisCartes) { // L'utilisateur a trois cartes
                    // Vérification de l'addition des valeurs
                    if ((valeurCarte1 + valeurCarte2 + valeurCarte3) % 2 == 0) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // Vérification de l'addition des valeurs
                    if ((valeurCarte1 + valeurCarte2) % 2 == 0) {
                        gagnePari = true;
                    }
                }
                break;
            case 4: // Pari 4
                if (troisCartes) { // L'utilisateur a trois cartes
                    // Vérification des conditions
                    if (memeCouleur(carte1,carte2) && memeCouleur(carte1,carte2)) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // VÈrification de la condition
                    if (memeCouleur(carte1,carte2)) {
                        gagnePari = true;
                    }
                }
                break;
            case 5: // Pari 5
                if (troisCartes) { // L'utilisateur a trois cartes
                    // VÈrification des conditions
                    if (memeValeur(carte1,carte2) && memeValeur(carte1,carte2)) {
                        gagnePari = true;
                    }
                } else { // L'utilisateur a deux cartes
                    // Vérification de la condition
                    if (memeValeur(carte1,carte2)) {
                        gagnePari = true;
                    }
                }
                break;
        } // switch (choixPari)
        return gagnePari;
    } // gagnePari
    
     /**
     * Donne le montant d'argent gagné par l'utilisateur selon son pari.
     * @param nombreDeCartes doit être 2 ou 3
     * @param numeroDePari doit être entre 1 et 5
     * @return gain le montant gagné par l'utilisateur
     */
    public static int argentGagne (int nombreDeCartes, int numeroDePari) {
        // Déclaration de la variable locale
        int gain = 0;
        
        // Décision du gain en argent selon le numéro du pari
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
        } // switch (numeroDePari)
        return gain;
    } // argentGagne
        
    
            
    public static void main (String[] params) {
        // Déclaration des variables
        int argent = 0;
        int nombreDeCartes = 0;
        boolean jouerPartie;
        int carte1 = 0;
        int carte2 = 0;
        int carte3 = 0;
        int numeroDePari = 0;
        boolean gagnePari;
        String gagne = "Bravo ! Vous avez gagne ";
        String perdu = "Desole ! Vous avez perdu !";

        initialiserLeJeu(); // Initialisation de l'ordre des cartes
        
        // Saisie des variables nécessaires à l'exécution du jeu
        argent = entreeArgent(); // Entrée du montant d'argent de l'utilisateur
        jouerPartie = jouerPartie(); // Est-ce l'utilisateur veut jouer?
        
        // Boucle principale
        while (jouerPartie == true && argent >= 4) {
            // Saisie des variables nécessaires pour un pari
            carte3 = -1; // Puisqu'on ne sait pas le nombre de cartes
            nombreDeCartes = nombreDeCartes(argent); // Nombre de cartes jouées
            argent = argent - (2 * nombreDeCartes); // Achat des cartes à 2$ par carte
            numeroDePari = numeroDePari(); // Pari en jeu
            
            // Affectation et affichage des cartes
            carte1 = PaquetDeCartes.piger();
            carte2 = PaquetDeCartes.piger();
            System.out.println ("Voici les cartes pigees:");
            afficherCarte(carte1);
            afficherCarte(carte2);
            if (nombreDeCartes == 3) {
                carte3 = PaquetDeCartes.piger();                 
                afficherCarte(carte3);
            }
            
            // Vérification si l'utilisateur gagne et ajout du gain
            gagnePari = gagnePari(numeroDePari,carte1,carte2,carte3);
            if (gagnePari) { // L'utilisateur a gagné son pari
                argent = argent + argentGagne(nombreDeCartes,numeroDePari);
                System.out.print (gagne);
                System.out.print (argentGagne(nombreDeCartes,numeroDePari));
                System.out.println (" $");
            } else { // L'utilisateur a perdu son pari
                System.out.println (perdu);
            }
            
            // Fin du pari
            System.out.println ("Vous disposez maintenant de " + argent + " $");
            
            // Vérification si l'utilisateur peut/veut continuer à jouer
            if (argent < 4) {
                System.out.println ("Vous n'avez plus assez d'argent, vous ne pouvez continuer.");
            } else {
                jouerPartie = jouerPartie();
            }
        } // while (Boucle principale)
        
        // Messages de fin de programme
        System.out.println ("Merci d'avoir joue avec moi !");
        System.out.println ("Vous quittez avec " + argent + " $ en poche.");
    } // main
    
} // Tp2
