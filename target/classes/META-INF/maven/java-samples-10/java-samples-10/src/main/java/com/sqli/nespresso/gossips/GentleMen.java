package com.sqli.nespresso.gossips;

public class GentleMen extends Gossip {
	
	private String message = "";
	
	public GentleMen(String name) {
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
		
		if (getPrevious() != null && !message.isEmpty())
		{
			getPrevious().say(new StringBuilder(message).reverse().toString());
			message = "";
			
			return true;
		}
		
		return false;
		
	}
	
	

}
