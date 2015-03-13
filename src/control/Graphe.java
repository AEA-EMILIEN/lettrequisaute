package control;


/** 
 * */
public class Graphe {
	
	
	public int nb; //nombre d'element dans le tableau mot
	public String[] mot; //tableau des mots de départ
	public Liste[] listeSucc; //tableau de liste d'entier
	public Boolean[] dejaVu; 
	public int[] pere;
	
	public Graphe(String[] lesMots)
	{
		this.nb=lesMots.length;
		this.mot=lesMots;
		this.listeSucc = new Liste[nb];
		initListeSucc();
		this.dejaVu = new Boolean[nb];
		initDejaVu();
		this.pere = new int[nb];
		initPere();
		
	}
	
	/**
	 * on crée toutes les listes vides dans le tableau des successeurs.
	 */
	public void initListeSucc()
	{
		for(int i=0;i<this.nb;i++)
			this.listeSucc[i] = new Liste(); 
	}
	
	
	public void initDejaVu()
	{
		for(int i=0;i<this.nb;i++)
			dejaVu[i] = false; 
	}
	
	public void initPere()
	{
		for(int i=0;i<this.nb;i++)
			pere[i]=-1;
	}
	
	/**
	 * rajoute s à la liste des successeurs de d et d à celle de s,
	 * les mots d'indices s et d étant supposés différer d'une lettre
	 * @param g le graphe dans lequel on met a jour les successeurs
	 * @param s un mot d'indice s, qu'on va rajouter aux successeurs de d
	 * @param d un mot d'indice d, qu'on va rajouter aux successeurs de s
	 * */
	public static void ajouterArete (Graphe g, int s, int d)
	{
		if (!g.listeSucc[s].contain(d))
			g.listeSucc[s].add(d);
		
		if (!g.listeSucc[d].contain(s))
			g.listeSucc[d].add(s);
	}

	/**
	 * methode donné par le sujet
	 * 
	 * renvoie vraie quand deux chaînes de même longueur diffèrent d'une lettre
	 * 
	 * @param a  chaine de caractere a comparer
	 * @param b  chaine de caractere a comparer
	 * @return  renvoie vraie quand deux chaînes de même longueur diffèrent d'une lettre
	 * 
	 * on suppose que a et b sont de tailles égales.
	 */
	public static boolean diffUneLettre (String a, String b) {
	    // a et b supposees de meme longueur
	    int i=0 ;
	    while (i<a.length () && a.charAt (i) == b.charAt (i))
	      ++i ;
	    if (i == a.length ()) return false ;
	    ++i ;
	    while (i<a.length () && a.charAt (i) == b.charAt (i))
	      ++i ;
	    if (i == a.length ()) return true ;
	    return false ;
	  }
	
	
	
	/** 
	 * initialisation de listeSucc en fonction des regles du jeu de la lettre qui saute
	 * (cf. le sujet de tp)
	 * @param g le graphe a initialiser
	 */
	public static void lettreQuiSaute (Graphe g)
	{
		for(int i=0;i<g.nb;i++)
		{
			for(int j=i+1;j<g.nb;j++)
			{
				if (diffUneLettre(g.mot[i],g.mot[j]))
				{
					ajouterArete(g, i, j);	
				}
			}
		}
	}
	
	/**
	 * parcours de graphe en profondeur a partir du mot d'indice x
	 *  
	 * */
	public static void DFS(Graphe g, int x)
	{
		if(!g.dejaVu[x]) //si on est pas deja passé par ce mot
		{
			g.dejaVu[x]=true; //on lajoute dans le tableau des mots deja vus
			System.out.print(" "+g.mot[x]+" ");
			
			if(!g.listeSucc[x].empty())
			{
				int[] tmp = g.listeSucc[x].toArray();
				for(int i=0;i<tmp.length;i++)
				{	
					if (g.pere[tmp[i]] == -1 && !g.dejaVu[tmp[i]])
						g.pere[tmp[i]] = x; //on met a jour la relation pere-fils  
					Graphe.DFS(g,tmp[i]); //et on rappelle la fonction sur ses successeurs
				}
			}
			
				
		}
			
	}
	
