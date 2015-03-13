package main;

import control.Graphe;
import model.Dicos;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] dico3court = {
			       "gag", "gai", "gaz", "gel", "gks", "gin",
			       "gnu", "glu", "gui", "guy", "gre", "gue",
			       "ace", "acm", "agi", "ait", "aie", "ail",
			       "air", "and", "alu", "ami", "arc", "are",
			       "art", "apr", "avr", "sur", "mat", "mur" } ;
		Graphe g = new Graphe (dico3court) ;
		
		//Dicos d = new Dicos();
		//Graphe g4 = new Graphe(d.dico4);
		
		Graphe.lettreQuiSaute(g);
		Graphe.visit(g);
		Graphe.chemin(g, "gag", "gin");
		//Graphe.lettreQuiSaute(g4);
		//Graphe.visit(g4);
		
		
	}

}
