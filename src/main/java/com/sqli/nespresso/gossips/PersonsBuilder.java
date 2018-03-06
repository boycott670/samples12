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
	
	
	
	public Mister buildMister ()
	{
		return null;
	}
	
}
