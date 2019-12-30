package com.game.pojo;

import java.util.ArrayList;
import java.util.List;

import com.game.constant.RulesEnum;
import com.game.rules.WinRules;

/*
 * Player class having list of cards with Rank
 * */
public class Player {
	private List<Card> cards;
	private String name;
	private int rankCard;
	
	public Player(String name){
		cards = new ArrayList<Card>();
		this.name = name;
	}
	
	public void clear() {
		cards.clear();
	}
	public int getRankCard() {
		return rankCard;
	}
	
	public void add(Card card) {
		cards.add(card);
	}
	
	public int size() {
		return cards.size();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Card getCardByIndex(int index) {
		return cards.get(index);
	}
	
	public void setCard(int index, Card card) {
		cards.set(index, card);
	}
	
	public void remove(Card card) {
		cards.remove(card);
	}
	
	/*
	 * This method return string with appended cards Rank and Suit 
	 * */
	public String showHand() {
		StringBuffer buffer = new StringBuffer();
		boolean allFaceUp = true;
		for(Card card : cards) {
			buffer.append(this.name).append(" ")
			.append(card.toString()).append("\n");
			if(!card.isFaceUp()) {
				allFaceUp = false;
			}
		}
		return buffer.toString();
	}
	
	public void flipCards() {
		for(Card card : cards) {
			card.flipCard();
		}
	}
	
	
	/*
	 * evaluateCards method determines Rank of Card per player
	 * put appropriate victory condition.
	 * 
	 * This method create WinRule object and calls 
	 * defined rules one by one in sequence to determine the player rank 
	 * */
	public RulesEnum evaluateCards() {
		WinRules rule = new WinRules();
		int trail = rule.isTrail(this.cards);
		if(trail != 0) {
			this.rankCard = trail;
			return RulesEnum.Trail;
		}
		
		int sequence = rule.isSequence(this.cards);
		if(sequence != 0) {
			this.rankCard = sequence;
			return RulesEnum.Sequence;
		}
		
		int pair = rule.isPair(this.cards);
		if(pair != 0) {
			this.rankCard = pair;
			return RulesEnum.Pair;
		}
		
		int topCard = rule.isTopCard(this.cards);
		this.rankCard = topCard;
		return RulesEnum.TopCard;
	}
}
