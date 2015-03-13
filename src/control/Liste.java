package control;

/** Implémentation d'une liste */
public class Liste {

	/**
	 * classe interne qui représente les noeuds Est utilisé dans Liste
	 * 
	 * @see Liste
	 */
	public class Element {
		public int val; // la valeur
		public Element next;
		public Element before;

		
		/**
		 * constructeur vide on initialise val = une valeur negative arbitraire
		 * next = before = null
		 */
		protected Element() {
			val = -9999;
			next = null;
			before = null;
		}
		

		/**
		 * constructeur de l'element
		 * 
		 * @param val
		 *            la valeur de l'element à créer
		 * @param next
		 *            l'element suivant dans la liste
		 * @param before
		 *            l'element precedent dans la liste
		 */
		protected Element(int val, Element next, Element before) {
			this.val = val;
			this.next = next;
			this.before = before;
		}
	}

	
	public Element e;
	/** premier element de la liste */
	public int n;

	/** nombre d'element dans la liste */

	/** constructeur vide pour Liste */
	public Liste() {
		this.e = null;
		this.n = 0;
	}

	
	/**
	 * constructeur
	 * 
	 * Crée un element dans la liste
	 * 
	 * @param val
	 *            valeur assignée a l'element créé
	 */
	public Liste(int val) {
		this.e = new Element(val, null, null);
		this.n++;
	}

	
	/**
	 * ajout d'un element en tete de la liste
	 * 
	 * @param x
	 *            l'element qui est ajouté
	 */
	public void add(int x) {
		Element newElement = new Element(x, this.e, null);
		if (e != null)
			e.before = newElement;
		e = newElement;
		this.n++; // on met a jour le nombre d'element dans la liste

	}


	/**
	 * test si la liste est vide
	 * 
	 * @return vrai si vide, faux sinon
	 */
	public Boolean empty() {
		return (e == null);
	}

	
	/**
	 * 
	 * @return longueur de la liste
	 */
	public int length() {
		return this.n;
	}

	
	/**
	 * test si un entier est present dans la liste
	 * @param x l'objet dont on veut savoir si il est dans la liste
	 * @return vrai si x est dans la liste, faux sinon
	 */
	public Boolean contain(int x)
	{
		Element e2 = this.e;
		while(e2!=null)
		{
			if (e2.val==x)
				return true;
			e2 = e2.next;
		}
		return false;
	}
	
	
	/** representation textuelle de la liste */
	public String toString() {
		String l = "DebutListe -> ";
		Element e2 = this.e;
		while (e2!=null) {
			l += e2.val;
			l += " -> ";
			e2 = e2.next;
		}
		l += "FinListe";
		return l;
	}

	public void affiche(){
		System.out.println(toString());
	}
	
	
	/**
	 * transforme une liste en un tableau contenant les elements de la liste
	 * 
	 * @return null si la liste est vide, un tableau contenant les element de la liste sinon
	 */
	public int[] toArray()
	{
		int[] array;
		if (n>0)
			array = new int[n];
		else
			array=null;
		
		Element e = this.e;
		
		for(int i=0;i<n;i++)
		{
			array[i] = e.val;
		    e = e.next;
		}	
		return array;
	}
}