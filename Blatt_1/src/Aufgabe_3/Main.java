package Aufgabe_3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListe<Integer> list = new ArrayListe<Integer>();
		list.hinzuf�gen(6);
		list.hinzuf�gen(4);
		list.hinzuf�gen(8);
		list.hinzuf�gen(1);
		list.hinzuf�gen(2);
		list.hinzuf�gen(46);
		System.out.println(list.getKleinstesT());
		System.out.println(list.get(2));
		System.out.println(list.getAnzahlTe());
		list.entferneTAnIndex(5);
		list.hinzuf�gen(79);
		System.out.println(list.get(5));
		System.out.println(list.toString());
	}

}
