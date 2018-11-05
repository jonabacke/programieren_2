package Aufgabe_3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListe<Integer> list = new ArrayListe<Integer>();
		list.hinzufuegen(6);
		list.hinzufuegen(4);
		list.hinzufuegen(8);
		list.hinzufuegen(1);
		list.hinzufuegen(2);
		list.hinzufuegen(46);
		System.out.println(list.getKleinstesT());
		System.out.println(list.get(2));
		System.out.println(list.getAnzahlTe());
		list.entferneTAnIndex(5);
		list.hinzufuegen(79);
		System.out.println(list.get(5));
		System.out.println(list.toString());
	}

}
