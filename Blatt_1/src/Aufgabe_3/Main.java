package Aufgabe_3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListe<Integer> list = new ArrayListe<Integer>();
		list.hinzufügen(6);
		list.hinzufügen(4);
		list.hinzufügen(8);
		list.hinzufügen(1);
		list.hinzufügen(2);
		list.hinzufügen(46);
		System.out.println(list.getKleinstesT());
		System.out.println(list.get(2));
		System.out.println(list.getAnzahlTe());
		list.entferneTAnIndex(5);
		list.hinzufügen(79);
		System.out.println(list.get(5));
		System.out.println(list.toString());
	}

}
