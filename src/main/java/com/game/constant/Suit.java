package com.game.constant;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	DIAMONDS("Diamond"),
	CLUBS("Clubs");
	
	private final String suitText;
	
	private Suit(String suitText) {
		this.suitText = suitText;
	}
	
	public String getSuit() {
		return suitText;
	}
}
