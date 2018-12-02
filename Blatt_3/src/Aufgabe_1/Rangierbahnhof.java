package Aufgabe_1;

public class Rangierbahnhof {
	
	Zug  [] _gleis;
	
	public Rangierbahnhof(int anzahlGleise) {
		_gleis = new Zug[anzahlGleise];
		System.out.println(_gleis.length + " Gleise");
	}
	
	public synchronized boolean zugEinfahren(Zug zug, int gleisnummer) 
	{
		if (gleisnummer < 0 || gleisnummer > _gleis.length) 
		{
			System.err.println("Gleis " + gleisnummer + " nicht vorhanden");
			return false;
		}
		else if (_gleis[gleisnummer] != null) {
			while (_gleis[gleisnummer] != null) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return false;
				}
			}
			_gleis[gleisnummer] = zug;
			return true;
		}
		else
		{
			System.out.println("Zug auf Gleis " + gleisnummer + " eingefahren.");
			_gleis[gleisnummer] = zug;
			return true;
		}
	}
	
	public synchronized boolean  zugAusfahren(int gleisnummer) {
		if (_gleis[gleisnummer] == null) {
			System.err.println("Gleis " + gleisnummer + " nicht belegt");
			return false;
		}
		else {
			System.out.println("Zug von Gleis " + gleisnummer + " ausgefahren.");
			_gleis[gleisnummer] = null;			
			return true;
		}
	}

}