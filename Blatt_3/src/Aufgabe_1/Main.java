package Aufgabe_1;

public class Main {

	public static void main(String[] args) {
		Thread simulation = new Thread(new Simulation());
		simulation.start();
	}

}
