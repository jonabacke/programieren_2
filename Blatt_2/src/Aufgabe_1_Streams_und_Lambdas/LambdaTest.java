package Aufgabe_1_Streams_und_Lambdas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LambdaTest {

	Streams_und_Lambdas _stream;
	@Test
	public void testeTrim() {
		String [] mehrWorte = {" adas "," dsfk����sdbj f ", null , " sd�fjhbjsdh bfjkh ", " idkushgfui "};
		_stream = new Streams_und_Lambdas();
		assertEquals("[ADAS, DSFKOEUE, F, SDSSFJHB, BFJKH, IDKUSHGF]", _stream.streamManipulating(mehrWorte).toString());
	}
	
	@Test
	public void umlaute() {
		String [] mehrWorte = {" ����� "," d����sfk����sdbj f ", null , " �������� bfjkh ", " ����� "};
		_stream = new Streams_und_Lambdas();
		assertEquals("[AEOEUEAE, DOEAEUEO, F, OEUEAEOE, BFJKH, SSSSSSSS]", _stream.streamManipulating(mehrWorte).toString());
	}
	
	@Test
	public void nullen() {
		String [] mehrWorte = {" null ",null," asdfasdw f ", null , " wadas bfjkh ", " adsw "};
		_stream = new Streams_und_Lambdas();
		assertEquals("[NULL, ASDFASDW, F, WADAS, BFJKH, ADSW]", _stream.streamManipulating(mehrWorte).toString());
	}


}
