package personnages;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;


	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forcePositive();
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";

	}

//	public void recevoirCoup(int forceCoup) {
//		assert (force>0);
//		int forceAvant = force;
//		force -= forceCoup;
//		assert (forceAvant<force);
//		assert forcePositive();
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
	 // if (force > 0) {
	 // 	parler("Aïe");
	 // } else {
	 // 	equipementEjecte = ejecterEquipement();
	 // 	parler("J'abandonne...");
	 // }
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");

		}
//		switch (force) {
//		case 0:
//			parler("Aïe");
//			break;
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	public int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + getNom() + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	


	private boolean forcePositive() {
		boolean forcePositive = false;
		if (force >= 0) {
			forcePositive = true;
		} 
		return forcePositive;

	}


	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

	private String leSoldat() {
		return "Le soldat " + getNom();
	}

	private void ajouterEquipement(Equipement equipement) {
		if (nbEquipement <= 2) {
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println(leSoldat() + " s'Ã©quipe avec un " + equipement + ".");
		}

	}

	private void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println(leSoldat() + " est dÃ©jÃ bien protÃ©gÃ© !");
			break;
		case 1:
			if (equipement != equipements[0]) {
				ajouterEquipement(equipement);
			} else {
				System.out.println(leSoldat() + " possÃ¨de dÃ©jÃ un " + equipement + ".");
			}
			break;
		default:
			ajouterEquipement(equipement);
			break;
		}
	}


	public static void main(String[] args) {
		Romain marcus = new Romain("Marcus", 9);
		marcus.parler("Hii");
		marcus.recevoirCoup(3);
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(3);
//		System.out.println(Equipement.CASQUE);
//		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

}
