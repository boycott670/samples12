package com.sqli.nespresso.gossips;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Gossips {

	private enum ActionType
	{
		SAY,
		FROM;
	}
	
	private final Map<String, Person> persons = new LinkedHashMap<>();
	
	private ActionType actionType;
	private Person from;
	private String salutation;
	
	public Gossips(final String... persons)
	{
		for (final String person : persons)
		{
			final String[] tokens = person.split("\\s+");

			Person personToAdd = null;
			
			switch (tokens [0])
			{
				case "Mr":
					personToAdd = new Mister(tokens [1]);
					break;
					
				case "Dr":
					personToAdd = new Doctor(tokens [1]);
					break;
			}
			
			this.persons.put(tokens [1], personToAdd);
		}
	}
	
	public Gossips from (final String from)
	{
		actionType = ActionType.FROM;
		this.from = persons.get(from);
		return this;
	}
	
	public Gossips say (final String salutation)
	{
		actionType = ActionType.SAY;
		this.salutation = salutation;
		return this;		
	}
	
	public Gossips to (final String to)
	{
		if (actionType == ActionType.FROM)
		{
			from.setNext(persons.get(to));
		}
		else if (actionType == ActionType.SAY)
		{
			persons.get(to).say(salutation);
		}
		
		return this;		

	}
	
	public void spread ()
	{
		Class<? extends Person> lastSeenType = null;
		
		for (final Entry<?, ? extends Person> personEntry : persons.entrySet())
		{
			if (personEntry.getValue().hasSomethingToSay() && personEntry.getValue().hasNext())
			{
				if (lastSeenType == null || !lastSeenType.equals(personEntry.getValue().getClass()))
				{
					lastSeenType = personEntry.getValue().getClass();
				}
				else
				{
					break;
				}
				
				personEntry.getValue().sayTo(personEntry.getValue().getNext());

			}
		}
	}
	
			public String ask (final String person)
			{
				return persons.get(person).whenAsked();
			}
		}
				

