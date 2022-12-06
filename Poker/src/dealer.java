/**
 * @author Daniel Woods
 * This method uses the deck, card and hand method and interfaces between them.
 * It properly moves the cards from the deck to the hand and the hand to the deck
 * with no data loss. It also evaluates hands and finds the value of them. This class
 * has a lot of methods that return hands, this is not always necessary as
 * java passes most objects by reference, but it is there as a utility in
 * case any of these methods could be used in other classes. This method should be used for
 * most of the interfacing between hands and the deck. This method ensures no cards are lost when they
 * are being passed from the hand to the deck and vice versa.
 */

import java.util.ArrayList;

public class dealer {
    final deck dck;
   boolean isRoyalFlush;
    boolean isStraightFlush=false;
    boolean isQuadruple=false;
    boolean isFullHouse=false;
    boolean isFlush=false;
    boolean isStraight=false;
    boolean isTriple=false;
    boolean isTwoPair=false;
    boolean isPair=false;
    boolean isNothing=false;
    String handString="Not Evaluated!!";
    int resultID=15;

    /**
     * dealer constructor takes no arguments, and constructs the deck object, and shuffles it
     */
    public dealer() {
        dck = new deck();
        shuffle();
    }

    /**
     * drawFive draws 5 cards from the deck and returns a hand object with the 5 cards
     * @return  hand, newly generated poker hand
     */
    public hand drawFive() {
        hand h = new hand();
        for (int i = 0; i <= 4; i++) {
            card c = dck.draw(i);
            h.addCard(c);
        }
        return h;
    }

    /**
     * drawCard takes a hand, adds a card to it, and returns the hand.
     * @param h hand, the hand you want to add a card to
     * @return  returns the hand with the new card added
     */
    public hand drawCard(hand h) {
            card c = dck.draw(0);
            h.addCard(c);
        return h;
    }

    /**
     * @overload
     * returnCards takes all the cards in a hand, and returns them to the deck
     * @param h hand, hand to return to the deck
     */
    public void returnCards(hand h) {
        int size = h.getSize();
        for (int i = 0;i<size;i++) {
            dck.putBack(h.removeCard());
        }
    }

    /**
     * @overload
     * returnCards takes a hand and a specific card, it removes that card from the hand and
     * returns it to the deck.
     * @param h hand, hand that you want to remove card from
     * @param cardID   int, the position in the hand element of the card you want to remove
     * @return  hand, hand with card removed from it.
     */
    public hand returnCards(hand h, int cardID) {
            dck.putBack(h.removeCard(cardID));
        return h;
    }

    /**
     * void method shuffles the deck and returns nothing.
     */
    public void shuffle() {
        dck.shuffle();
    }

    /**
     * isPair takes a hand and determines if there is a pair. If it is, it sets a global variable and
     * returns the hand with the pair removed.
     * @param h hand, the hand you would like to evaluate.
     * @return  hand, hand with the pair removed, if there was one.
     */
    public hand isPair(hand h) {
        if (h.getSize()<2){
        return h;
    }
        ArrayList<Rank> ranks = h.getRanks();
        for (int i = 0; i <= ranks.size()-2; i++) {

            if (ranks.get(i) == ranks.get(i + 1)) {
                isPair= true;
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                return h;
            }}
        return h;
    }
    /**
     * isTriple takes a hand and determines if there is a Three of a Kind. If it is, it sets a global variable and
     * returns the hand with the Three of a Kind removed.
     * @param h hand, the hand you would like to evaluate.
     * @return  hand, hand with the Three of a Kind removed, if there was one.
     */
    public hand isTriple(hand h) {
        ArrayList<Rank> ranks = h.getRanks();
        if(h.getSize()<=3){
            return h;
        }
        for (int i = 0; i <= ranks.size()-3; i++) {
            if (ranks.get(i) == ranks.get(i + 1) && ranks.get(i + 1) == ranks.get(i + 2)) {
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                isTriple = true;
                return h;
            }
        }
        return h;
    }
    /**
     * isQuadruple takes a hand and determines if there is a Four of a Kind. If it is, it sets a global variable and
     * returns the hand with the Four of a Kind removed.
     * @param h hand, the hand you would like to evaluate.
     * @return  hand, hand with the Four of a Kind removed, if there was one.
     */
    public hand isQuadruple(hand h) {
        ArrayList<Rank> ranks = h.getRanks();
        if (h.getSize()<=4){
            return h;
        }
        for (int i = 0; i <= ranks.size()-4; i++) {
            if (ranks.get(i) == ranks.get(i + 1) && ranks.get(i + 1) == ranks.get(i + 2) && ranks.get(i + 2) == ranks.get(i + 3)) {
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                dck.putBack(h.removeCard(ranks.get(i)));
                isQuadruple= true;
                return h;
            }
        }
        return h;
    }

