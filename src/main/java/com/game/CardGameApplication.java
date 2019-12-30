package com.game;

import java.util.Arrays;
import java.util.List;

import com.game.pojo.Dealer;
import com.game.pojo.Deck;
import com.game.pojo.Player;

public class CardGameApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CardGameApplication.class, args);
		CardGameApplication game = new CardGameApplication();
		Deck deck = new Deck();
		deck.populate();
		deck.shuffle();
		game.runGame(deck);
	}
	
	public void runGame(Deck deck) {
		Dealer dealer = new Dealer(deck);
		
		/* Create our playing hands */
		Player first= new Player("first");
		Player second = new Player("second");
		Player third = new Player("third");
		Player fourth = new Player("fourth");
		Player players[] = {first, second, third, fourth};
		
		/* Deal cards to our hands */
		dealer.deal(players, 3);
		
		/* show the player's hands */
		for(int i= 0; i < players.length ; i ++) {
			players[i].flipCards();
			System.out.println(players[i].showHand());
		}
		
		List<Player> findWinner = dealer.findWinner(Arrays.asList(players));
		System.out.println("Winner is " + findWinner.get(0).getName() + " and Cards : "  + findWinner.get(0).showHand());
		
	}

}
