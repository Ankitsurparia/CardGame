package com.game;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.game.pojo.Card;
import com.game.rules.WinRules;

/*
 * here mocking the WinRules with mockito
 * */
class WinRulesTest {

	@Test
	public void isTrail() {
		WinRules windRules = new WinRules();
		List<Card> cards = new ArrayList<>();
		Card mockCard = Mockito.mock(Card.class);
		cards.add(mockCard);
		cards.add(mockCard);
		cards.add(mockCard);
		when(mockCard.getRank()).thenReturn(2);
		int trail = windRules.isTrail(cards);
		assertTrue(trail == 2);
	}

	@Test
	public void isSequenceMock() {
		WinRules windRules = new WinRules();
		List<Card> cards = new ArrayList<>();
		Card mockCard = Mockito.mock(Card.class);
		Card mockCard2 = Mockito.mock(Card.class);
		Card mockCard3 = Mockito.mock(Card.class);
		cards.add(mockCard);
		cards.add(mockCard2);
		cards.add(mockCard3);

		when(mockCard.getRank()).thenReturn(2);
		when(mockCard2.getRank()).thenReturn(4);
		when(mockCard3.getRank()).thenReturn(3);
		when(mockCard.compareTo(mockCard2)).thenReturn(-1);
		when(mockCard.compareTo(mockCard3)).thenReturn(-1);
		when(mockCard2.compareTo(mockCard)).thenReturn(1);
		when(mockCard2.compareTo(mockCard3)).thenReturn(1);
		when(mockCard3.compareTo(mockCard)).thenReturn(1);
		when(mockCard3.compareTo(mockCard2)).thenReturn(-1);
		int trail = windRules.isSequence(cards);
		assertTrue(trail == 4);
	}
	
	@Test
	public void isPair() {
		WinRules windRules = new WinRules();
		List<Card> cards = new ArrayList<>();
		Card mockCard = Mockito.mock(Card.class);
		Card mockCard2 = Mockito.mock(Card.class);
		Card mockCard3 = Mockito.mock(Card.class);
		cards.add(mockCard);
		cards.add(mockCard2);
		cards.add(mockCard3);
		
		when(mockCard.getRank()).thenReturn(2);
		when(mockCard2.getRank()).thenReturn(4);
		when(mockCard3.getRank()).thenReturn(4);
		
		int pair = windRules.isPair(cards);
		assertTrue(pair == 4);
	}

	@Test
	public void isTopCard() {
		WinRules windRules = new WinRules();
		List<Card> cards = new ArrayList<>();
		Card mockCard = Mockito.mock(Card.class);
		Card mockCard2 = Mockito.mock(Card.class);
		Card mockCard3 = Mockito.mock(Card.class);
		cards.add(mockCard);
		cards.add(mockCard2);
		cards.add(mockCard3);
		
		when(mockCard.getRank()).thenReturn(2);
		when(mockCard2.getRank()).thenReturn(10);
		when(mockCard3.getRank()).thenReturn(3);
		
		when(mockCard.compareTo(mockCard2)).thenReturn(-1);
		when(mockCard.compareTo(mockCard3)).thenReturn(-1);
		
		when(mockCard2.compareTo(mockCard)).thenReturn(1);
		when(mockCard2.compareTo(mockCard3)).thenReturn(1);
		
		when(mockCard3.compareTo(mockCard)).thenReturn(1);
		when(mockCard3.compareTo(mockCard2)).thenReturn(-1);
		
		int topCard = windRules.isTopCard(cards);
		assertTrue(topCard == 10);
	}
}
