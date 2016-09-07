package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	private Name name1;
	
	@Before
	public void initialize() throws IllegalValueException {
		name1 = new Name("John K Smith");
	}
	
	@Test
	public void testNothing() {
	}
	
	@Test
	public void testOtherIsNull() {
		assertFalse("Both are null", name1.isSimilar(null));
	}

}
