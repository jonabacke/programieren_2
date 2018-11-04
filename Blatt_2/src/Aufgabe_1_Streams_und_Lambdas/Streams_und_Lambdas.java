package Aufgabe_1_Streams_und_Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Streams_und_Lambdas {
	
	List<String> _items;
	List<String> _itemsFertig;

	public static void main(String[] args) {
		String [] mehrWorte = {"adas","dsfköüäösdbj f",null, "sdßfjhbjsdh bfjkh", " idkushgfui"};
		Streams_und_Lambdas stream = new Streams_und_Lambdas();
		System.out.println(stream.streamManipulating(mehrWorte));

	}
	
	public List<String> streamManipulating(String [] mehrWorte) {
		_items = new ArrayList<String>();
		_itemsFertig = new ArrayList<String>();
		
		for (int i = 0; i < mehrWorte.length; i++) {
			if (mehrWorte[i] != null) {
				_items.addAll(Arrays.asList(mehrWorte[i].trim().split(" ")));
			}
		}
		_items.forEach(str -> {
			str = str.replaceAll("ä", "ae");
			str = str.replaceAll("ü", "ue");
			str = str.replaceAll("ö", "oe");
			str = str.replaceAll("ß", "ss");
			str = str.toUpperCase();
			str = str.toUpperCase();
			str = str.trim();
			if (str.length() > 8) {
				str = str.substring(0, 8);
			}
			_itemsFertig.add(str);
		});
		return _itemsFertig;
	}

}
