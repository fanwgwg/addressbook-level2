package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	private Name name1;
	private Name name2;
	private Name name3;
	
	@Before
	public void initialize() throws IllegalValueException {
		name1 = new Name("John K Smith");
		name2 = new Name("john k smith");
		name3 = new Name("John Smith K");
	}
	
	@Test
	public void testNothing() {
	}
	
	@Test
	public void testOtherIsNull() {
		assertFalse("Other is null", name1.isSimilar(null));
	}
	
	@Test
	public void testDifferentCases() {
		assertTrue("Two names are in different cases", name1.isSimilar(name2));
	}
	
	@Test
	public void testDifferentOrders() {
		assertTrue("Two names are in differnt orders", name1.isSimilar(name3));
	}

}
