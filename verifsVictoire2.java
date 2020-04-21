
public class verifsVictoire2 {
	public static void main(String[] args) {

	}
	public static int lancement (int colonne, char [][] plateau, int nbLignes, int nbColonnes, int nbJetons, int i, int gagnant, int x, int y, int rang, int somme, char symbole, int max) {


					// --> diagonale HG-BD
					
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
					return gagnant;
	}
}