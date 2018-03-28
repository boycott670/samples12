package com.sqli.nespresso.gossips;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Gossips
{
	private static enum GossipType
	{
		MISTER ("Mr", Mister.class);
		
		private final String repr;
		private final Class<? extends Gossip> type;
		
		private GossipType(final String repr, final Class<? extends Gossip> type)
		{
			this.repr = repr;
			this.type = type;
		}
		
		public Class<? extends Gossip> getType()
		{
			return type;
		}



		public static GossipType fromRepr (final String repr)
		{
			for (final GossipType gossipType : values())
			{
				if (gossipType.repr.equals(repr))
				{
					return gossipType;
				}
			}
			
			throw new IllegalStateException();
		}
	}
	
	private static enum ActionType
	{
		FROM,
		SAY;
	}
	
	private final Map<String, Gossip> gossips = new LinkedHashMap<>();
	
	private ActionType lastAction;
	private String lastGossip;
	private String lastMessage;
	
	public Gossips (final String... gossips)
	{
		for (final String gossip : gossips)
		{
			final String[] tokens = gossip.split(" ");
			
			try
			{
				final Gossip parsedGossip = GossipType.fromRepr(tokens[0]).getType().getDeclaredConstructor(String.class).newInstance(tokens[1]);
				
				this.gossips.put(tokens[1], parsedGossip);
			}
			catch (final NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException exception)
			{
				throw new IllegalStateException();
			}
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
		
	}
}
