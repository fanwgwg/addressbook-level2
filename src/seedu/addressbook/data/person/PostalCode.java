package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
	public static final String EXAMPLE = "123456";
	public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "Postal code should be in number";
	public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";
	public final String value;

	 /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code is invalid.
     */
	public PostalCode(String postalcode) throws IllegalValueException{
		 if (!isValidPostalCode(postalcode)) {
	            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
	        }
		this.value = postalcode;
	}
	
	 /**
     * Returns true if a given string is a valid postal code.
     */
	public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof PostalCode // instanceof handles nulls
						&& this.value.equals(((PostalCode) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
