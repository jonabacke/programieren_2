package Aufgabe_1_Streams_und_Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_und_Lambdas {
	
	List<String> _items;
	List<String> _itemsFertig;

	public static void main(String[] args) {
		String [] mehrWorte = {"adas","dsfk����sdbj f",null, "sd�fjhbjsdh bfjkh", " idkushgfui"};
		Streams_und_Lambdas stream = new Streams_und_Lambdas();
		System.out.println(stream.streamManipulating(mehrWorte).toString());
		System.out.println(stream.manipulating(mehrWorte).toString());

	}
	
	public List<String> streamManipulating(String[] mehrWorte) {
		List<String> wortListe = new ArrayList<String>();
		for (int i = 0; i < mehrWorte.length; i++) {
			if (mehrWorte[i] != null) {
				wortListe.addAll(Arrays.asList(mehrWorte[i].trim().split(" ")));
			}
		}
		List<String> neueWorte = new ArrayList<String>();
		Stream<String> worte = wortListe.stream();
		worte.forEach(str -> {
			if (str == null) {
				return;
			}
			str = str.replaceAll("�", "ae");
			str = str.replaceAll("�", "ue");
			str = str.replaceAll("�", "oe");
			str = str.replaceAll("�", "ss");
			str = str.toUpperCase();
			str = str.trim();
			if (str.length() > 8) {
				str = str.substring(0, 8);
			}
			neueWorte.add(str);
		});
		return neueWorte;
	}

	public List<String> manipulating(String [] mehrWorte) {
		_items = new ArrayList<String>();
		_itemsFertig = new ArrayList<String>();
		
		for (int i = 0; i < mehrWorte.length; i++) {
			if (mehrWorte[i] != null) {
				_items.addAll(Arrays.asList(mehrWorte[i].trim().split(" ")));
			}
		}
		_items.forEach(str -> {
			str = str.replaceAll("�", "ae");
			str = str.replaceAll("�", "ue");
			str = str.replaceAll("�", "oe");
			str = str.replaceAll("�", "ss");
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
