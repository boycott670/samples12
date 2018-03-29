package com.sqli.nespresso.gossips;

public class Professor extends Gossip {
	
	private String message = "";
	private boolean beenSpread = false;
			
	public Professor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String message) {
		this.message = message;
	}

	@Override
	public String ask() {
		return message;
	}

	@Override
	public boolean spread() {
		
		if (beenSpread)
		{
			if (super.spread() && !message.isEmpty())
			{
				getNext().say(message);
				message = "";
				
				return true;
			}
			
			return false;
		}
		else
		{
			beenSpread = true;
			return true;
		}
		
	}

}
