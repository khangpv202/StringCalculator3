package StringCalculator.Qsoft_Calculator3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCalculator {
	@Test 
	public void testEmptyString(){
		Calculator cal = new Calculator();
		assertEquals(0,cal.add(""));
	}
	@Test
	public void testAddNumber(){
		Calculator cal = new Calculator();
		assertEquals(1,cal.add("1"));		
	}
	@Test
	public void testUnknowNumber(){
		Calculator cal = new Calculator();
		assertEquals(3,cal.add("1,2"));
		assertEquals(6,cal.add("1,2,3"));
	}
	@Test
	public void testAddNewLine(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("1\n2,3"));
	}
	@Test
	public void testAddDelimiter(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//;\n1;2;3"));
	}
	@Test
	public void testAddNegative(){
		Calculator cal = new Calculator();
		try {
			cal.add("-21\n2,-3");
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed", e.getMessage());
		}
	}
	@Test
	public void testBiger1000(){
		Calculator cal = new Calculator();
		assertEquals(2,cal.add("2,1001"));		
	}
	@Test
	public void testMoreDelimiters(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//[***]\n1***2***3"));	
	}
	@Test
	public void testMutilDelimiters(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//[***][,,]\n1***2,,3"));	
	}
}
