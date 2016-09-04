package seedu.addressbook.data.person;

/**
 * Represents the contact info of a person
 *
 */
public abstract class Contact {
	
    public final String value ;
    protected boolean isPrivate;
    
    protected Contact(String value, boolean isPrivate) {
    	this.value = value;
    	this.isPrivate = isPrivate;
    }
    
    public abstract boolean equals(Object other);
    
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
