/**
 * @author Daniel Woods
 * This method is the main interface between the user and the under the hood section of this code.
 * This method will ask for input and display output. It will call the appropriate methods from dealer,
 * and hand to run the game properly.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class play {
    dealer deal;
    hand h1;
    hand h2;
    final Scanner scan = new Scanner(System.in);
    boolean done = false;

    /**
     * constructor play takes no parameters. It starts gathering information by asking
     * for keyboard input from the user.
     */
    public play() {
        while(! done){//This loop is just here to catch invalid input.
        deal = new dealer();
        System.out.println("Would you like to play? or run a Monte Carlo Simulation?\n1:\tPlay 2 hands\n2:\tPlay Single Player\n3:\tMonte Carlo Simulation");
        int response= scan.nextInt();
        scan.nextLine();//consume the carriage return for the next input
            switch (response) {
                case 1 -> {
                    playGame();
                    done = true;
                }
                case 2 -> {
                    playGame(1000);
                    done = true;
                }
                case 3 -> {
                    System.out.println("How many games would you like to simulate?");
                    simulate(scan.nextInt());
                    done = true;
                }
                default -> System.out.println("Invalid Selection");
            }
        }}

    /**
     * {@code @overload}
     * playGame is a method that is called to play 2 hands against each other. It will draw cards, evaluate them, and determine a winner
     * if there is one. This method will print out the results and returns nothing
     */
        public void playGame(){
            h1 = deal.drawFive();
            h2 = deal.drawFive();
            System.out.println("Hand 1: " + h1.toString() + "\nCard ID: 1  2  3  4  5\nHand 2: " + h2.toString()+"\nCard ID: 1  2  3  4  5");
            System.out.println("Player 1, would you like to return any cards to the deck?(y/n)");
            String ans = scan.nextLine();
            switch (ans) {
                case "y", "Y", "yes", "Yes" -> {
                    System.out.println("Please specify card ID with no separation. (Example 13)");
                    String ids = scan.nextLine();
                    for (int i = 0; i < ids.length(); i++) {
                        int cardID = ids.charAt(i) - '0' - 1;
                        h1 = remove(h1, cardID - i);
                    }
                    h1 = fillHand(h1);
                    System.out.println("Hand 1: " + h1.toString() + "\nHand 2: " + h2.toString());
                }
            }
            System.out.println("Player 2, would you like to return any cards to the deck?(y/n)");
            String ans2 = scan.nextLine();
            switch (ans2) {
                case "y", "Y", "yes", "Yes" -> {
                    System.out.println("Please specify card ID with no separation (Example 15)");
                    String ids = scan.nextLine();
                    for (int i = 0; i < ids.length(); i++) {
                        int cardID = ids.charAt(i) - '0' - 1;
                        h2 = remove(h2, cardID - i);
                    }
                    h2 = fillHand(h2);
                    System.out.println("Hand 1: " + h1.toString() + "\nHand 2: " + h2.toString());
                }
            }
            System.out.println(evaluate(h1,h2));
        }

    /**
     * @overload
     * playGame is for playing single player. You specify how many coins a player will start with. This
     * will then run until the number of coins left is less than or equal to 0. All keyboard input is solicited
     * in this method, and all printing is done in this method as well.
     * @param coins
     */
    public void playGame(int coins){
        while(coins>0){
        h1 = deal.drawFive();
        System.out.println("Hand: " + h1.toString() + "\nCard ID: 1  2  3  4  5");
        System.out.println("Would you like to return any cards to the deck? (y/n)");
        String ans = scan.nextLine();
            switch (ans) {
                case "y", "Y", "yes", "Yes" -> {
                    System.out.println("Please specify card ID with no separation. (Example 13)");
                    String ids = scan.nextLine();
                    for (int i = 0; i < ids.length(); i++) {
                        int cardID = ids.charAt(i) - '0' - 1;
                        h1 = remove(h1, cardID - i);
                    }
                    h1 = fillHand(h1);
                    System.out.println("Hand: " + h1.toString());
                }
            }

            coins=evaluate(h1,coins);
        }
    }

    /**
     * simulate is a method that takes the number of games you would like to simulate
     * and runs the simulation of that many games. It keeps a tally of the results and prints them to console at the
     * end.
     * @param numGames  int number of games you would like to simulate
     */
        public void simulate(int numGames){
        int rf=0;
        int sf=0;
        int fk=0;
        int fh=0;
        int f = 0;
        int s = 0;
        int tk=0;
        int tp = 0;
        int p = 0;
        int n=0;
        int err=0;
        for(int i = 0; i<numGames;i++){
            hand h = deal.drawFive();
            deal.evaluate(h);
            switch (deal.getResultID()) {
                case 0 -> rf++;
                case 1 -> sf++;
                case 2 -> fk++;
                case 3 -> fh++;
                case 4 -> f++;
                case 5 -> s++;
                case 6 -> tk++;
                case 7 -> tp++;
                case 8 -> p++;
                case 9 -> n++;
                default -> err++;
            }
            deal.reset();
            deal.returnCards(h);
            deal.shuffle();
        }
            String leftAlignFormat = "| %-17s | %-16d | %-18f |%n";
            System.out.println("Game played: "+numGames+" times");
            System.out.format("+-------------------+------------------+--------------------+%n");
            System.out.format("|       Hand        | Number of Times  | Percent of Times   |%n");
            System.out.format("+-------------------+------------------+--------------------+%n");
            System.out.format(leftAlignFormat, "Royal Flush" , rf,percent(rf,numGames));
            System.out.format(leftAlignFormat, "Straight Flush" , sf,percent(sf,numGames));
            System.out.format(leftAlignFormat, "Four of a Kind" , fk,percent(fk,numGames));
            System.out.format(leftAlignFormat, "Full House" , fh,percent(fh,numGames));
            System.out.format(leftAlignFormat, "Flush" , f,percent(f,numGames));
            System.out.format(leftAlignFormat, "Straight" , s,percent(s,numGames));
            System.out.format(leftAlignFormat, "Three of a Kind" , tk,percent(tk,numGames));
            System.out.format(leftAlignFormat, "Two Pair" , tp,percent(tp,numGames));
            System.out.format(leftAlignFormat, "Pair" , p,percent(p,numGames));
            System.out.format(leftAlignFormat, "Nothing" , n,percent(n,numGames));
            System.out.format("+-------------------+------------------+--------------------+%n");
        }

    /**
     * takes a hand and a cardID. it removes the card from the hand and returns the hand.
     * @param h hand you would like to remove from
     * @param cardID    position in list of the card you would like to remove
     * @return  hand with the card removed
     */
    public hand remove(hand h, int cardID){
        return deal.returnCards(h,cardID);

    }

    /**
     * fillHand takes a hand and if the hand has less than 5 cards, fill hand will add card until there are
     * five of them. It returns the hand with the new cards
     * @param h Hand that you would like to fill to 5
     * @return  Hand new hand that has been filled
     */
    public hand fillHand(hand h){
        hand newH=null;
        if(h.getSize()<4){
            for(int i = h.getSize();i<=4;i++){
                newH=deal.drawCard(h);
            }
        }
        return newH;
    }

    /**
     * @overload
     * evaluate takes 2 hands and runs the rest of the game on them. It runs the evaluations and generates
     * a string. This method is for the game of 2 hands. This method is meant to be printed.
     * @param h1   Hand Player 1's hand
     * @param h2    Hand Player 2's hand
     * @return  String printable string that summarizes the game
     */
    public String evaluate(hand h1, hand h2){
        ArrayList<Boolean> results1=deal.evaluate(h1);
        String hand1String=deal.toString();
        deal.reset();
        ArrayList<Boolean> results2=deal.evaluate(h2);
        String hand2String=deal.toString();
        deal.reset();
        for(int i = 0; i<results1.size();i++){
            if(results1.get(i)&&results2.get(i)){
                return "Tie:\nHand 1: "+hand1String+" \nHand 2: "+hand2String;
            }
            if(results1.get(i)){
                return "Hand 1 beats Hand 2:\nHand 1: "+hand1String+" \nHand 2: "+hand2String;
            }
            if(results2.get(i)){
                return "Hand 2 beats Hand 1:\nHand 1: "+hand1String+" \nHand 2: "+hand2String;
            }
        }
        return "Error";
    }

    /**
     * @overload
     * evaluate is meant to take a hand and number of coins for the single player version of the game.
     * It takes the number of coins and the hand, evaluates the hand and returns the new
     * number of coins based on what the hand was
     * @param hand  hand the hand to be evaluated.
     * @param coins int the number of coins the player has.
     * @return  int the new number of coins the player has after evaluation.
     */
    public int evaluate(hand hand,int coins){
        deal.evaluate(hand);
        switch (deal.getResultID()) {
            case 0 -> {
                coins = coins * 1000;
                System.out.println("ROYAL FLUSH " + "\uD83E\uDE99 " + coins);
            }
            case 1 -> {
                coins = coins * 950;
                System.out.println("STRAIGHT FLUSH " + "\uD83E\uDE99 " + coins);
            }
            case 2 -> {
                coins = coins * 250;
                System.out.println("Four of a Kind " + "\uD83E\uDE99 " + coins);
            }
            case 3 -> {
                coins = coins * 100;
                System.out.println("Full House " + "\uD83E\uDE99 " + coins);
            }
            case 4 -> {
                coins = coins * 60;
                System.out.println("Flush " + "\uD83E\uDE99 " + coins);
            }
            case 5 -> {
                coins = coins * 40;
                System.out.println("Straight " + "\uD83E\uDE99 " + coins);
            }
            case 6 -> {
                coins = coins * 20;
                System.out.println("Three of a Kind " + "\uD83E\uDE99 " + coins);
            }
            case 7 -> {
                coins = coins * 10;
                System.out.println("Two Pair " + "\uD83E\uDE99 " + coins);
            }
            case 8 -> {
                coins = coins * 2;
                System.out.println("Pair " + "\uD83E\uDE99 " + coins);
            }
            case 9 -> {
                coins = coins - 100;
                System.out.println("Nothing :" + "\uD83E\uDE99 " + coins);
            }
        }
        deal.reset();
        return coins;
    }

    /**
     * returns the double percent of a part and a whole
     * @param howMany int the part of the whole
     * @param outOf int the whole
     * @return  double percent of the part divided by the whole
     */
    public double percent(int howMany, int outOf){
        return 100*((double)howMany/(double) outOf);
    }



}
