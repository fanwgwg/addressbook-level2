package seedu.addressbook.common;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void isAnyNull_noArgs() {
		boolean result = Utils.isAnyNull();
		assertEquals(false, result);
	}
	
	@Test
	public void isAnyNull_noNull() {
		boolean result = Utils.isAnyNull(1, "hello", true);
		assertEquals(false, result);
	}

	@Test
	public void isAnyNullTest_someNull() {
		String nullString = null;
		boolean result = Utils.isAnyNull(1, "hello", true, nullString);
		assertEquals(true, result);
	}
	
	@Test
	public void isAnyNullTest_allNull(){
		String nullString = null;
		boolean result = Utils.isAnyNull(nullString, nullString);
		assertEquals(true, result);
	}
	
	@Test
	public void elementsAreUniqueTest_noElement(){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		boolean result = Utils.elementsAreUnique(testArrayList);
		assertEquals(true, result);
	}
	
	@Test
	public void elementsAreUniqueTest_uniqueElement(){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			testArrayList.add(i);
		}
		boolean result = Utils.elementsAreUnique(testArrayList);
		assertEquals(true, result);
	}
	
	@Test
	public void elementsAreUniqueTest_notUniqueElement(){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		testArrayList.add(1);
		testArrayList.add(2);
		testArrayList.add(3);
		testArrayList.add(1);
		boolean result = Utils.elementsAreUnique(testArrayList);
		assertEquals(false, result);
	}
	
}
