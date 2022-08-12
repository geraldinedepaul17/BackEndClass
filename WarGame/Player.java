package WarGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
private List<Card> hand = new ArrayList<Card>(); 
private int score; 
private String name; 


public Player() { 
	score = 0; 
	
}

public void describe() {
	System.out.println("Player name: " + name + " and my score is: " + score); 
	if (hand.size() >0) {
		System.out.println("Cards in Hand: " + hand.size());
		for (Card card : hand) { 
			card.describe(); 
		}
	}
}

public void draw(Deck mainDeck) {
	Card card = mainDeck.draw(); 
	hand.add(card); 
}

public void incrementScore() {
	score++; 
}

public Card flip() {
	return hand.remove(0); 
}

public void setName(String name) {
	this.name = name; 
}

public String getName() {
	return name; 
}

public int getScore() {
	return score; 
}
}
