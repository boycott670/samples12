package com.sqli.nespresso.gossips;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor extends Person {

	private int currentPointer = 0;
	private final List<String> salutations = new ArrayList<>();
	
	public Doctor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String salutation) {
		salutations.add(salutation);
	}

	@Override
	public String whenAsked() {
		return salutations.stream().collect(Collectors.joining(", "));
	}

	@Override
	public boolean hasSomethingToSay() {
		return currentPointer < salutations.size();
	}

	@Override
	public void sayTo(Person other) {
		other.say(salutations.get(currentPointer ++));
	}

}
