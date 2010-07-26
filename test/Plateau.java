import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	private Map<Coordonnees, Cellule> cellulesMap = new HashMap<Plateau.Coordonnees, Cellule>();

	public Cellule getXY(int x, int y) {
		Coordonnees coordonnees = new Coordonnees(x, y);
		if (cellulesMap.get(coordonnees) == null) {
			cellulesMap.put(coordonnees, new Cellule());
		}
		return cellulesMap.get(coordonnees);
	}

	private static class Coordonnees {
		int x;
		int y;

		public Coordonnees(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordonnees other = (Coordonnees) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	private Collection<Cellule> getVoisins(int x, int y) {
		Collection<Cellule> collection = new ArrayList<Cellule>();
		collection.add(getXY(1, 0));
		collection.add(getXY(11, 10));
		collection.add(getXY(0, 1));
		collection.add(new Cellule());
		return collection;
	}

	public int compteVoisinsMorts(int x, int y) {
		int cellulesMortes = 0;
		for (Cellule cellule : getVoisins(x, y)) {
			if (cellule.isMorte())
				cellulesMortes++;
		}
		return cellulesMortes;
	}
}
