package com.sqli.nespresso.gossips;

public abstract class Person {

	protected Person(String name) {
		this.name = name;
	}

	private final String name;
	private Person next;


	public String getName() {
		return name;
	}
	
	public abstract void say (final String salutation);
	
	public abstract String whenAsked ();
	
	public abstract boolean hasSomethingToSay ();
	
	public abstract void sayTo (final Person other);


	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}
	
	public boolean hasNext ()
	{
		return next != null;
	}
	

}
