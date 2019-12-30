package com.game.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.game.constant.RulesEnum;

public class Dealer {
	private Deck deck;
	
	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public List<Player> findWinner(List<Player> playes) {
		Map<Player, RulesEnum> map = new HashMap<Player, RulesEnum>();
		for (Player player : playes) {
			RulesEnum evaluateCards = player.evaluateCards();
			map.put(player, evaluateCards);
		}
		
		Set<Entry<Player, RulesEnum>> entrySet = map.entrySet();
		Comparator<Entry<Player, RulesEnum>> valueComparator = new Comparator<Entry<Player, RulesEnum>>() {
            @Override
            public int compare(Entry<Player, RulesEnum> e1, Entry<Player, RulesEnum> e2) {
                Integer v1 = e1.getValue().getRule();
                Integer v2 = e2.getValue().getRule();
                if(v1.compareTo(v2) != 0) {
                	return v1.compareTo(v2);
                }
                return Integer.valueOf(e1.getKey().getRankCard()).compareTo(e2.getKey().getRankCard());
            }
        };
        
        List<Entry<Player, RulesEnum>> list = new ArrayList<Map.Entry<Player,RulesEnum>>(entrySet);
        Collections.sort(list, valueComparator);
		
         return getWinners(list);
	}

	private List<Player> getWinners(List<Entry<Player, RulesEnum>> list) {
		List<Player> winners = new ArrayList<>();
		Entry<Player, RulesEnum> first = list.get(list.size()-1);
		winners.add(first.getKey());

		for(int i = list.size() - 2; i >= 0 ; i--) {
			Entry<Player, RulesEnum> entry = list.get(i);
			
			if(first.getValue() != entry.getValue()) {
				break;
			}
			if(first.getKey().getRankCard() == entry.getKey().getRankCard()) {
				winners.add(entry.getKey());
			}else {
				break;
			}
		}
		return winners;
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	/* deal with multiple hands */
	public void deal(Player players[], int perHand) {
		for(int i=0; i< perHand; i++) {
			for(int j = 0 ; j < players.length; j++) {
				Player player = players[j];
				giveCardToPlayer(player);
			}
		}
	}
	
	private void giveCardToPlayer(Player player) {
		List<Card> cards = deck.getCards();
		Card card = cards.get(0);
		player.add(card);
		cards.remove(card);
	}
	
	/* deal with single hand */
	public void deal(Player player, int perHand) {
		for(int i=0; i< perHand ; i++) {
			giveCardToPlayer(player);
		}
	}

	public List<Player> doTie(List<Player> findWinner) {
		while(findWinner.size() > 1) {
			findWinner.stream().forEach(e -> e.clear());
			Player players[] = new Player[findWinner.size()];
			players = findWinner.toArray(players);
			deal(players, 1);
			findWinner = Arrays.asList(players);
			findWinner.forEach( e -> {
				e.flipCards();
				System.out.println(e.showHand());});
			findWinner = findWinner(findWinner);
		}
		return findWinner;
	}
	
	
}
