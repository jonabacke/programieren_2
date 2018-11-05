/**
 * 
 */
package Aufgabe_3;

/**
 * @author Backes
 *
 */
public class ArrayListe<T extends Comparable<T>> implements Comparable<T>{
	
	private int _anzahlTe;
	
	private T[] _element;
	
	private int _pointer;
	
	@SuppressWarnings("unchecked")
	public ArrayListe() {
		_element = (T[]) new Comparable[10];
		_pointer = 0;
	}
	
	public void	hinzufuegen(T ele) {
		for (int i = 0; i < this._element.length; i++) {
			if (this._element[i] == null) {
				this._element[i] = ele;
				this._anzahlTe ++;
				break;
			}
			if (i == this._element.length && !(this._element[i] == null)) {
				this.vergroessereArrayList();
				this._element[i+1] = ele;
				this._anzahlTe ++;
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private <E> void vergroessereArrayList() {
		T[] _element2 = (T[]) new Comparable[_anzahlTe*2];
		_element2 = _element.clone();
		_element = _element2;
	}
	
	public T get(int number) {
		return this._element[number];
	}
	
	public void entferne(T ele) {
		for (int i = 0; i < this._element.length; i++) {
			if (this._element[i] == ele) {
				this._element[i] = null;
				this._anzahlTe --;
				break;
			}
		}
	}
	
	public void entferneTAnIndex(int index) {
		this._element[index] = null;
		this._anzahlTe --;
	}
	
	public int getAnzahlTe() {
		return this._anzahlTe;
	}
	
	public String toString() {
		String outputString = "";
		for (int i = 0; i < this._element.length; i++) {
			if (!(this._element[i] == null)) {
				outputString += this._element[i].toString();
				outputString += ", ";
			}
		}
		return outputString;
	}
	
	public T getKleinstesT() {
		T ele;
		for (int i = 0; i < _element.length && _element[i] != null; i++) {
			ele = _element[i];
			if (compareTo(ele) > 0) {
				this._pointer = i;
			}
		}
		ele = _element[_pointer];
		_pointer = 0;
		return ele;
	}


	@Override
	public int compareTo(T ele) {
        return  _element[_pointer].compareTo(ele);
	}
}
