import static org.junit.Assert.*;

import org.junit.Test;

public class JeuDeLaVieTest {
	@Test
	public void lesCellulesSontMortesParDefaut() {
		assertTrue(new Cellule().isMorte());
	}

	@Test
	public void uneCellulePeutEtreVivante() {
		Cellule cellule = new Cellule();
		cellule.devientVivante();
		assertFalse(cellule.isMorte());
	}

	@Test
	public void lesCellulesSontPlacees() {
		Plateau plateau = new Plateau();

		assertSame(plateau.getXY(0, 0), plateau.getXY(0, 0));
	}

	@Test
	public void lesCellulesDeCoordonneesDifferentesSontDifferentes() {
		Plateau plateau = new Plateau();

		assertNotSame(plateau.getXY(0, 0), plateau.getXY(1, 1));
	}

	@Test
	public void les4VoisinsSontMortsParDefaut() throws Exception {
		Plateau plateau = new Plateau();

		assertEquals(4, plateau.compteVoisinsMorts(0, 0));
	}

	@Test
	public void unVoisinPeutEtreVivant() throws Exception {
		Plateau plateau = new Plateau();
		plateau.getXY(1, 0).devientVivante();
		assertEquals(3, plateau.compteVoisinsMorts(0, 0));
	}

	@Test
	public void unAutreVoisinPeutEtreVivant() throws Exception {
		Plateau plateau = new Plateau();
		plateau.getXY(0, 1).devientVivante();
		assertEquals(3, plateau.compteVoisinsMorts(0, 0));
	}

	@Test
	public void unVoisinDUneAutreCellulePeutEtreVivant() throws Exception {
		Plateau plateau = new Plateau();
		plateau.getXY(11, 10).devientVivante();
		assertEquals(3, plateau.compteVoisinsMorts(10, 10));
	}
}
