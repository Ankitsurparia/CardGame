package com.game;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.game.constant.Rank;
import com.game.constant.Suit;
import com.game.pojo.Card;
import com.game.pojo.Dealer;
import com.game.pojo.Deck;
import com.game.pojo.Player;

class CardGameApplicationTests {
	
	@Test
	public void testPlayerTrail() {
		List<Player> listOfPlayers = new ArrayList<Player>();
		Player p1 = new Player("P1");

		Card c1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card c3 = new Card(Suit.HEARTS, Rank.SEVEN);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);

		Player p2 = new Player("P2");
		Card c4 = new Card(Suit.HEARTS, Rank.FIVE);
		Card c5 = new Card(Suit.HEARTS, Rank.EIGHT);
		Card c6 = new Card(Suit.HEARTS, Rank.DEUCE);
		p2.add(c4);
		p2.add(c5);
		p2.add(c6);

		listOfPlayers.add(p1);
		listOfPlayers.add(p2);

		Deck deck = new Deck();
		Dealer dealer = new Dealer(deck);

		List<Player> findWinner = dealer.findWinner(listOfPlayers);

		assertTrue(findWinner.get(0).getName().equals("P1"));
	}

	@Test
	public void testPlayerSequence() {
		List<Player> listOfPlayers = new ArrayList<Player>();
		Player p1 = new Player("P1");

		Card c1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card c3 = new Card(Suit.HEARTS, Rank.THEREE);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);

		Player p2 = new Player("P2");
		Card c4 = new Card(Suit.HEARTS, Rank.FIVE);
		Card c5 = new Card(Suit.HEARTS, Rank.SIX);
		Card c6 = new Card(Suit.HEARTS, Rank.SEVEN);
		p2.add(c4);
		p2.add(c5);
		p2.add(c6);

		listOfPlayers.add(p1);
		listOfPlayers.add(p2);

		Deck deck = new Deck();
		Dealer dealer = new Dealer(deck);
		List<Player> findWinner = dealer.findWinner(listOfPlayers);
		assertTrue(findWinner.get(0).getName().equals("P2"));
	}
	
	@Test
	public void testPlayerSequence_dual() {
		List<Player> listOfPlayers = new ArrayList<Player>();
		Player p1 = new Player("P1");

		Card c1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card c2 = new Card(Suit.HEARTS, Rank.EIGHT);
		Card c3 = new Card(Suit.HEARTS, Rank.NINE);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);

		Player p2 = new Player("P2");
		Card c4 = new Card(Suit.HEARTS, Rank.FIVE);
		Card c5 = new Card(Suit.HEARTS, Rank.SIX);
		Card c6 = new Card(Suit.HEARTS, Rank.SEVEN);
		p2.add(c4);
		p2.add(c5);
		p2.add(c6);

		listOfPlayers.add(p1);
		listOfPlayers.add(p2);

		Deck deck = new Deck();
		Dealer dealer = new Dealer(deck);

		List<Player> findWinner = dealer.findWinner(listOfPlayers);

		assertTrue(findWinner.get(0).getName().equals("P1"));
	}
	
	@Test
	public void testPlayerTopSame() {
		List<Player> listOfPlayers = new ArrayList<Player>();
		Player p1 = new Player("P1");

		Card c1 = new Card(Suit.HEARTS, Rank.KING);
		Card c2 = new Card(Suit.HEARTS, Rank.EIGHT);
		Card c3 = new Card(Suit.HEARTS, Rank.NINE);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);

		Player p2 = new Player("P2");
		Card c4 = new Card(Suit.CLUBS, Rank.KING);
		Card c5 = new Card(Suit.CLUBS, Rank.SIX);
		Card c6 = new Card(Suit.CLUBS, Rank.SEVEN);
		p2.add(c4);
		p2.add(c5);
		p2.add(c6);

		listOfPlayers.add(p1);
		listOfPlayers.add(p2);
		Card c7 = new Card(Suit.HEARTS, Rank.TEN);
		Card c8 = new Card(Suit.HEARTS, Rank.SEVEN);

		Deck deck = new Deck();
		List<Card> deckCards = new ArrayList<>();  
				deckCards.add(c7);
				deckCards.add(c8);
		
		Dealer dealer = new Dealer(deck);

		List<Player> findWinner = dealer.findWinner(listOfPlayers);
		deck.populate(deckCards);
		
		if(findWinner.size() > 1)  {
			findWinner = dealer.doTie(findWinner);
		}
		assertTrue(findWinner.get(0).getName().equals("P1"));			
	}
	
	@Test
	public void sampleRun() {
		CardGameApplication game = new CardGameApplication();
		Deck deck = new Deck();
		deck.populate();
		deck.shuffle();
		game.runGame(deck);
	}

}