    /**
     * isStraight takes a hand and determines if there are 5 cards in order. If there is it sets a global variable
     * and returns the entire hand
     * @param h hand, hand to be evaluated
     * @return  the hand that was supplied
     */
    public hand isStraight(hand h){
        if(h.getSize()<5){
            return h;
        }
        ArrayList<Rank> ranks = h.getRanks();
        ArrayList<Integer> cardRank = new ArrayList<>();
        for (Rank rank : ranks) {
            cardRank.add(rank.getValue());
        }
        //if there's an Ace, it can be high or low
        if(cardRank.get(0)==1){
            //check low ace
            if(cardRank.get(1)==2&&cardRank.get(2)==3&&cardRank.get(3)==4&&cardRank.get(4)==5){
                isStraight=true;
                return h;
            }
            //check high ace
            if(cardRank.get(1)==10&&cardRank.get(2)==11&&cardRank.get(3)==12&&cardRank.get(4)==13){
                isStraight=true;
                return h;
            }
        }
        //check everything else
        if(cardRank.get(1)==cardRank.get(0)+1&&cardRank.get(1)+1==cardRank.get(2)&&cardRank.get(3)==cardRank.get(2)+1&&cardRank.get(4)==cardRank.get(3)+1){
            isStraight=true;
            return h;
        }
        return h;
    }

    /**
     * isFlush takes a hand and determines whether they all have the same suit. If they do, it sets a global
     * variable and returns the hand that was supplied.
     * @param h hand, hand to be evaluated
     * @return hand, the same hand that was supplied
     */
    public hand isFlush(hand h) {
        if(h.getSize()<5){
            return h;
        }
        ArrayList<Suit> suits = h.getSuits();
        if (suits.get(0) == suits.get(1) && suits.get(1) == suits.get(2) && suits.get(2) == suits.get(3) && suits.get(3) == suits.get(4)) {
            isFlush= true;
            return h;
        }
        return h;
    }

    /**
     * This method checks to see whether both the isTriple and isPair global variables were set to True,
     * if they were, this method sets a global variable to true and returns an empty hand. isTriple() and
     * isPair() must be run before this method.
     * @param h hand, hand to be evaluated
     * @return  hand, returns hand if it is not a full house, null if it is.
     */
    public hand isFullHouse(hand h){
        if(isTriple&&isPair){
            isFullHouse= true;
            return null;
        }
        return h;
    }

    /**
     * isStraightFlush evaluates whether a hand is a straight flush or not by checking to see if the
     * isStraight and isFlush global variables have been set to true. isStraight() and isFlush() must
     * be run before this method
     * @param h hand, hand to be evaluated
     * @return  the same had that was supplied
     */
    public hand isStraightFlush(hand h){
        if(isStraight&&isFlush){
            isStraightFlush= true;
            return h;
        }
            return h;
    }

    /**
     * isRoyalFlush evaluated whether a hand is a royal flush. It checks to see if StraightFlush was
     * set to true, if it was, it checks to see if there is an Ace and a King in the correct spot on the
     * ordered rank list that is stored in hand. If it is, it sets the global variable to true and returns
     * the same hand. isStraightFlush() must be run before this method.
     * @param h hand, hand to be evaluated
     * @return  hand, the same hand that was supplied.
     */
    public hand isRoyalFlush(hand h){
        ArrayList<Rank> ranks = h.getRanks();
        if(isStraightFlush&&ranks.get(0)==Rank.Ace&&ranks.get(4)==Rank.King){
            isRoyalFlush= true;
            return h;
        }
        return h;
    }

    /**
     * isTwoPair() checks to see if there already was a pair by checking the global variable. If there
     * was, it runs isPair() again and checking to see if it changed the global variable again. If it does, it
     * sets its variable to true and returns the hand that was supplied. isPair() must be run before this method.
     * @param h hand, hand to be evaluated
     * @return hand, the same hand that was supplied as parameter.
     */
    public hand isTwoPair(hand h){
        if(isPair){ //first check to see if there was already a pair found
            isPair=false; //set that to false
            isPair(h); //run it again
            if(isPair){//if it was set to true again, there must be a second one.
                isTwoPair=true;
                return h;
            }
            isPair=true; //if we get here, there wasn't a second one.
        }
        return h;
    }

