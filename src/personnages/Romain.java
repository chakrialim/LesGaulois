package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	
	public void recevoirCoup(int forceCoup) {
		forceToujoursPositive();
		int forceAvant = force;
		force -= forceCoup;
		forceBienDiminue(forceAvant,force);
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
	}
	
	private boolean forceDiminue(int forceAvant, int forceApres) {
		if (forceAvant > forceApres) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean forceBienDiminue(int forceAvant, int forceApres) {
		assert forceDiminue(forceAvant, forceApres);
		return true;
	}
	private boolean forcePositive() {
		if (force >= 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean forceToujoursPositive() {
		assert forcePositive();
		return true;
	}
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Romain marcus = new Romain("Marcus",9);
		marcus.parler("Hii");
		marcus.recevoirCoup(3);
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(3);
		

	}

	
}


