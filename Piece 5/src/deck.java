/**
 * @author Daniel Woods
 * this class represents a 52 card deck of card objects.
 */

import java.util.ArrayList;
import java.util.Collections;

public class deck {
final ArrayList<card> deck = new ArrayList<>();

	/**
	 * constructor takes no parameters. It iterates through each suit and each rank,
	 * creating one card at a time and adding it to the deck ArrayList.
	 */
	public deck() {
	for(Suit s : Suit.values()) {
		for(Rank r : Rank.values()) {
			card c = new card(r,s);
			deck.add(c);
		}
	}
	}

	/**
	 * shuffle takes no parameters and is of void return type. It shuffles the order of the deck.
	 */
	public void shuffle() {
Collections.shuffle(deck);
}

	/**
	 * draw takes an int as a parameter, it removes the card at that index from the deck
	 * and returns it. Useful when adding cards to a hand.
	 *
	 * @param i	int, the index of the card you want to draw (usually 0)
	 * @return	the card at that index, now removed from the deck.
	 */
	public card draw(int i){
	return deck.remove(i);
}

	/**
	 * toString returns a String of the entire deck. I used this for bug smashing, but it's ugly
	 * so probably not the best. Good thing looking at the deck is CHEATING!
	 * @return	String, string of the entire deck.
	 */
	@Override
	public String toString() {
	StringBuilder deckString= new StringBuilder("" + deck.size());
	for(card c : deck){
		deckString.append(c.toString());
	}
		return deckString.toString();
	}

	/**
	 * this method takes a card object as a parameter and puts it at the end of the deck.
	 * It's a good move to shuffle after this.
	 * @param c card, card to put back into the deck.
	 */
	public void putBack(card c){
	deck.add(c);
	}
}
