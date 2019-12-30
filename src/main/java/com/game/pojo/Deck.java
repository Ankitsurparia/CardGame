package com.game.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.game.constant.Rank;
import com.game.constant.Suit;

public class Deck {
	private List<Card> cards;
	private Random random = new Random();
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		populate();
	}
	
	public void populate() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				card.flipCard();
				cards.add(card);
			}
		}
	}

	public void populate(List<Card> cards) {
		this.cards.clear();
		this.cards.addAll(cards);
	}

	public void shuffle() {
		for (int i = cards.size() - 1; i > 0; i--) {
			int pick = random.nextInt(i);
			Card rankCard = cards.get(pick);
			Card lastCard = cards.get(i);
			cards.set(i, rankCard);
			cards.set(pick, lastCard);
		}
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
}
