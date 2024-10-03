package personnages;

public class Musee {
	private static final int MAX_TROPHEES = 200;
	private Trophee[] trophees = new Trophee[MAX_TROPHEES];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < MAX_TROPHEES) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee++;
		}
	}

	public StringBuilder extraireInstructionsOCaml() {
		StringBuilder texte = new StringBuilder();
		texte.append("let musee = [ \n");
		for (int i = 0; trophees[i] != null && i < trophees.length; i++) {
				Trophee trophee = trophees[i];
				String gaulois = trophee.donnerNom();
				Equipement equipement = trophee.getEquipement();
				if (trophees[i+1]== null) {
					texte.append("\t\"" + gaulois + "\", \"" + equipement + "\" \n");
				} else {
					texte.append("\t\"" + gaulois + "\", \"" + equipement + "\"; \n");
				}

		}
		texte.append("]");
		return texte;

	}

}
