package test.control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import control.Liste;

public class ListeTest {
	
	public Liste listeVide;
	public Liste listeUnElement;
	 @Before
	   public void setUp() throws Exception {
		 listeVide = new Liste();
		 listeUnElement = new Liste(0);
	   }

	@Test
	public void testConstructeurVide() {
		assertTrue(listeVide.e==null);
	}

	@Test
	public void testConstructeurInt() {
		assertTrue(listeUnElement.e!=null);
		assertTrue(listeUnElement.e.val==0);
	}

	@Test
	public void testAdd() {
		listeUnElement.add(1);
		assertTrue(listeUnElement.e.val==1);
		assertTrue(listeUnElement.length()==2);
		assertEquals(null,listeUnElement.e.before); //l'element qu'on a ajouter est le premier
		assertEquals(0,listeUnElement.e.next.val); //l'element suivant est celui qui etait present avant, 0
		
		listeVide.add(3);
		assertTrue(listeVide.e.val==3);
		assertTrue(listeVide.length()==1);
	}

	@Test
	public void testEmpty() {
		assertTrue(listeVide.empty());
		assertFalse(listeUnElement.empty());
	}

	@Test
	public void testLength() {
		assertTrue(listeVide.n==0);
		assertTrue(listeUnElement.n==1);
	}
	
	@Test
	public void testContain() {
		assertTrue(!listeVide.contain(0));
		assertTrue(listeUnElement.contain(0));
	}
	
	@Test
	public void testToString(){
		String l1 = "DebutListe -> FinListe";
		assertEquals(l1,listeVide.toString());
		
		String l2 = "DebutListe -> 0 -> FinListe";
		assertEquals(l2,listeUnElement.toString());
	}
	
	@Test
	public void testToArray(){
		assertTrue(listeVide.toArray()==null);
		
		assertTrue(listeUnElement.toArray()[0]==0);
		
		listeUnElement.add(1);
		assertTrue(listeUnElement.toArray()[0]==1);
	}
	
}
