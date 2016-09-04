package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents adding or deleting of a tag for a specific person that happened
 * during current session.
 *
 */
public class Tagging {
	enum Behaviour {ADD, DELETE}
	
	private Person person;
	private Tag tag;
	private Behaviour behaviour;

	public Tagging(Person person, Tag tag, Behaviour behaviour) {
		this.person = person;
		this.tag = tag;
		this.behaviour = behaviour;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public Tag getTag() {
		return this.tag;
	}
	
	public Behaviour getBehaviour() {
		return this.behaviour;
	}
}
