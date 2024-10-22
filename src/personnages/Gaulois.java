package personnages;

public class Gaulois {
	private static final int MAX_EQUIPEMENTS = 100;
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees = 0;
	Equipement[] trophees = new Equipement[MAX_EQUIPEMENTS];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : "; 
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesAStocker = romain.recevoirCoup((force / 3) * effetPotion);
		if (tropheesAStocker != null) {
			for (int i = 0; i < tropheesAStocker.length && tropheesAStocker[i] != null; i++) {
				if (nbTrophees < tropheesAStocker.length) {
					trophees[nbTrophees] = tropheesAStocker[i];
					nbTrophees++;
				} else {
					break;
				}
			}

		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");

	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			StringBuilder texte = new StringBuilder();
			texte.append("Je donne au musee tous mes trophees: ");
			for (int i = 0; i < trophees.length; i++) {
				if (trophees[i] != null) {
					texte.append("\n- " + trophees[i]);
					musee.donnerTrophees(this, trophees[i]);
				}

			}
			parler(texte);
		} else {
			System.out.println("Je n'ai rien a donner\n");
		}

	}

	private void parler(StringBuilder texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		// asterix.prendreParole();
		asterix.parler("HA");

		Romain caesar = new Romain("Caesar", 10);
		System.out.println(caesar);
		asterix.frapper(caesar);
		asterix.boirePotion(5);

	} 

}
