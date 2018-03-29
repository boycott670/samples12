package com.sqli.nespresso.gossips;

public abstract class Gossip
{
	private final String name;
	private Gossip next;
	private Gossip previous;
	
	public abstract void say (final String message);
	public abstract String ask ();
	
	public Gossip(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public Gossip getNext()
	{
		return next;
	}
	
	public void setNext(final Gossip next)
	{
		this.next = next;
	}
	
	public Gossip getPrevious() {
		return previous;
	}
	
	public void setPrevious(Gossip previous) {
		this.previous = previous;
	}
	
	public boolean spread ()
	{
		return getNext() != null;
	}
	
	public boolean continueSpreading ()
	{
		return false;
	}
}
