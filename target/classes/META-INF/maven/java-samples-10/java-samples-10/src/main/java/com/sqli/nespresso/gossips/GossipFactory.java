package com.sqli.nespresso.gossips;

public class GossipFactory {

	public Gossip get (final String type, final String name)
	{
		switch (type)
		{
			case "Mr":
				return new Mister(name);
				
			case "Dr":
				return new Doctor(name);
				
			case "Agent":
				return new Agent(name);
				
			case "Pr":
				return new Professor(name);
				
			case "Lady":
				return new Lady(name);
				
			case "Sir":
				return new GentleMen(name);
		}
		
		throw new IllegalArgumentException("Invalid type");
	}
	
}
