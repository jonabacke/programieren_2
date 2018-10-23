/**
 * 
 */
package Aufgabe_3;

/**
 * @author Backes
 *
 */
public class ArrayListe<T extends Comparable<T>> implements Comparable<T>{
	
	private int anzahlTe;
	
	private T[] element;
	
	private int pointer;
	
	public ArrayListe() {
		element =  (T[]) new Object[10];
		pointer = 0;
	}
	
	public void	hinzufügen(T ele) {
		for (int i = 0; i < this.element.length; i++) {
			if (this.element[i].equals(null)) {
				this.element[i] = ele;
				this.anzahlTe ++;
				break;
			}
			if (i == this.element.length && !this.element[i].equals(null)) {
				this.vergroessereArrayList();
				this.element[i+1] = ele;
				this.anzahlTe ++;
				break;
			}
		}
	}
	
	private <E> void vergroessereArrayList() {
		T[] element2 = (T[]) new Object[this.anzahlTe*2];
		element2 = element.clone();
		element = element2;
	}
	
	public T get(int number) {
		return this.element[number];
	}
	
	public void entferne(T ele) {
		for (int i = 0; i < this.element.length; i++) {
			if (this.element[i].equals(ele)) {
				this.element[i] = null;
				this.anzahlTe --;
				break;
			}
		}
	}
	
	public void entferneTAnIndex(int index) {
		this.element[index] = null;
		this.anzahlTe --;
	}
	
	public int getAnzahlTe() {
		return this.anzahlTe;
	}
	
	public String toString() {
		String outputString = "";
		for (int i = 0; i < this.element.length; i++) {
			if (!this.element[i].equals(null)) {
				outputString += this.element[i].toString();
				outputString += "/n";
			}
		}
		return outputString;
	}
	
	public T getKleinstesT() {
		T ele = element[0];
		for (int i = 0; i < element.length; i++) {
			if (compareTo(ele) < 0) {
				this.pointer = i;
			}
		}
		ele = element[pointer];
		pointer = 0;
		return ele;
	}


	@Override
	public int compareTo(T ele) {
        return  element[pointer].compareTo(ele);
	}
}
