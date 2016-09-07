package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the contact info of a person
 *
 */
public class Contact {

	public final String value;
	protected boolean isPrivate;

	public Contact(String value, boolean isPrivate, String example, String messageConstraints, String validationRegex)
			throws IllegalValueException {
		this.value = value;
		this.isPrivate = isPrivate;
		if (!value.matches(validationRegex)) {
			throw new IllegalValueException(messageConstraints);
		}
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
