/**
 * @Author Daniel Woods
 * This method is the Hand object. It holds a poker hand. It will hols objects of type card.
 * This method is meant to be used by the dealer and the play method. Those methods
 * correctly handle this method and ensure cards removed from the hand
 * are placed back in the deck.
 */
import java.util.ArrayList;
import java.util.Collections;
public class hand {
    final ArrayList<card> cards = new ArrayList<>();
    final ArrayList<Rank> ranks = new ArrayList<>();
    final ArrayList<Suit> suits = new ArrayList<>();

    /**
     *Hand
     * Constructor takes no parameters. Used to construct an empty hand
     */
    public hand() {}

    /**
     * addCard takes a card object as a parameter and adds it to the hand. It also adds
     * the rank and a suit to a list and sorts them for easy comparison by the dealer
     * return type is void
     * @param card  Card object that you would like to add
     */
    public void addCard(card card) {
       cards.add(card);
       ranks.add(card.getRank());
       suits.add(card.getSuit());
        Collections.sort(ranks);
        Collections.sort(suits);
    }

    /**
     * {@code @overload}
     * removeCard removes the card from the hand. It updates the list of
     * suits and ranks to remove the card.
     * @param card  Card object that you would like to remove
     * @return the same card that was removed, this makes it easier to put it back in the deck
     */
    public card removeCard(int card){
        card remCard=cards.remove(card);
        ranks.remove(remCard.getRank());
        suits.remove(remCard.getSuit());
        return remCard;
    }
    /**
     * {@code @overload}
     * removeCard removes the first card from the hand. It updates the list of
     * suits and ranks to remove the card.
     * @return the same card that was removed, this makes it easier to put it back in the deck
     */
    public card removeCard(){
        card card = cards.remove(0);
        cards.remove(card);
        ranks.remove(card.getRank());
        suits.remove(card.getSuit());
        return card;
    }
    /**
     * {@code @overload}
     * removeCard removes the first card from the hand that has a rank that matches the
     * supplied parameter. It updates the list of suits and ranks to remove the card.
     * @param r  The rank of the card you would like to remove
     * @return the same card that was removed, this makes it easier to put it back in the deck
     */
    public card removeCard(Rank r){
        for(card c :cards){
            if(c.getRank()==r){
                cards.remove(c);
                ranks.remove(c.getRank());
                suits.remove(c.getSuit());
                return c;
            }
        }
        return null;
    }

    /**
     * Accessor method that returns an ArrayList of sorted ranks of all the cards in the hand
     * @return  Sorted ArrayList<Rank> of Rank enumerated type.
     */
    public ArrayList<Rank> getRanks() {
        return ranks;
    }
    /**
     * Accessor method that returns an ArrayList of sorted suits of all the cards in the hand
     * @return  Sorted ArrayList<Suit> of Suit enumerated type.
     */
    public ArrayList<Suit> getSuits() {
        return suits;
    }

    @Override
    /**
     * toString overrides default method and iterates through all the cards in the hand. It returns
     * a string of all the suits and ranks that is printable
     */
    public String toString() {
        StringBuilder cardString = new StringBuilder();

        for(card c:cards){
            cardString.append(c.printCard()).append(" ");
        }
        return cardString.toString();
    }

    /**
     * getSize takes no parameters and returns the number of cards that are
     * currently in the hand
     * @return  int number of cards that are currently in the hand
     */
    public int getSize(){
        return cards.size();
    }
}
