package personnages;
import personnages.Chef;

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

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois<nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
		
	}
	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	public void afficherVillageois(Village village) {
		System.out.println("Dans "+village.getnom()+" du chef "+village.getchef()+ " vivent les légendaires gaulois: " + villageois);
		
		for (int i = 0; i < nbVillageois; i++) {
			if (villageois[i]!= null) {
				System.out.println("-"+villageois[i]);
			}
		}

		}
		
	
	
	

	private String getchef() {
		return chef.getNom();
	}

	private String getnom() {
		return nom;
	}


	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30)
//		Exception car liste va de 0 à 29 donc out of bounds
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		resultat obtenu est null car asterix est trié à l'indice 0 du tableau et non pas 1
		
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(asterix);
		village.afficherVillageois(village);
	}
	
	
	
	

}
