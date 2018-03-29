package com.sqli.nespresso.gossips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Agent extends Gossip {
	
	private final Collection<String> messages = new ArrayList<>();
	private int spreadCounter = 0;
	
	public Agent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String message) {
		// TODO Auto-generated method stub
		messages.add(message);
	}

	@Override
	public String ask() {
		return spreadMoreThanOnce() ? "" : messages.stream().collect(Collectors.joining(", "));
	}

	@Override
	public boolean spread() {
		spreadCounter ++;
		return false;
	}

	@Override
	public boolean continueSpreading() {
		return true;
	}
	
	private boolean spreadMoreThanOnce ()
	{
		return spreadCounter > 1;
	}
	
}
