package solution1;


public class Tondeuse {
	Position p;
	Orientation orientation;


	public Tondeuse(Position p, Orientation orientation) {
		this.p = p;
		this.orientation = orientation;
	}



	public String tondre(int pelouseX, int pelouseY, String deplacements) {
		Position posResultat = p;
		Orientation orienResultat = orientation;
		for(int i = 0; i < deplacements.length(); i++) {
			switch (deplacements.charAt(i)) {
			case 'D':
				orienResultat = deplacementDroit(orienResultat);
				break;
			case 'G':
				orienResultat = deplacementGauche(orienResultat);
				break;
			case 'A':
				avancer(pelouseX, pelouseY, posResultat, orienResultat);
				break;

			default:
				break;
			}
		}
		return posResultat.getX() + " "+posResultat.getY() + " "+orienResultat.name();

	}



	private void avancer(int pelouseX, int pelouseY, Position posResultat, Orientation orienResultat) {
		if("N".equals(orienResultat.name())){
			if(posResultat.getY() < pelouseY) {
				posResultat.setY(posResultat.getY() + 1);
			}
		}
		else if("E".equals(orienResultat.name())){
			if(posResultat.getX() < pelouseX) {
				posResultat.setX(posResultat.getX() + 1);
			}
		}
		else if("S".equals(orienResultat.name())){
			if(posResultat.getY() > 0 ) {
				posResultat.setY(posResultat.getY() - 1);
			}
		}
		else if("W".equals(orienResultat.name())){
			if(posResultat.getX() > 0 ) {
				posResultat.setX(posResultat.getX() - 1 );
			}
		}
	}



	private Orientation deplacementGauche(Orientation orienResultat) {
		if("N".equals(orienResultat.name())){
			orienResultat = Orientation.W;
		}
		else if("E".equals(orienResultat.name())){
			orienResultat = Orientation.N;
		}
		else if("S".equals(orienResultat.name())){
			orienResultat = Orientation.E;
		}
		else if("W".equals(orienResultat.name())){
			orienResultat = Orientation.S;
		}
		return orienResultat;
	}



	private Orientation deplacementDroit(Orientation orienResultat) {
		if("N".equals(orienResultat.name())){
			orienResultat = Orientation.E;
		}
		else if("E".equals(orienResultat.name())){
			orienResultat = Orientation.S;
		}
		else if("S".equals(orienResultat.name())){
			orienResultat = Orientation.W;
		}
		else if("W".equals(orienResultat.name())){
			orienResultat = Orientation.N;
		}
		return orienResultat;
	}

}
