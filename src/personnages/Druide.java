package personnages;

import java.util.Random;

public class Druide {
	private static final int forcePotionMoyenne = 7;
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random random = new Random();
	

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int preparerPotion() {
		forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (forcePotion > forcePotionMoyenne) {
			parler("J'ai préparé une super potion de force " + forcePotion);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
		return forcePotion;
	}

	public int booster(Gaulois gaulois) {
		int potion = preparerPotion();
		if (("Obélix").equals(gaulois.getNom())) {
			parler("Non, Obélix!... Tu n'auras pas de potion magique!");
		} else {
			gaulois.boirePotion(potion);
		}
		return potion;
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 8, 10);
		panoramix.preparerPotion();
	}

}
