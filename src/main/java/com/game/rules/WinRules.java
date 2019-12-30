package com.game.rules;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.game.pojo.Card;

/*
 * having the rules per method to determine winner.
 * */
public class WinRules {
	
	Logger logger = LoggerFactory.getLogger(WinRules.class);
	
	/* 
	 * This method takes input as list of Cards of player
	 * and determined the The next highest is a sequence
	 * (numbers in order, e.g., 4,5,6. A is considered to have a value of 1)
	 * */
	public int isSequence(List<Card> cards) {
		Collections.sort(cards);
		boolean isSequence = true;
		int j = 1;
		for (int i = 0; i < cards.size()-1; i++) {
			Card card = cards.get(i);
			Card card2 = cards.get(j);
			if(card2.getRank() - card.getRank() != 1) {
				isSequence = isSequence & false;
				break;
			}
			j++;
		}
		if(!isSequence) {
			return 0;
		}
		return cards.get(cards.size() - 1).getRank();
	}
	
	
	/* 
	 * This method takes input as list of Cards of player
	 * and determined The next highest is a pair of cards
	 *  (e.g.: two Kings or two 10s)
	 * */
	public int isPair(List<Card> cards) {
		Set<Integer> cardsKey = new HashSet<Integer>();
		int rank = 0;
		for (Card card : cards) {
			if(cardsKey.contains(card.getRank())) {
				rank = card.getRank();
				break;
			}
			cardsKey.add(card.getRank());
		}
		return rank;
	}
	
	/* 
	 * This method takes input as list of Cards of player
	 * and determined the top card (by number value wins)
	 * */
	public int isTopCard(List<Card> cards) {
		Collections.sort(cards);
		return cards.get(cards.size() - 1).getRank();
	}
	
	
	public boolean isTopCardWithSameValue(List<Card> cards) {
		Set<Card> cardsKey = new HashSet<Card>();
		boolean isDuplidatePresent = false;
		for(Card card : cards) {
			if(cardsKey.contains(card)) {
				isDuplidatePresent = true;
			}
			cardsKey.add(card);
		}
		return isDuplidatePresent;
	}
	
	/* 
	 * This method takes input as list of Cards of player
	 * and determined  A trail (three cards of the same number) is the highest 
	 *  possible combination.
	 *  
	 * */
	public int isTrail(List<Card> cards) {
		Map<Integer, Card> map = new HashMap<>();
		for (Card card : cards) {
			map.put(card.getRank(), card);
		}
		return (map.size() == 1) ? cards.get(0).getRank() : 0;
	}
	
}
