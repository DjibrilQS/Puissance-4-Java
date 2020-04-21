import java.util.Scanner;

//Code suffisement simple pour être réalisé en 1 seule classe
//Jeu jouable dans la console

public class Puissance4 {
	
	public static void Jeu(String J1, String J2) {
		// DEBUT DU PROGRAMME
		Scanner scanner = new Scanner(System.in);
		// Le plateau vertical de jeu:
		// alignement requis :
		int nbJetons = 4;
		// colonnes et lignes :
		int nbColonnes = 7;
		int nbLignes = 6;
		// tableau du plateau ('.' = emplacement vide / 'X' = joueur 1 / 'O' = joueur 2)
		char[][] plateau = new char[nbColonnes][nbLignes];
		// remplissage des cases avec du vide, oui c'est paradoxal !
		for (int x = 0; x < nbColonnes; x++)
			for (int y = 0; y < nbLignes; y++)
				plateau[x][y] = '.';

		int gagnant = 0;

		// boucle de jeu, s'arrête en cas de victoire de J1 ou J2 ou si le plateau est
		// plein avec égalité
		for (int i = 1; i <= nbColonnes * nbLignes; i++) {

			
			affichage(nbColonnes, nbLignes, plateau, i);
			// affichage du plateau:
/*				System.out.println("Tour " + i + ", Etat du plateau :");

			for (int loop = 0; loop < 23; loop++)
				System.out.print('-');
			System.out.println();

			for (int y = 0; y < nbLignes; y++) {
				System.out.print('|');
				for (int x = 0; x < nbColonnes; x++) {
					System.out.print(" " + plateau[x][y] + " ");
				}
				System.out.print('|');
				System.out.println();
			}

			for (int loop = 0; loop < 23; loop++)
				System.out.print('-');
			System.out.println();
*/
			// Placements du jeton:
			System.out.println("Tour du joueur " + (i % 2 == 1 ? J1 : J2));
			int colonne = verifPlacement(nbColonnes, plateau);
/*
			System.out.println("Entrez le numéro de la colonne entre 1 et " + nbColonnes + " ...");
			boolean placement = false;

			int colonne = -1;
			
			
			while (!placement) {
				colonne = -1;
				int ligne = scanner.nextInt();
				// vérification que la ligne est un entier entre 1 et C:

				colonne = ligne;

				if (colonne >= 1 && colonne <= nbColonnes) {
					if (plateau[colonne - 1][0] != '.') {
						System.out.println("Colonne pleine, réitérez");
					} else {
						placement = true;
					}
				} else {
					System.out.println("Nombre incorrect, réitérez");
				}

			}
*/
			// placement du jeton:
			// Détection de victoire:
			int rang = nbLignes - 1;
			while (plateau[colonne - 1][rang] != '.') {
				rang--;
			}
			plateau[colonne - 1][rang] = (i % 2 == 1 ? '1' : '2');

						// symbole en cours:
						char symbole = (i % 2 == 1 ? '1' : '2');
						// nombre alignés maximal:
						int max = 0;
						int x;
						int y;
						int somme;
						x = colonne - 1;
						y = rang;
						somme = -1;
			gagnant = verifsVictoire2.lancement(colonne, plateau, nbLignes, nbColonnes, nbJetons, i, gagnant, x, y, rang, somme, symbole, max);
					if (gagnant == 1 || gagnant == 2)
						i = nbLignes*nbColonnes +1;
					
/*			
			int rang = nbLignes - 1;
			while (plateau[colonne - 1][rang] != '.') {
				rang--;
			}
			plateau[colonne - 1][rang] = (i % 2 == 1 ? '1' : '2');

			// Détection de victoire:

			// symbole en cours:
			char symbole = (i % 2 == 1 ? '1' : '2');
			// nombre alignés maximal:
			int max = 0;
			int x;
			int y;
			int somme;

			// --> diagonale HG-BD
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && x >= 0 && plateau[x][y] == symbole) {
				y--;
				x--;
				somme++;
			}
			x = colonne - 1;
			y = rang;
			while (y < nbLignes && x < nbColonnes && plateau[x][y] == symbole) {
				y++;
				x++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> diagonale HD-BG
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && x < nbColonnes && plateau[x][y] == symbole) {
				y--;
				x++;
				somme++;
			}
			x = colonne - 1;
			y = rang;
			while (y < nbLignes && x >= 0 && plateau[x][y] == symbole) {
				y++;
				x--;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> verticale:
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && plateau[x][y] == symbole) {
				y--;
				somme++;
			}
			y = rang;
			while (y < nbLignes && plateau[x][y] == symbole) {
				y++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> horizontale:
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (x >= 0 && plateau[x][y] == symbole) {
				x--;
				somme++;
			}
			x = colonne - 1;
			while (x < nbColonnes && plateau[x][y] == symbole) {
				x++;
				somme++;
			}
			if (somme > max)
				max = somme;

			if (max >= nbJetons) {
				gagnant = (i % 2 == 1 ? 1 : 2);
				i = nbColonnes * nbLignes + 1;
			}
*/
			System.out.println("********************************");
		}

		// affichage des résultats:
		// si gagnant == 0 c'est que tout le plateau s'est remplis sans gagnant, il y a
		// donc égalité
		for (int loop = 0; loop < 23; loop++)
			System.out.print('-');
		System.out.println();

		for (int y = 0; y < nbLignes; y++) {
			System.out.print('|');
			for (int x = 0; x < nbColonnes; x++) {
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}

		for (int loop = 0; loop <23; loop++)
			System.out.print('-');
		System.out.println();
		System.out.println("****FIN DE PARTIE****");
		if (gagnant == 0)
			System.out.println("*******EGALITE*******");
		if (gagnant == 1)
			System.out.println("****VICTOIRE DE " + J1 + "****");
		if (gagnant == 2)
			System.out.println("****VICTOIRE DE " + J2 + "****");
		rejouer(J1, J2);
	}


public static void affichage (int nbColonnes, int nbLignes, char [][] plateau, int i) {
	

		// affichage du plateau:
		System.out.println("Tour " + i + ", Etat du plateau :");

		for (int loop = 0; loop < 23; loop++)
			System.out.print('-');
		System.out.println();

		for (int y = 0; y < nbLignes; y++) {
			System.out.print('|');
			for (int x = 0; x < nbColonnes; x++) {
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}

		for (int loop = 0; loop < 23; loop++)
			System.out.print('-');
		System.out.println();
	}


public static int verifPlacement (int nbColonnes, char [][] plateau ) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Entrez le numéro de la colonne entre 1 et " + nbColonnes + " ...");
	int colonne = -1;
	boolean placement = false;
	while (!placement) {
		colonne = -1;
		int ligne = scanner.nextInt();
		// vérification que la ligne est un entier entre 1 et C:

		colonne = ligne;

		if (colonne >= 1 && colonne <= nbColonnes) {
			if (plateau[colonne - 1][0] != '.') {
				System.out.println("Colonne pleine, réitérez");
			} else {
				placement = true;
			}
		} else {
			System.out.println("Nombre incorrect, réitérez");
		}

	}
return colonne;
}
	
public static void rejouer(String J1, String J2) {
	Scanner saisie = new Scanner(System.in);
	System.out.println("Voulez vous rejouer ? (1 = oui et le reste = non)");
	int choix2 = saisie.nextInt();
	if (choix2 == 1) {
		Jeu(J1, J2);
	} else {
		System.out.println("Adieu.");
	}
}
}
