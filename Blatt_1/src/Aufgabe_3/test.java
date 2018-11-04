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
		_list.hinzuf�gen(6);
		assertEquals(1, _list.getAnzahlTe());
		_list.hinzuf�gen(4);
		assertEquals(2, _list.getAnzahlTe());
		_list.hinzuf�gen(8);
		assertEquals(3, _list.getAnzahlTe());
		_list.hinzuf�gen(1);
		assertEquals(4, _list.getAnzahlTe());
		_list.hinzuf�gen(2);
		assertEquals(5, _list.getAnzahlTe());
		_list.hinzuf�gen(46);
		assertEquals(6, _list.getAnzahlTe());
	}
	@Test
	public void testeEntfernen() {
		_list.hinzuf�gen(6);
		_list.hinzuf�gen(4);
		_list.hinzuf�gen(8);
		_list.hinzuf�gen(1);
		_list.hinzuf�gen(2);
		_list.hinzuf�gen(46);
		assertEquals(6, _list.getAnzahlTe());
		_list.entferneTAnIndex(3);
		assertEquals(5, _list.getAnzahlTe());
		_list.entferne(8);
		assertEquals(4, _list.getAnzahlTe());
		assertEquals(null, _list.get(3));
	}
	@Test
	public void kleinstesElement() {
		_list.hinzuf�gen(6);
		_list.hinzuf�gen(4);
		_list.hinzuf�gen(8);
		_list.hinzuf�gen(1);
		_list.hinzuf�gen(2);
		_list.hinzuf�gen(46);
		assertEquals(1, (int)_list.getKleinstesT());
	}

}
