package Aufgabe_1;

public class Simulation implements Runnable {
	
	Rangierbahnhof _bahnhof;
	
	public void run() {
		_bahnhof = new Rangierbahnhof(10);
		
		while (true) {
			Thread lockführer = new Thread(new Lockführer(_bahnhof));
			lockführer.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