	/**
	 * parcours de graphe en profondeur a partir du mot d'indice x
	 * même fonction que DFS mais sans le print
	 * */
	public static void DFS_noprint(Graphe g, int x)
	{
		if(!g.dejaVu[x]) //si on est pas deja passé par ce mot
		{
			g.dejaVu[x]=true; //on lajoute dans le tableau des mots deja vus
			
			if(!g.listeSucc[x].empty())
			{
				int[] tmp = g.listeSucc[x].toArray();
				for(int i=0;i<tmp.length;i++)
				{	
					if (g.pere[tmp[i]] == -1 && !g.dejaVu[tmp[i]])
						g.pere[tmp[i]] = x; //on met a jour la relation pere-fils  
					Graphe.DFS_noprint(g,tmp[i]); //et on rappelle la fonction sur ses successeurs
				}
			}
			
				
		}
			
	}
	/**
	 * effectue un parcours en profondeur du graphe et affiche les 
	 * composantes connexes de celui-ci
	 * @param g
	 */
	public static void visit(Graphe g)
	{
		int cmpt_connexe=0; //compteur des composantes connexes
		
		g.initDejaVu(); 
		g.initPere();   
		
		for(int i=0;i<g.nb;i++)
		{	
			if(!g.dejaVu[i])
			{
				cmpt_connexe++;
				
				System.out.print(cmpt_connexe+": ");
				Graphe.DFS(g, i);
				System.out.println("");
			}
		}
	}
	
	
	/**
	 * cherche si m est dans tabmots
	 * 
	 * @param m la String a chercher
	 * @param tabMots le tableau dans lequel chercher
	 * @return l'indice du tableau si le mot est trouvé, throw une erreur sinon
	 */
	public static int indice (String m, String[] tabMots) {
	    for (int i=0 ; i<tabMots.length ; ++i)
	        if (m.equals (tabMots[i])) return i ;
	    throw new Error (m + " n'est pas dans le tableau.") ;
	  }
	
	
	/**
	 * affiche un chemin de from vers to si il existe
	 * @param g le graphe dans lequel on veut chercher un chemin
	 * @param from le mot de depart
	 * @param to le mot darrivé du chemin
	 * 
	 *  renvoi une exception si from ou to ne sont pas des mots du graphes
	 *  renvoi une exception si aucun chemin n'est trouvé
	 * 
	 */
	public static void chemin (Graphe g, String from, String to)
	{
		int indiceFrom = Graphe.indice(from,g.mot );
		int indiceTo =   Graphe.indice(to,g.mot);
		int indiceCourant = indiceTo;
		String m = g.mot[indiceCourant];
		
		//Graphe.DFS_noprint(g, indiceFrom);
		while(indiceFrom!=indiceTo && g.pere[indiceCourant]!=-1)
		{			
			System.out.println(g.mot[indiceCourant]+ " "+g.mot[g.pere[indiceCourant]]+ " "+ g.mot[indiceFrom]);
			indiceCourant = g.pere[indiceCourant];
			m +=  "->" + g.mot[indiceCourant];
		}
		if(indiceCourant==indiceFrom)
		{
			System.out.println(m);
			return;
		}
		else
			throw new Error ("pas de chemin entre " + from + " et " + to);
		
	}
	
	/**
	 * override du toString
	 */
	public String toString()
	{
		String res = "";
		int[] x;
		
		for(int i=0;i<nb;i++)
		{
			res += i + "  " +mot[i]+":";
			x = listeSucc[i].toArray();
			
			if (x!=null) //liste contenant des elements
			{
				for(int j=0;j<x.length;j++)
				{
					res += mot[x[j]]+",";
				}
			}
			
			res += "_\n";
			
		}
		
		return res;
	}
	
	public static void affiche(Graphe g)
	{
		System.out.println(g.toString());
	}
}
