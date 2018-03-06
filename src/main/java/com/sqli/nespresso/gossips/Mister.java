package com.sqli.nespresso.gossips;

import java.util.Optional;

public class Mister extends Person {

	private String salutation;
	
	public Mister(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(String salutation) {
		// TODO Auto-generated method stub
		this.salutation = salutation;
	}

	@Override
	public String whenAsked() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(salutation).orElse("");
	}

	@Override
	public boolean hasSomethingToSay() {
		return salutation != null;
	}

	@Override
	public void sayTo(Person other) {
		other.say(salutation);
		salutation = null;
	}
	
}
