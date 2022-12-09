/**
 * @author Daniel Woods
 * This method is a card object. It stores and produces information about
 * a playing card, such as suit and rank.
 */
public class card {
public Rank rank;
public Suit suit;

	/**
	 * constructor takes 2 parameters, rank and suit. This is stored in the object.
	 * @param rank	Rank, the rank of the card
	 * @param suit	Suit, the suit of the card
	 */
	public card(Rank rank, Suit suit) {
	this.suit = suit;
	this.rank = rank;
}

	/**
	 * accessor
	 * getRank returns the rank of the card
	 * @return Rank, rank of the card
	 */
	public Rank getRank() {
	return rank;
}

	/**
	 * mutator
	 * setRank changes the rank of the card.
	 * @param value	Rank, the new rank of the card
	 *
	 */
	public void setRank(Rank value) {
	this.rank = value;
}

	/**
	 * accessor
	 * returns the suit of the card.
	 * @return Suit, returns the suit of the card.
	 */
	public Suit getSuit() {
	return suit;
}

	/**
	 * mutator
	 * sets the suit of the card
	 * @param suit	Suit, the new suit of the card.
	 */
	public void setSuit(Suit suit) {
	this.suit = suit;
}

	@Override
	/**
	 * returns a String with the rank and suit of the card.
	 * @return	String, formatted rank and suit of the card.
	 */
	public String toString() {
		return "card{" +
				"rank=" + rank +
				", suit=" + suit +
				'}';
	}

	/**
	 * printCard returns a string with a graphical representation of the card.
	 * @return	String, unicode suit and text rank of the card.
	 */
	public String printCard(){
	String cardString="";

		switch (suit) {
			case Clubs -> cardString += '♣';
			case Spades -> cardString += "♠";
			case Hearts -> cardString += "❤";
			case Diamonds -> cardString += "♦";
		}
		switch (rank) {
			case Ace -> cardString += "A";
			case Two -> cardString += "2";
			case Three -> cardString += "3";
			case Four -> cardString += "4";
			case Five -> cardString += "5";
			case Six -> cardString += "6";
			case Seven -> cardString += "7";
			case Eight -> cardString += "8";
			case Nine -> cardString += "9";
			case Ten -> cardString += "10";
			case Jack -> cardString += "J";
			case Queen -> cardString += "Q";
			case King -> cardString += "K";
		}
	return cardString;
	}
}
