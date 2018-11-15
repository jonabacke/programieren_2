package Aufgabe_3_Flughafen;

public class Flugzeug extends Thread {
	
	private Status status;
	private int flugZeit;	// Sollflugzeit
	private int startZeit;	// Zeitpunkt des Starts
	private int reiseZeit;	// Bisherige Reisezeit 
	
	private final String flugNr;
	private static int nr = 0;
	private Flughafen zielFlughafen;
	private static final int LANDE_ZEIT = 1500; 

	/**
	 * 
	 * @param flughafen Der Flughafen, von dem das Flugzeug agiert.
	 * @param startZeit	Die Startzeit fr das Flugzeug (Gemessen an der Simulations Zeit)
	 */
	public Flugzeug(Flughafen flughafen, int startZeit) 
	{
		if (flughafen == null || startZeit < 0) 
		{
			throw new IllegalArgumentException();
		}
		this.startZeit = startZeit;
		this.zielFlughafen = flughafen;
		flugNr = "Flugnummer: " + Flugzeug.nr++;
		status = Status.IM_FLUG;
		flugZeit = (int) ((Math.random() * 5000) + 3000);
		
	}

	@Override
	public void run() 
	{
		getReisezeit();
		
		
		System.err.println("Willkommen an Bord von " + flugNr + ". Die Maschine ist pünktlich um " + startZeit + " abgehoben.\n "
				 + "Die voraussichtliche Flugdauer beträgt " + flugZeit + " Sekunden.");
		
		while (!this.isInterrupted()) 
		{
			
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{				
				this.interrupt();
			}
			getReisezeit();
			switch (status) 
			{
			case IM_FLUG:
				if (reiseZeit - startZeit >= flugZeit) {
					if (zielFlughafen.landebahnFrei(this)) 
					{
						status = Status.IM_LANDEANFLUG;
						startZeit = reiseZeit;
						flugZeit = LANDE_ZEIT;
						System.err.println(flugNr + " hat sein Ziel erreicht und beginnt jetzt mit dem Landeanflug.");
					}
				}

				break;
			case IM_LANDEANFLUG:
					if(reiseZeit - startZeit >= flugZeit) 
					{
						status = Status.GELANDET;	
						zielFlughafen.gelandet(this);
						System.err.println(flugNr + " ist um "+ reiseZeit + " gelandet.");
					}
				break;
			case GELANDET:
				
				break;
				
			}
			
		}
		
		System.err.println(flugNr + " ist wieder gelandet.");

	}

	
	public void getReisezeit()
	{
		reiseZeit = (int)System.currentTimeMillis();
	}
	
/**
 * Abfrage der Flugnummer 
 * @return	Die Flugnummer
 */
	public String getFlugnummer() 
	{
		return flugNr;
	}

}
