package com.sqli.nespresso.gossips;

public abstract class Gossip
{
	private final String name;
	private Gossip next;
	
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
}