    /**
     * checks all the global variables and sets its own if they were all false.
     */
    public void isNothing(){
        if(!isPair&&!isTriple&&!isQuadruple&&!isFlush&&!isFullHouse&&!isTwoPair&&!isStraight&&!isStraightFlush&&!isRoyalFlush){
            isNothing = true;
        }
    }

    /**
     * used after every evaluation to reset all the global variables.
     * takes no parameters
     * returns nothing.
     */
    public void reset(){
        isRoyalFlush=false;
        isStraightFlush=false;
        isQuadruple=false;
        isFullHouse=false;
        isFlush=false;
        isStraight=false;
        isTriple=false;
        isTwoPair=false;
        isPair=false;
        isNothing=false;
        handString ="";
        resultID=15;
    }

    /**
     * main driver for this method. Does all the evaluations correctly from above. Takes a hand as a
     * parameter and returns an arrayList of booleans that correspond to what the hand was evaluated as
     * I don't use the booleans in this program, but I did it this way in case I wanted to feed it into a
     * statistics method that kept track of more detailed gameplay. This method is meant to be called
     * from other methods.
     *
     * @param h hand, hand to be evaluated
     * @return  ArrayList<boolean> boolean arraylist that corresponds to what the card was evaluated as.
     */
    public ArrayList<Boolean> evaluate(hand h){
    ArrayList<Boolean> results = new ArrayList<>();
    if(h!=null){h= isStraight(h);}
    if(h!=null){h=isFlush(h);}
    if(h!=null){h=isStraightFlush(h);}
    if(h!=null){h=isRoyalFlush(h);}
    if(h!=null){h=isQuadruple(h);}
    if(h!=null){h=isTriple(h);}
    if(h!=null){h=isPair(h);}
    if(h!=null){h=isFullHouse(h);}
    if(h!=null){h= isTwoPair(h);}
    if(h!=null){isNothing();}
    results.add(isRoyalFlush);
    results.add(isStraightFlush);
    results.add(isQuadruple);
    results.add(isFullHouse);
    results.add(isFlush);
    results.add(isStraight);
    results.add(isTriple);
    results.add(isTwoPair);
    results.add(isPair);
    results.add(isNothing);
    results=scrubResults(results);
    return results;

    }

    /**
     * @override
     * toString returns a string of what the hand was evaluated as. Human Readable.
     * @return  String, human-readable format of what the hand was evaluated to be.
     */
    public String toString(){
        return handString;
    }

    /**
     * scrubResults takes that boolean ArrayList and sets the highest hand as the only
     * one that is true. This makes it so the program doesn't count a Royal Flush as a Royal Flush,
     * Straight Flush, Straight, and Flush. It only counts it as a Royal FLush for instance.
     * This method also sets the toString value.
     * This method returns an ArrayList of booleans, I don't use this but can be used in the future.
     * @param results   ArrayList<Boolean> the results from the evaluate method.
     * @return  scrubbed ArrayList<Boolean> with only the highest one set to True
     */
    public ArrayList<Boolean> scrubResults(ArrayList<Boolean> results){
        for(int i =0;i<results.size();i++){
            if(results.get(i)){
                switch (i) {
                    case 0 -> {
                        handString = "ROYAL FLUSH";
                        resultID = 0;
                    }
                    case 1 -> {
                        handString = "Straight Flush";
                        resultID = 1;
                    }
                    case 2 -> {
                        handString = "Four of a Kind";
                        resultID = 2;
                    }
                    case 3 -> {
                        handString = "Full House";
                        resultID = 3;
                    }
                    case 4 -> {
                        handString = "Flush";
                        resultID = 4;
                    }
                    case 5 -> {
                        handString = "Straight";
                        resultID = 5;
                    }
                    case 6 -> {
                        handString = "Three of a Kind";
                        resultID = 6;
                    }
                    case 7 -> {
                        handString = "Two Pair";
                        resultID = 7;
                    }
                    case 8 -> {
                        handString = "Pair";
                        resultID = 8;
                    }
                    case 9 -> {
                        handString = "Nothing";
                        resultID = 9;
                    }
                    default -> handString = "ERROR";
                }
                for(int j =i+1;j<results.size();j++){
                    results.set(j,false);
                }
                return results;
            }
        }
        return results;
    }

    /**
     * accessor that gets an int that corresponds to what the hand was evaluated as.
     * @return  int, ID of the poker hand rank.
     */
    public int getResultID(){
        return resultID;
    }
}

