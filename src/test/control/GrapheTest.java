package test.control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import control.Graphe;

public class GrapheTest {
	
	public Graphe g;
	
	String[] dico3trescourt = {
		       "gag", "gai", "gaz", "gel", "gks", "gin"
		       } ;
	
	@Before
	public void setUp() throws Exception {
		g = new Graphe(dico3trescourt);
		Graphe.lettreQuiSaute(g);
	}

	@Test
	public void testInitDejaVu() {
		for(int i=0;i<g.dejaVu.length;i++)
			assertFalse(g.dejaVu[i]);   
		//on regarde que deja vu est bien initialisé a False
		//dans toutes les cases du tableau
	}

	@Test
	public void testAjouterArete() {
		Graphe.ajouterArete(g,1,3);
		
		assertTrue(g.listeSucc[1].contain(3));
		assertTrue(g.listeSucc[3].contain(1));
		
		
	}

	@Test
	public void testDiffUneLettre() {
		assertTrue(Graphe.diffUneLettre("ata", "aha"));
		assertFalse(Graphe.diffUneLettre("aha", "haa"));
		
	}

	@Test
	public void testLettreQuiSaute() {
	
		assertTrue(g.listeSucc[0].contain(1));
		assertTrue(g.listeSucc[0].contain(2));
		assertFalse(g.listeSucc[0].contain(3));
		assertFalse(g.listeSucc[0].contain(4));
		assertFalse(g.listeSucc[0].contain(5));
		
		assertTrue(g.listeSucc[1].contain(0));
		assertTrue(g.listeSucc[1].contain(2));
		assertFalse(g.listeSucc[1].contain(3));
		assertFalse(g.listeSucc[1].contain(4));
		assertFalse(g.listeSucc[1].contain(5));
		
		assertTrue(g.listeSucc[2].contain(0));
		assertTrue(g.listeSucc[2].contain(1));
		assertFalse(g.listeSucc[2].contain(3));
		assertFalse(g.listeSucc[2].contain(4));
		assertFalse(g.listeSucc[2].contain(5));
		
		assertFalse(g.listeSucc[3].contain(0));
		assertFalse(g.listeSucc[3].contain(1));
		assertFalse(g.listeSucc[3].contain(2));
		assertFalse(g.listeSucc[3].contain(4));
		assertFalse(g.listeSucc[3].contain(5));
		
		assertFalse(g.listeSucc[4].contain(0));
		assertFalse(g.listeSucc[4].contain(1));
		assertFalse(g.listeSucc[4].contain(2));
		assertFalse(g.listeSucc[4].contain(3));
		assertFalse(g.listeSucc[4].contain(5));
		
		assertFalse(g.listeSucc[5].contain(0));
		assertFalse(g.listeSucc[5].contain(1));
		assertFalse(g.listeSucc[5].contain(2));
		assertFalse(g.listeSucc[5].contain(3));
		assertFalse(g.listeSucc[5].contain(4));
		
	}



}
