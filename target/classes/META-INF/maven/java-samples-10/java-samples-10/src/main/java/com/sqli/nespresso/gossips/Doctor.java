package com.sqli.nespresso.gossips;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Gossip {
	private final List<String> messages = new ArrayList<>();
	private int indexOfMessageToSay = 0;
	
	public Doctor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String message) {
		messages.add(message);
	}

	@Override
	public String ask() {
		return messages.stream().collect(Collectors.joining(", "));
	}

	@Override
	public boolean spread() {
		
		if (super.spread() && indexOfMessageToSay < messages.size())
		{
			getNext().say(messages.get(indexOfMessageToSay ++));
			return true;
		}
		
		return false;
		
	}

	@Override
	public boolean continueSpreading() {

		return messages.size() - indexOfMessageToSay >= 2;
		
	}
			
}
