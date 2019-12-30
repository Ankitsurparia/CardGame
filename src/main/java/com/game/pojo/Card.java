package com.game.pojo;

import com.game.constant.Rank;
import com.game.constant.Suit;

public class Card implements Comparable<Card>{
	private Suit suit;
	private Rank rank;
	private boolean isFaceUp;
	
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		isFaceUp = true;
	}
	
	public int getRank() {
		return rank.getRank();
	}
	
	public String getSuit() {
		return suit.getSuit();
	}
	
	public void flipCard() {
		isFaceUp = !isFaceUp;
	}
	
	public String toString() {
		String str = "";
		if (isFaceUp) {
			str+= getRank() + " of " + getSuit();
		}else {
			str += "Face Down (nothing to see here)";
		}
		return str;
	}
	
	public boolean isFaceUp() {
		return isFaceUp;
	}

	@Override
	public int compareTo(Card o) {
		if (o.getRank() == this.getRank()) {
			return 0;
		}
		if (o.getRank() < this.getRank()) {
			return 1;
		}else {
			return -1;
		}
			
	}

}
