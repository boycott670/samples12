package com.sqli.nespresso.gossips;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Gossips
{
	private static enum ActionType
	{
		FROM,
		SAY;
	}
	
	private final Map<String, Gossip> gossips = new LinkedHashMap<>();
	private final GossipFactory gossipFactory = new GossipFactory();
	
	private ActionType lastAction;
	private String lastGossip;
	private String lastMessage;
	
	public Gossips (final String... gossips)
	{
		for (final String gossip : gossips)
		{
			final String[] tokens = gossip.split(" ");
			
			this.gossips.put(tokens[1], gossipFactory.get(tokens[0], tokens[1]));
		}
	}
	
	public Gossips from (final String gossip)
	{
		lastAction = ActionType.FROM;
		lastGossip = gossip;
		return this;
	}
	
	public Gossips say (final String message)
	{
		lastAction = ActionType.SAY;
		lastMessage = message;
		return this;
	}
	
	public Gossips to (final String gossip)
	{
		if (lastAction == ActionType.FROM)
		{
			gossips.get(lastGossip).setNext(gossips.get(gossip));
			gossips.get(gossip).setPrevious(gossips.get(lastGossip));
		}
		else
		{
			gossips.get(gossip).say(lastMessage);
		}
		
		return this;
	}
	
	public String ask (final String gossip)
	{
		return gossips.get(gossip).ask();
	}
	
	public void spread ()
	{
		for (final Entry<?, ? extends Gossip> entry : gossips.entrySet())
		{
			if (entry.getValue().spread())
			{
				if (entry.getValue().getNext().continueSpreading())
				{
					continue;
				}
				
				break;
			}
		}
	}
}
