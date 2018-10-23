/**
 * 
 */
package Aufgabe_3;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Backes
 *
 */
class test {
	
	ArrayListe<Integer> _list;
	
	public test() {
		_list = new ArrayListe<Integer>();
	}
	@Test
	public void testeHinzufuegen() {
		assertEquals(0, _list.getAnzahlTe());
		_list.hinzufügen(6);
		assertEquals(1, _list.getAnzahlTe());
		_list.hinzufügen(4);
		assertEquals(2, _list.getAnzahlTe());
		_list.hinzufügen(8);
		assertEquals(3, _list.getAnzahlTe());
		_list.hinzufügen(1);
		assertEquals(4, _list.getAnzahlTe());
		_list.hinzufügen(2);
		assertEquals(5, _list.getAnzahlTe());
		_list.hinzufügen(46);
		assertEquals(6, _list.getAnzahlTe());
	}
	@Test
	public void testeEntfernen() {
		_list.hinzufügen(6);
		_list.hinzufügen(4);
		_list.hinzufügen(8);
		_list.hinzufügen(1);
		_list.hinzufügen(2);
		_list.hinzufügen(46);
		assertEquals(6, _list.getAnzahlTe());
		_list.entferneTAnIndex(3);
		assertEquals(5, _list.getAnzahlTe());
		_list.entferne(8);
		assertEquals(4, _list.getAnzahlTe());
		assertEquals(null, _list.get(3));
	}
	@Test
	public void kleinstesElement() {
		_list.hinzufügen(6);
		_list.hinzufügen(4);
		_list.hinzufügen(8);
		_list.hinzufügen(1);
		_list.hinzufügen(2);
		_list.hinzufügen(46);
		assertEquals(1, (int)_list.getKleinstesT());
	}

}
