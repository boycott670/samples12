package com.sqli.nespresso.gossips;

public final class PersonsBuilder {

	private String name;
	private Person next;
	
	public PersonsBuilder withName (final String name)
	{
		this.name = name;
		return this;
	}
	
	public PersonsBuilder withNext (final Person next)
	{
		this.next = next;
		return this;
	}
	
	private Person buildPerson (final Person person)
	{
		person.setNext(next);
		return person;
	}
	
	public Doctor buildDoctor ()
	{
		return (Doctor)buildPerson(new Doctor(name));
	}
	
	public Mister buildMister ()
	{
		return (Mister)buildPerson(new Mister(name));
	}
	
}
