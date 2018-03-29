package com.sqli.nespresso.gossips;

public class Lady extends Gossip {
	
	private String message = "";

	public Lady(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

	@Override
	public String ask() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public boolean spread() {
		
		if (super.spread() && !message.isEmpty() && getPrevious() instanceof Doctor)
		{
			getNext().say(message);
			message = "";
			
			return true;
		}
		
		return false;
		
	}
	
	

}
