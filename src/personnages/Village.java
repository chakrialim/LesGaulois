package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;

	public Village(String nom) {
		this.nom = nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public String getchef() {
		return chef.getNom();
	}

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}

	}

	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}

	public void afficherVillageois(Village village) {
		System.out.println(
				"Dans " + village.getNom() + " du chef " + village.getchef() + " vivent les l�gendaires gaulois: ");

		for (int i = 0; i <= nbVillageois; i++) {
			if (villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}

	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30)
//		Exception car les indices de la liste va de 0 � 29 donc out of bounds
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);

//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		resultat obtenu est null car asterix est tri� � l'indice 0 du tableau et non pas 1 qui n'a pas de gaulois

		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(village);

	}

}
