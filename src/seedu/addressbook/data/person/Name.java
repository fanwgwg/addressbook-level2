package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }
    
	/**
	 * Returns true of the other name is very similar to this name. Two names
	 * are considered similar if both are not null, but they are just in
	 * different cases, different orders, or they are subset/superset of each
	 * other
	 */
	public boolean isSimilar(Name other) {
		if(other == null) {
			return false;
		}
		
		if(areDifferentCases(this, other)) {
			return true;
		}
		
		if(isSubset(this, other)) {
			return true;
		}
		
		return false;
	}

	/**
	 * @param name
	 * @param other
	 * @return true if one name is subset of another name
	 */
	private boolean isSubset(Name name, Name other) {
		List<String> wordsInThisNameAsList = this.getWordsInName();
		List<String> wordsInOtherNameAsList = other.getWordsInName();

		TreeSet<String> wordsInThisNameAsSet = new TreeSet<String>();
		TreeSet<String> wordsInOtherNameAsSet = new TreeSet<String>();
		
		for(String word : wordsInThisNameAsList) {
			wordsInThisNameAsSet.add(word.toLowerCase());
		}
		
		for(String word : wordsInOtherNameAsList) {
			wordsInOtherNameAsSet.add(word.toLowerCase());
		}
		
		if (wordsInThisNameAsSet.size() < wordsInOtherNameAsSet.size()) {
			for (String word : wordsInThisNameAsSet) {
				if (!wordsInOtherNameAsSet.contains(word)) {
					return false;
				}
			}
		} else {
			for (String word : wordsInOtherNameAsSet) {
				if (!wordsInThisNameAsSet.contains(word)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * @param name
	 * @param other
	 * @return true if both names are the same, just that they are in different cases
	 */
	private boolean areDifferentCases(Name name, Name other) {
		return other.toString().toLowerCase().equals(this.toString().toLowerCase());
	}

	@Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
