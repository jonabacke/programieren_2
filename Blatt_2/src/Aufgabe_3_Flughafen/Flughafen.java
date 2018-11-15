package Aufgabe_3_Flughafen;





import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;






public class Flughafen extends Thread
{

	private List<Flugzeug> flugzeuge;
	private int flugZeit;
	private int anfangsZeit;
	
	private boolean landebahnReserviert;
	
		
	/**
	 * Ein Flughafen, der Starts und Landungen koordiniert.
	 * @param flugzeugZahl  Die startenden und landenden Flüge.
	 */
	public Flughafen(int flugzeugZahl) 
	{
		getAnfangsZeit();
		flugzeuge = new ArrayList<Flugzeug>();	
		for(int i = 0; i<flugzeugZahl; i++) 
		{
			flugzeuge.add(new Flugzeug(this, anfangsZeit));			
		}
		landebahnReserviert = false;
		flugZeit = 0;
	}
	
	
	public static void main(String[] args) 
	{
		Flughafen flughafen = new Flughafen(4);
		flughafen.start();
	}

	
	
	@Override
	public void run() 
	{
		
		Iterator<Flugzeug> it = flugzeuge.iterator();
		while(it.hasNext()) 
		{
			it.next().start();
		}
		
		while(!Thread.interrupted() && !flugzeuge.isEmpty()) 
		{
			
			try 
			{
				Thread.sleep(500);
				flugZeit = flugZeit + 500;
			} 
			catch (InterruptedException e) 
			{			
				this.interrupt();
				return;
			}
		}
		
		System.err.println("Alle Flugzeuge sind wieder gelandet." );
		
	}

	/**
	 * Ein Flugzeug möchte landen.
	 * @param Flugzeug, das landen möchte.
	 * @return true, wenn Landebahn reserviert ist.
	 */
	public synchronized boolean landebahnFrei(Flugzeug flugzeug) 
	{	
		System.err.println(flugzeug.getFlugnummer() + " reserviert Landebahn");
		landebahnReserviert = true;
		return true;
	}		


	/**
	 * Das Flugzeug ist gelandet und kann entfernt werden.
	 * @param flugzeug , das gelandet ist.
	 */
	public synchronized void gelandet(Flugzeug flugzeug) 
	{
		landebahnReserviert = false;
		flugzeug.interrupt();
		flugzeuge.remove(flugzeug);		
		getAnfangsZeit();
		Flugzeug neuesFlugzeug = new Flugzeug(this, anfangsZeit);
		neuesFlugzeug.start();
		flugzeuge.add(neuesFlugzeug);
		
		
	}

	
	public void getAnfangsZeit()
	{
		anfangsZeit = (int)System.currentTimeMillis();
	}
	
}
