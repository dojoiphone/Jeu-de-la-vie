
public class Cellule {

	private boolean vivante;

	public boolean isMorte() {
		return ! vivante;
	}

	public void devientVivante() {
		vivante = true;
	}

}
