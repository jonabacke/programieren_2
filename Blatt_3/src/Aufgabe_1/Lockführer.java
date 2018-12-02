package Aufgabe_1;

public class Lockführer implements Runnable{
	
	Rangierbahnhof _bahnhof;
	
	public Lockführer(Rangierbahnhof bahnhof) {
		_bahnhof = bahnhof;
	}

	@Override
	public void run() {
		double choos = Math.random();
		int gleis = (int) (Math.random()*_bahnhof._gleis.length);
		if (choos < 0.5) {
			zugAusfahren(gleis);
		}
		else {
			Zug zug = new Zug();
			zugEinfahren(zug, gleis);
		}
	}
	
	private boolean zugAusfahren(int gleisnummer) {
		return _bahnhof.zugAusfahren(gleisnummer);
	}
	
	private boolean zugEinfahren(Zug zug, int gleisnummer) {
		return _bahnhof.zugEinfahren(zug, gleisnummer);
	}

}