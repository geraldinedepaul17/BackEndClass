package WarGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	 

	public Deck() {
		String suits[] = { "Clubs", "Diamonds", "Spades", "Hearts" };
		String faces[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		deck = new ArrayList<>();
		for (String suit : suits) {
			for (int i = 0; i < faces.length; i++) {
				deck.add(new Card(i + 2, (faces [i] + " of " + suits)));
			}
		}
	}

	public Card draw() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
		;
	}

	public void size() {
		System.out.println(deck.size());
	}
}

